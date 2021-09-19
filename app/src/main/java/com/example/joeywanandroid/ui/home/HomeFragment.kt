package com.example.joeywanandroid.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.joeywanandroid.R
import com.example.joeywanandroid.databinding.FragmentHomeBinding
import com.example.joeywanandroid.ui.BaseFragment
import com.example.joeywanandroid.ui.BaseFragmentWithList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragmentWithList<FragmentHomeBinding, HomeViewModel>() {
    private val TAG = "HomeFragment"

    override fun setLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun setViewModel(): HomeViewModel {
        val viewModel:HomeViewModel by viewModels()
        return viewModel
    }


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        Log.e(TAG, "onCreateView: $viewModel" )
//
//        // val binding = FragmentGalleryBinding.inflate(inflater, container, false)
//        val binding = FragmentHomeBinding.inflate(inflater, container, false)
//        return binding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState==null) {
            viewModel.apply {
                getHomeArticle()
                getFriendWebsite()
                getHomeBanner()
                getHomeHotKey()
                getHomeTopArticle()
                //    test to parse json by manual operation
//                getHomeHotKey2()
            }
//            showLoadingFaild()
        }

    }

    override fun retry(showList: Boolean) {
        TODO("Not yet implemented")
    }

//    override fun retry() {
//        Toast.makeText(context,"retry", Toast.LENGTH_SHORT).show()
//    }


}