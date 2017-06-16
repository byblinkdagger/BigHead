package com.blink.dagger.bighead.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.blink.dagger.bighead.R
import com.blink.dagger.bighead.model.MovieDetailModel
import com.blink.dagger.bighead.presenter.MovieDetailPresenter
import com.blink.dagger.bighead.view.iview.IMovieDetailView

class MovieDetailActivity : BaseActivity<IMovieDetailView,MovieDetailPresenter>(),IMovieDetailView {
    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showContent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setData(data: MovieDetailModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createPresenter(): MovieDetailPresenter {
        return MovieDetailPresenter()
    }

    override fun getContentView(): View {
        var view:View = LayoutInflater.from(this).inflate(R.layout.activity_movie_detail,null)
        return view
    }

    override fun initViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
