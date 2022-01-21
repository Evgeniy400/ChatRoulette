package com.example.chatroulette.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsetsAnimation
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.chatroulette.adapter.FeedPagerAdapter
import com.example.chatroulette.databinding.ActivityFeedBinding
import com.example.chatroulette.databinding.ActivityFormBinding
import com.example.chatroulette.viewmodels.FeedViewModel
import com.example.chatroulette.viewmodels.FormViewModel

class FeedActivity : FragmentActivity() {
    private lateinit var binding: ActivityFeedBinding
    private lateinit var vm: FeedViewModel
    private lateinit var vmProfile: FormViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(this).get(FeedViewModel::class.java)
        vmProfile = ViewModelProvider(this).get(FormViewModel::class.java)

        binding.imageButtonProfile.setOnClickListener{
            startActivity(Intent(this, ProfileActivity::class.java).apply {
                putExtra(ProfileActivity.PROFILE, vmProfile.profile.value)
            })
        }


        vm.peoples.observe(this){
            binding.viewPager.adapter = FeedPagerAdapter(this, it)
        }

    }
}