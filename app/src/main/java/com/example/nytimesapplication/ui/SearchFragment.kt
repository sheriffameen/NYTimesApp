package com.example.nytimesapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nytimesapplication.adapter.GithubOrganizationAdapter
import com.example.nytimesapplication.databinding.FragmentSearchBinding
import com.example.nytimesapplication.ui.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)





        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val githubAdapter = GithubOrganizationAdapter {

        }

        binding.idLVProgrammingLanguages.adapter = githubAdapter

        viewModel.res.observe(viewLifecycleOwner) {
            githubAdapter.submitList(it.data)
        }

        binding.idSV.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (!p0.isNullOrEmpty()){
                    viewModel.getOrganizations(p0)

                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}