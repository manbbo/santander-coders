package com.example.snackbar.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.snackbar.fragments.MyAdapter
import com.example.snackbar.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent().extras
        setContentView(R.layout.activity_main)

        my_toolbar.title = "MyWallet"
        my_toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_backbt)

        setSupportActionBar(my_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        my_toolbar.setNavigationOnClickListener {
            finish()
        }

        var navigationView = tablayout
        var viewPager = fragment

        navigationView!!.addTab(navigationView.newTab().setText("Home"))
        navigationView!!.getTabAt(0)!!.setIcon(R.drawable.ic_home)

        navigationView!!.addTab(navigationView.newTab().setText("Entradas"))
        navigationView!!.getTabAt(1)!!.setIcon(R.drawable.ic_entries)

        navigationView!!.addTab(navigationView.newTab().setText("Gastos"))
        navigationView!!.getTabAt(2)!!.setIcon(R.drawable.ic_money)

        navigationView!!.tabGravity = TabLayout.GRAVITY_FILL

        var adapter = MyAdapter(this,
            supportFragmentManager,
            navigationView!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(navigationView!!))

        navigationView!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}