package com.blink.dagger.bighead.view.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.blink.dagger.bighead.R
import com.blink.dagger.bighead.model.ReadDetailModel
import com.blink.dagger.bighead.presenter.ReadDetailPresenter
import com.blink.dagger.bighead.view.iview.IReadDetailView
import kotlinx.android.synthetic.main.activity_read_detail.*;
import android.graphics.Typeface



class ReadDetailActivity : BaseActivity<IReadDetailView,ReadDetailPresenter>(),IReadDetailView {

    var itemId:String = ""

    override fun showLoading() {
    }

    override fun showContent() {
    }

    override fun setData(data: ReadDetailModel) {
        readTitle.setText(data.data?.hp_title)
        readAuth.setText("文/"+data.data?.hp_author)
        readContent.setText(Html.fromHtml(data.data?.hp_content))
        readContent.letterSpacing = 0.2f
        readInfo.setText(data.data?.copyright)
    }

    override fun createPresenter(): ReadDetailPresenter {
        return ReadDetailPresenter(this)
    }

    override fun getContentView(): View {
        val view:View = LayoutInflater.from(this).inflate(R.layout.activity_read_detail,null)
        return view
    }

    override fun initViews() {
        val typeFace = Typeface.createFromAsset(assets, "RobotoLight.ttf")
        readContent.setTypeface(typeFace)
    }

    override fun initData() {
        itemId = intent.getStringExtra("itemId")
        presenter?.getReadDetail(itemId)
    }

    override fun initListeners() {
        readBack.setOnClickListener { v -> finish() }
    }

}
