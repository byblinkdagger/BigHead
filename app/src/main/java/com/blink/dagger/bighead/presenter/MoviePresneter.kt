package com.blink.dagger.bighead.presenter

import android.content.Context
import android.util.Log
import com.blink.dagger.bighead.model.MovieModel
import com.blink.dagger.bighead.mvp.MvpBasePresenter
import com.blink.dagger.bighead.net.RetrofitClient
import com.blink.dagger.bighead.view.iview.IMovieView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by lucky on 2017/6/15.
 */
class MoviePresneter(context: Context) : MvpBasePresenter<IMovieView>(){

    var mModel:MovieModel
    var mContext:Context

    init {
        mModel  = MovieModel()
        mContext = context
    }

    fun getMovieData(){
        RetrofitClient().getInstance(mContext).getMovieData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res ->
                    if (res.res == 0){
                        mModel.data = res.data
                        getView()?.setData(mModel)
                    }
                },{
                    e -> Log.e("luck","u ve got a error : "+e.message)
                    getView()?.showError(e.message as String)
                })
    }

    fun getMoreMovieData(movieId: String?){
        RetrofitClient().getInstance(mContext).getMoreMovieData(movieId!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res ->
                    if (res.res == 0){
                        mModel.data = null
                        mModel.data = res.data
                        getView()?.setData(mModel)
                    }
                },{
                    e -> Log.e("luck","u ve got a error : "+e.message)
                    getView()?.showError(e.message as String)
                })
    }

}