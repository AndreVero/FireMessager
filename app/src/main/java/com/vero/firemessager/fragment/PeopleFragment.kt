package com.vero.firemessager.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ListenerRegistration

import com.vero.firemessager.R
import com.vero.firemessager.util.FirestoreUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.fragment_people.*

class PeopleFragment : Fragment() {

    private lateinit var userListnerRegistration: ListenerRegistration

    private var shouldInitRecyclerView = true

    private lateinit var peopleSection: Section

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        userListnerRegistration = FirestoreUtil.addUsersListener(this.activity!!, this::updateRecyclerView)
        return inflater.inflate(R.layout.fragment_people, container, false)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        FirestoreUtil.removeListner(userListnerRegistration)
        shouldInitRecyclerView = true
    }
    private fun updateRecyclerView(items: List<Item>) {

        fun init() {
            recycler_view_people.apply {
                layoutManager = LinearLayoutManager(this@PeopleFragment.context)
                adapter = GroupAdapter<ViewHolder>().apply {
                    peopleSection = Section(items)
                    add(peopleSection)
                }
            }
            shouldInitRecyclerView = false
        }

        fun updateItems() {

        }

        if(shouldInitRecyclerView) {
            init()
        } else {
            updateItems()
        }
    }


}
