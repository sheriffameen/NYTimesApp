package com.example.nytimesapplication.repository

import com.example.nytimesapplication.api.APIHelper
import com.example.nytimesapplication.api.APIService
import javax.inject.Inject

class GithubOrgRepository @Inject constructor(private val apiHelper: APIHelper) {

    suspend fun getOrganization(orgName: String) = apiHelper.getOrganizations(orgName).body()?.sortedBy { it.stargazersCount }?.take(3)
}