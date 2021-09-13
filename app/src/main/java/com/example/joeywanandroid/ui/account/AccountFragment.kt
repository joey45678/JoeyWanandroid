package com.example.joeywanandroid.ui.account

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.joeywanandroid.databinding.FragmentAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {
    var a = 1
    private val TAG = "AccountFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate: " )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        a++
        Log.e(TAG, "onCreateView: $a" )
        // val binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }


}