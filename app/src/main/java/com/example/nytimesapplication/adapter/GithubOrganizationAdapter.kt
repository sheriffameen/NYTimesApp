package com.example.nytimesapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesapplication.databinding.GithubOrgItemBinding
import com.example.nytimesapplication.models.GithubOrganization

class GithubOrganizationAdapter(private val onItemClicked: (GithubOrganization) -> Unit) :
    ListAdapter<GithubOrganization, GithubOrganizationAdapter.GithubOrgViewHolder>(
        DiffCallback
    ) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<GithubOrganization>() {
            override fun areItemsTheSame(
                oldItem: GithubOrganization,
                newItem: GithubOrganization
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: GithubOrganization,
                newItem: GithubOrganization
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


    class GithubOrgViewHolder(private var binding: GithubOrgItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(githubOrg: GithubOrganization){
                binding.name.text = githubOrg.name
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubOrgViewHolder {
        val viewHolder = GithubOrgViewHolder(
            GithubOrgItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: GithubOrgViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}