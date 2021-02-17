package com.garmin.garminkaptain.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.garmin.garminkaptain.R
import com.garmin.garminkaptain.data.poiList

class ReviewListFragment : Fragment(R.layout.review_list_fragment) {
    private val args: PoiDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val poiId = args.poiId
        val poi = poiList.find { it.id == poiId } ?: return

        view.findViewById<RecyclerView>(R.id.review_list).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ReviewListAdapter(poi.reviews.sortedByDescending { it.dateCreated })
        }
    }
}