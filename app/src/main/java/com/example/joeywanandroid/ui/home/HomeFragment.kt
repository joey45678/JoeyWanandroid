package com.example.joeywanandroid.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.joeywanandroid.R
import com.example.joeywanandroid.bean.HotKeyBean
import com.example.joeywanandroid.databinding.FragmentHomeBinding
import com.example.joeywanandroid.ui.BaseFragmentWithList
import com.example.joeywanandroid.ui.HomeArticleAdapter
import com.example.joeywanandroid.ui.adapters.ImageAdapter
import com.zhy.view.flowlayout.TagAdapter
import dagger.hilt.android.AndroidEntryPoint
import android.widget.TextView
import android.widget.Toast
import com.example.joeywanandroid.bean.WebsiteBean
import com.zhy.view.flowlayout.FlowLayout


@AndroidEntryPoint
class HomeFragment : BaseFragmentWithList<FragmentHomeBinding, HomeViewModel>() {
    private val TAG = "HomeFragment"
    val homeArticleAdapter = HomeArticleAdapter()
    val imageBannerAdapter = ImageAdapter(null)
    override fun setLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun setViewModel(): HomeViewModel {
        val viewModel: HomeViewModel by viewModels()
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
        showBannerHolder()
        showLoading()
        binding.apply {
            homeTopArticles.adapter = homeArticleAdapter
            banner.addBannerLifecycleObserver(this@HomeFragment)
                .setAdapter(imageBannerAdapter)

            homeRefreshlayout.setOnRefreshListener {
                getHomeData()
            }
            homeRefreshlayout.setEnableLoadMore(false)
        }
        getHomeData()
        listenHomeData()

    }

    private fun listenHomeData() {

        viewModel.apply {

            homeLoadingFail.observe(viewLifecycleOwner, Observer {

                viewModel.apply {
                    if(homeHotKeyBeans.value!=null || homeTopArticleBeans.value!=null||homeFriendWebsiteBeans.value!=null||homeBannerBeans.value!=null)
                        Toast.makeText(this@HomeFragment.context,"加载失败，请检查网络或再次刷新~",Toast.LENGTH_SHORT).show()
                    else {
                        showLoadingFaild()
                        Toast.makeText(this@HomeFragment.context,"加载失败，请检查网络或再次刷新~",Toast.LENGTH_SHORT).show()
                    }
                    binding.homeRefreshlayout.finishRefresh()
                }

            })

            homeBannerBeans.observe(viewLifecycleOwner, Observer {
                imageBannerAdapter.setDatas(it)
            })
            homeHotKeyBeans.observe(viewLifecycleOwner, Observer {
                binding.homeSearchHotkey.adapter = object : TagAdapter<HotKeyBean>(it) {
                    override fun getView(parent: FlowLayout?, position: Int, t: HotKeyBean?): View {
                        val tv: TextView = layoutInflater.inflate(
                            R.layout.tag_hotkey,
                            binding.homeSearchHotkey, false
                        ) as TextView
                        tv.setText(it.get(position).name)
                        return tv
                    }
                }
            })
            homeFriendWebsiteBeans.observe(viewLifecycleOwner, Observer {
                binding.homeFriendWebsite.adapter = object : TagAdapter<WebsiteBean>(it) {
                    override fun getView(
                        parent: FlowLayout?,
                        position: Int,
                        t: WebsiteBean?
                    ): View {
                        val tv: TextView = layoutInflater.inflate(
                            R.layout.tag_website,
                            binding.homeFriendWebsite, false
                        ) as TextView
                        tv.setText(it.get(position).name)
                        return tv
                    }
                }
            })
            homeTopArticleBeans.observe(viewLifecycleOwner, Observer {
                homeArticleAdapter.articleBeans.addAll(it)
                homeArticleAdapter.notifyDataSetChanged()
                showMainContent()
                binding.homeRefreshlayout.finishRefresh()
            })
        }
    }

    private fun getHomeData() {

        viewModel.apply {
//                getHomeArticle()
//                getFriendWebsite()
//                getHomeBanner()
//                getHomeHotKey()
            getHomeTopArticle()
            getHomeBanner()
            getHomeHotKey()
            getFriendWebsite()
            //    test to parse json by manual operation
//                getHomeHotKey2()
//            showLoadingFaild()
        }
    }

    override fun retry(showList: Boolean) {
        showLoading()
        getHomeData()
    }




}