package com.example.nytimesapplication.api

import com.example.nytimesapplication.models.GithubOrganization
import com.example.nytimesapplication.models.GithubResponse
import retrofit2.Response

interface APIHelper {
    suspend fun getOrganizations(orgName: String): Response<List<GithubOrganization>>
}