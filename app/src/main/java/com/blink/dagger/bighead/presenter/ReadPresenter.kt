package com.blink.dagger.bighead.presenter

import android.content.Context
import android.util.Log
import com.blink.dagger.bighead.model.ReadModel
import com.blink.dagger.bighead.mvp.MvpBasePresenter
import com.blink.dagger.bighead.net.RetrofitClient
import com.blink.dagger.bighead.view.iview.IReadView
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

/**
 * Created by lucky on 2017/6/13.
 */
class ReadPresenter(context:Context): MvpBasePresenter<IReadView>() {

    var mModel:ReadModel
    var mContext:Context

    init {
        mModel = ReadModel()
        mContext = context
    }

    fun getReadData():Unit{
        RetrofitClient().getInstance(mContext).getReadData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res ->
                    if (res.getRes() == 0){
                        Log.e("luck","get res correctly")
                        mModel.data = res.getData()
                        getView()?.setData(mModel)
                    }
                },{e -> Log.e("luck","u ve got a error : "+e.message)
                                getView()?.showError(e.message as String)})
    }
}