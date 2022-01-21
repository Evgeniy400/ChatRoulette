package com.example.chatroulette.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatroulette.db.ProfileBase
import com.example.chatroulette.model.Profile

class FeedViewModel: ViewModel() {
    private var peoples_ = MutableLiveData(ProfileBase.getProfileBase().ankets)
    var peoples: LiveData<List<Profile>> = peoples_
}