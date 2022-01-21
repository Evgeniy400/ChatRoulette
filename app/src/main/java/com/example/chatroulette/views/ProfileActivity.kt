package com.example.chatroulette.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import coil.Coil
import coil.load
import coil.loadAny

import coil.transform.*
import com.example.chatroulette.R
import com.example.chatroulette.databinding.ActivityProfileBinding
import com.example.chatroulette.model.Profile
import com.example.chatroulette.viewmodels.FormViewModel

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.getParcelable<Profile>(PROFILE)?.let {
            setData(it)
        }
    }

    private fun setData(profile: Profile) {
        binding.apply {
            imageView.loadAny(profile.photo)
            city.text = profile.city
            name.text = profile.name
        }
    }

    companion object {
        const val PROFILE = "profile"
    }
}