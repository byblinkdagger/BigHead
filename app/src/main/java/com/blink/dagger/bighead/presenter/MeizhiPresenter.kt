package com.blink.dagger.bighead.presenter

import android.content.Context
import android.util.Log
import com.blink.dagger.bighead.model.MeizhiModel
import com.blink.dagger.bighead.mvp.MvpBasePresenter
import com.blink.dagger.bighead.net.RetrofitClient
import com.blink.dagger.bighead.view.iview.IMeizhiView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by lucky on 2017/6/14.
 */
class MeizhiPresenter(context: Context) : MvpBasePresenter<IMeizhiView>(){

    var mModel:MeizhiModel
    var mContext:Context

    init {
        mModel = MeizhiModel()
        mContext = context
    }

    fun getMeizhiData(page:Int):Unit{
        RetrofitClient().getInstance(mContext).getMeizhiData(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res ->
                    if (!res.isError){
                        Log.e("luck","get res correctly")
                        mModel.results = res.results
                        getView()?.setData(mModel)
                    }
                },{e -> Log.e("luck","u ve got a error : "+e.message)
                    getView()?.showError(e.message as String)})
    }
}