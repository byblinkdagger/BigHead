package com.blink.dagger.bighead.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import com.blink.dagger.bighead.R
import com.blink.dagger.bighead.model.MeizhiDetailModel
import com.blink.dagger.bighead.presenter.MeizhiDetailPresenter
import com.blink.dagger.bighead.view.iview.IMeizhiDetailView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_meizhi_detail.*

class MeizhiDetailActivity : BaseActivity<IMeizhiDetailView,MeizhiDetailPresenter>(),IMeizhiDetailView {

    var url:String = ""

    override fun showLoading() {

    }

    override fun showContent() {
    }

    override fun setData(data: MeizhiDetailModel) {
    }

    override fun createPresenter(): MeizhiDetailPresenter {
        return MeizhiDetailPresenter(this)
    }

    override fun getContentView(): View {
        val view:View = LayoutInflater.from(this).inflate(R.layout.activity_meizhi_detail,null)
        return view
    }

    override fun initViews() {

    }

    override fun initData() {
        url = intent.getStringExtra("url")
        Glide.with(this).load(url).into(meizhiImg)
    }

    override fun initListeners() {
    }

}
