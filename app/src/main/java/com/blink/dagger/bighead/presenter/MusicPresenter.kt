package com.blink.dagger.bighead.presenter

import android.content.Context
import android.util.Log
import com.blink.dagger.bighead.model.MusicModel
import com.blink.dagger.bighead.mvp.MvpBasePresenter
import com.blink.dagger.bighead.net.RetrofitClient
import com.blink.dagger.bighead.view.iview.IMusicView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by lucky on 2017/6/16.
 */
class MusicPresenter(context: Context) : MvpBasePresenter<IMusicView>() {

    var mContext:Context
    var mModel:MusicModel

    init {
        mContext = context
        mModel = MusicModel()
    }

    fun getMusicData(){
        RetrofitClient().getInstance(mContext).getMusicData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res ->
                    if (res.res == 0){
                        mModel.data = res.data
                        getView()?.setData(mModel)
                    }
                },{
                    e ->
                    Log.e("luck","u ve got a error : "+e.message)
                    getView()?.showError(e.message as String)
                })
    }
}