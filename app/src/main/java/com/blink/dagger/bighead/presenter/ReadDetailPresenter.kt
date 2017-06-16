package com.blink.dagger.bighead.presenter

import android.content.Context
import android.util.Log
import com.blink.dagger.bighead.model.ReadDetailModel
import com.blink.dagger.bighead.mvp.MvpBasePresenter
import com.blink.dagger.bighead.net.RetrofitClient
import com.blink.dagger.bighead.view.iview.IReadDetailView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by lucky on 2017/6/14.
 */
class ReadDetailPresenter(context: Context) : MvpBasePresenter<IReadDetailView>(){

    var mModel:ReadDetailModel
    var mContext:Context

    init {
        mModel = ReadDetailModel()
        mContext = context
    }

    fun getReadDetail(itemId:String):Unit{
        RetrofitClient().getInstance(mContext).getReadDetail(itemId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res ->
                    if (res.res == 0){
                        Log.e("luck","get res correctly")
                        mModel.data = res.data
                        getView()?.setData(mModel)
                    }
                },{e -> Log.e("luck","u ve got a error : "+e.message)
                    getView()?.showError(e.message as String)})
    }

}