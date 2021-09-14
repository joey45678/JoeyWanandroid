package com.example.joeywanandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.joeywanandroid.R


abstract class BaseFragmentWithList<VB: ViewDataBinding,VM:ViewModel>: Fragment() {
    private val TAG = "BaseFragment"
    lateinit var binding:VB
    lateinit var viewModel:VM
    lateinit var loadingListHolder:RecyclerView

    lateinit var layout:View
    lateinit var mainContentView:View
    var loadingFaildView:View?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_base_with_list, null)
        val baseFrgContainer = layout.findViewById<ViewGroup>(R.id.basefrg_container)
        val parent = baseFrgContainer.parent as ViewGroup
        loadingListHolder = layout.findViewById(R.id.loading_list_holder)
        parent.removeView(baseFrgContainer)
        binding = DataBindingUtil.inflate<VB>(activity?.layoutInflater!!, setLayoutId(), null, false)
        baseFrgContainer.addView(binding.root)
        mainContentView = binding.root
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = setViewModel()
        loadingListHolder.adapter = LoadingListHolderAdapter()
    }

   abstract fun setLayoutId():Int
   abstract fun setViewModel():VM
   abstract fun retry(showList:Boolean = true)
    fun showLoadingFaild(){
        if (loadingFaildView==null) {
            val vstub = layout.findViewById<ViewStub>(R.id.loading_faild)
            loadingFaildView = vstub.inflate()
            loadingFaildView?.visibility = View.VISIBLE
            vstub.visibility = View.VISIBLE
            val retry = loadingFaildView?.findViewById<Button>(R.id.retry)
            retry?.setOnClickListener {
                retry()
            }
        }

        loadingFaildView?.visibility = View.VISIBLE
        mainContentView.visibility =View.GONE
    }
}