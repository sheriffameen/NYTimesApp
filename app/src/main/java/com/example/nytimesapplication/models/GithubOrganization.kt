package com.example.nytimesapplication.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GithubOrganization(
    val id: Int,
    val name: String,
    val url:String,
    @Json(name = "stargazers_count")
    val stargazersCount: Int

)