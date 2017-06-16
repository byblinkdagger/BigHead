package com.blink.dagger.bighead.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by lucky on 2017/6/12.
 */
abstract class MvpActivity<V:MvpView,P:MvpPresenter<V>>: AppCompatActivity(),MvpView{

    protected var presenter:P? = null

    abstract fun createPresenter():P

    fun getMvpView():V{
        return this as V
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
        presenter?.attachView(getMvpView())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.deatchView()
    }
}