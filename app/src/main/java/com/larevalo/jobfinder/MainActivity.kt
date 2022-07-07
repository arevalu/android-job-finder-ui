package com.larevalo.jobfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.larevalo.jobfinder.databinding.ActivityMainBinding
import com.larevalo.jobfinder.model.Job

class MainActivity : AppCompatActivity(), HomeFragment.JobSelectListener {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_container_nav)!!
        navController = navHostFragment.findNavController()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onJobSelected(job: Job) {
        navController.navigate(
            HomeFragmentDirections.actionHomeFragmentToJobDetailModalFragment(
                job
            )
        )
    }
}