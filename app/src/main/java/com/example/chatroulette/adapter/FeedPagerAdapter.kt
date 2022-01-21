package com.example.chatroulette.adapter

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chatroulette.model.Profile
import com.example.chatroulette.views.fragments.*

class FeedPagerAdapter(fa: FragmentActivity, peoples: List<Profile>) : FragmentStateAdapter(fa) {
    var ankets = peoples

    override fun getItemCount() = ankets.size

    override fun createFragment(position: Int) = PeopleFragment().also {
        it.arguments = Bundle().apply {
            putParcelable(PeopleFragment.PROFILE, ankets[position])
        }
    }
}