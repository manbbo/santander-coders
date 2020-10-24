package com.example.snackbar.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class MyAdapter(private val myContext: Context,
                fm: FragmentManager,
                var totalTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) : Fragment {
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 -> {
                EntriesFragment()
            }
            2 -> SpendingFragment()
            else -> getItem(position)
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}