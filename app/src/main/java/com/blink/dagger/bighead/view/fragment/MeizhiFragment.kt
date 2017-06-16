package com.blink.dagger.bighead.view.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.blink.dagger.bighead.R
import com.blink.dagger.bighead.common.CommonRecyclerAdapter
import com.blink.dagger.bighead.model.MeizhiModel
import com.blink.dagger.bighead.net.response.MeizhiRes
import com.blink.dagger.bighead.presenter.MeizhiPresenter
import com.blink.dagger.bighead.view.activity.MeizhiDetailActivity
import com.blink.dagger.bighead.view.iview.IMeizhiView
import com.blink.dagger.bighead.widget.RefreshRecyclerView
import kotlinx.android.synthetic.main.fragment_meizhi.*


/**
 * A simple [Fragment] subclass.
 */
class MeizhiFragment : BaseFragment<IMeizhiView,MeizhiPresenter>(),IMeizhiView {

    var page = 1
    var meizhiAdapter: CommonRecyclerAdapter<MeizhiRes.ResultsBean>? = null
    var meizhiData :ArrayList<MeizhiRes.ResultsBean>?= ArrayList<MeizhiRes.ResultsBean>()

    override fun showLoading() {

    }

    override fun showContent() {
    }

    override fun setData(data: MeizhiModel) {
        meizhiData?.clear()
        meizhiData?.addAll(data.results!!)
        meizhiAdapter?.notifyDataSetChanged()
        meizhiContent.setRecyclerViewScrollToPosition(0)
    }

    override fun createPresenter(): MeizhiPresenter {
        return MeizhiPresenter(context)
    }

    override fun initViews() {

        meizhiAdapter = object : CommonRecyclerAdapter<MeizhiRes.ResultsBean>(context,R.layout.item_meizhi,meizhiData){
            override fun convert(holder: ViewHolder, t: MeizhiRes.ResultsBean, position: Int) {
                holder.setImageURI(R.id.meizhiImg, t.url as String)
            }
        }

        (meizhiAdapter as CommonRecyclerAdapter<MeizhiRes.ResultsBean>).setOnRecyclerViewItemClickListener(object : CommonRecyclerAdapter.OnRecyclerViewItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                val intent:Intent = Intent(context,MeizhiDetailActivity::class.java)
                intent.putExtra("url",meizhiData?.get(position)?.url)
                startActivity(intent)
            }
        })

        meizhiContent?.setMyRecyclerView(StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL),meizhiAdapter)

        val headText = TextView(context)
        headText.text = "放开我~你就能刷新了哦(●'◡'●)"
        headText.gravity = Gravity.CENTER

        val footText = TextView(context)
        footText.text = "上滑可以看到更多萌妹纸哦(lll￢ω￢)"
        meizhiContent?.addHeaderView(headText,100)
        footText.gravity = Gravity.CENTER
        meizhiContent?.addFooterView(footText,100)
    }

    override fun initData() {
        presenter?.getMeizhiData(page)
    }

    override fun initListeners() {
        meizhiContent?.addOnTouchUpListener(object : RefreshRecyclerView.OnTouchUpListener{
            override fun onRefresh() {
                page = 1
                presenter?.getMeizhiData(page)
            }

            override fun onLoadMore() {
                presenter?.getMeizhiData(++page)
            }

        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_meizhi, container, false)
    }

}
