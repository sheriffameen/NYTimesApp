package com.example.nytimesapplication.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimesapplication.models.GithubOrganization
import com.example.nytimesapplication.models.GithubResponse
import com.example.nytimesapplication.repository.GithubOrgRepository
import com.example.nytimesapplication.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SearchViewModel @Inject constructor(private val githubOrgRepository: GithubOrgRepository) :
    ViewModel() {

    private val _res = MutableLiveData<Resource<List<GithubOrganization>>>()
    val res: LiveData<Resource<List<GithubOrganization>>>
        get() = _res

    fun getOrganizations(orgName: String) = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        githubOrgRepository.getOrganization(orgName).let {
            if (!it.isNullOrEmpty()){
                _res.postValue(Resource.success(it))
            }else{
                _res.postValue(Resource.error(it.toString(), null))
            }
        }
    }

}