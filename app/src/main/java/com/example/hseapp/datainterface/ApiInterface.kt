package com.example.hseapp.datainterface

import com.example.hseapp.dataclass.DataMe
import com.example.hseapp.dataclass.Question
import com.example.hseapp.dataclass.SignInBody
import com.example.hseapp.dataclass.safetycampaign
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiInterface {

    @FormUrlEncoded
    @POST("/api/auth/local")
    fun signin(
        @Field("identifier") identifier: String,
        @Field("password") password: String
    ): Call<SignInBody>

    @GET("/api/users/me?populate=*")
    fun getUserLogin(): Call<DataMe>

    @GET("/api/pertanyaans")
    fun getPertanyaans(@QueryMap filters: Map<String, String>): Call<Question>

    @GET("/api/jenispertanyaans?populate[gambar][fields][1]=url")
    fun getsafetycampaign(): Call<safetycampaign>
}