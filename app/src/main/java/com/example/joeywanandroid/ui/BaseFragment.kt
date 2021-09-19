package com.example.joeywanandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.joeywanandroid.R

/*
load failed
retry
 */
abstract class BaseFragment<VB: ViewDataBinding,VM:ViewModel>: Fragment() {
    private val TAG = "BaseFragment"
    lateinit var baseFrgContainer:ViewGroup
    lateinit var mainContentView:View
    lateinit var layout:View
    lateinit var binding:VB
    lateinit var viewModel:VM
    var loadingFaildView:View?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_base, null)
        baseFrgContainer = layout.findViewById<ViewGroup>(R.id.basefrg_container)

        val parent = baseFrgContainer.parent as ViewGroup
        parent.removeView(baseFrgContainer)
        binding = DataBindingUtil.inflate<VB>(activity?.layoutInflater!!, setLayoutId(), null, false)
        mainContentView = binding.root
        baseFrgContainer.addView(mainContentView)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = setViewModel()
    }

   abstract fun setLayoutId():Int
   abstract fun setViewModel():VM
   abstract fun retry()
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