package com.example.proyecto.retrofit

import com.google.gson.annotations.SerializedName

data class ResponseRetro(
    @SerializedName("status") var status:String,
    @SerializedName("message") var images:List<String>
)