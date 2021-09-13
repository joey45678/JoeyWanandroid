package com.example.joeywanandroid.ui.website

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.joeywanandroid.databinding.FragmentWebsiteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebsiteFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // val binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val binding = FragmentWebsiteBinding.inflate(inflater, container, false)
        return binding.root
    }


}