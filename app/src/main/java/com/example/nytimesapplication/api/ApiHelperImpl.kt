package com.example.nytimesapplication.api

import com.example.nytimesapplication.models.GithubOrganization
import com.example.nytimesapplication.models.GithubResponse
import javax.inject.Inject
import retrofit2.Response

class ApiHelperImpl @Inject constructor(private val apiService: APIService): APIHelper {
    override suspend fun getOrganizations(orgName: String): Response<List<GithubOrganization>> = apiService.getOrganizations(orgName)
}