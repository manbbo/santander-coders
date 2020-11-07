package com.example.snackbar.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.snackbar.R
import com.example.snackbar.fragments.spending.DetailGastosFragment
import com.example.snackbar.ui.ProfileActivity
import kotlinx.android.synthetic.main.cards_layout.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        return view

    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle?) =
                HomeFragment().apply {
                    arguments = bundle
                }
    }
}