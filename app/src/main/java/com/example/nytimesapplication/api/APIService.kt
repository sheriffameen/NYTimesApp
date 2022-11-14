package com.example.nytimesapplication.api

import com.example.nytimesapplication.models.GithubOrganization
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("/orgs/{org}/repos")
    suspend fun getOrganizations(@Path("org") organization: String): Response<List<GithubOrganization>>
}