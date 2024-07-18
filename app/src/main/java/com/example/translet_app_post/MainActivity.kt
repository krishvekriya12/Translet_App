package com.example.translet_app_post

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.translet_app_post.Retrofit.TransletClient.Companion.getTransletClient
import com.example.translet_app_post.Retrofit.TransletIInterface
import com.example.translet_app_post.TransletModel.TransletModel
import com.example.translet_app_post.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btntranslert.setOnClickListener {
            var text = binding.entertext.text.toString()
            transletedtext("en", "gu", text)
        }
    }

    private fun transletedtext(source: String, target: String, text: String) {
        val transletIInterface = getTransletClient()!!.create(TransletIInterface::class.java)
        transletIInterface.transletLanguage(source = source, target = target, text = text)
            .enqueue(object : Callback<TransletModel> {
                override fun onResponse(
                    call: Call<TransletModel>,
                    response: Response<TransletModel>
                ) {
                    if (response.isSuccessful) {
                        binding.txttransletdtext.text = response.body()!!.data!!.translatedText
                    }
                }

                override fun onFailure(call: Call<TransletModel>, t: Throwable) {
                }
            })
    }
}