package com.example.translet_app_post.Retrofit

import com.example.translet_app_post.TransletModel.TransletModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST


interface TransletIInterface {

    @FormUrlEncoded
    @POST("/translate")
    fun transletLanguage(
        @Header("x-rapidapi-key") key: String = "663f5e77b9msh5c62de580d18723p1ddb9ejsn669adcb28ec3",
        @Header("x-rapidapi-host") host: String = "text-translator2.p.rapidapi.com",
        @Field("source_language") source: String,
        @Field("target_language") target: String,
        @Field("text") text: String,

        ): Call<TransletModel>

}