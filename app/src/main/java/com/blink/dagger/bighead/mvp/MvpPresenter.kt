package com.blink.dagger.bighead.mvp

/**
 * Created by lucky on 2017/6/12.
 */
interface MvpPresenter<V : MvpView>{

    fun attachView(view: V)

    fun deatchView()
}