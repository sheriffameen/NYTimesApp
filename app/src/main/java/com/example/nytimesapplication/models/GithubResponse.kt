package com.example.nytimesapplication.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GithubResponse(
    val data: List<GithubOrganization>? = null,
    val status: String? = ""
)