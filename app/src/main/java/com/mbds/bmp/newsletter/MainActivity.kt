package com.mbds.bmp.newsletter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.mbds.bmp.newsletter.databinding.ActivityMainBinding
import com.mbds.bmp.newsletter.fragments.CategoriesFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(baseContext))

        changeFragment(CategoriesFragment(), false)
    }

    fun changeFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            if(addToBackStack)
                addToBackStack(null)
        }.commit()
    }
}