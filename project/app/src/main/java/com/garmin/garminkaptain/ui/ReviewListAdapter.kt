package com.garmin.garminkaptain.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.garmin.garminkaptain.data.Review
import com.garmin.garminkaptain.databinding.ReviewListItemBinding

class ReviewListAdapter(private val reviews: List<Review>) :
    RecyclerView.Adapter<ReviewListAdapter.ReviewListItemViewHolder>() {
    class ReviewListItemViewHolder(private var binding: ReviewListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(review: Review) {
            binding.review = review
        }

        companion object {
            fun from(parent: ViewGroup): ReviewListItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ReviewListItemBinding.inflate(layoutInflater, parent, false)
                return ReviewListItemViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = reviews.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewListItemViewHolder {
        return ReviewListItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ReviewListItemViewHolder, position: Int) {
        reviews.getOrNull(position)?.let {
            holder.bind(it)
        }
    }
}