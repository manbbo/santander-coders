package com.example.snackbar.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.example.snackbar.MainActivity
import com.example.snackbar.fragments.MyAdapter
import com.example.snackbar.R
import com.example.snackbar.domain.Usuario
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_body.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

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
        navigationView!!.getTabAt(0)!!.icon!!.setColorFilter(ContextCompat.getColor(
                navigationView.context, R.color.colorRed),
                PorterDuff.Mode.SRC_IN)

        navigationView!!.addTab(navigationView.newTab().setText("Entradas"))
        navigationView!!.getTabAt(1)!!.setIcon(R.drawable.ic_entries)

        navigationView!!.addTab(navigationView.newTab().setText("Gastos"))
        navigationView!!.getTabAt(2)!!.setIcon(R.drawable.ic_money)

        navigationView!!.isInlineLabel = true
        navigationView.tabGravity = TabLayout.GRAVITY_FILL
        navigationView.setSelectedTabIndicatorColor(Color.WHITE)

        var adapter = MyAdapter(this,
            supportFragmentManager,
            navigationView!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(navigationView!!))

        navigationView!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position

                val tabIconColor = ContextCompat.getColor(
                        navigationView.context, R.color.colorRed)

                tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabIconColor = ContextCompat.getColor(
                        navigationView.context, R.color.colorWhite)

                tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }
            override fun onTabReselected(tab: TabLayout.Tab) {
                val tabIconColor = ContextCompat.getColor(
                        navigationView.context, R.color.colorRed)

                tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.profile -> {
                var intent = Intent(this, ProfileActivity::class.java)

                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}