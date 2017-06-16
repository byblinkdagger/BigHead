package com.blink.dagger.bighead.mvp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by lucky on 2017/6/12.
 */
abstract class MvpFragment<V:MvpView,P:MvpPresenter<V>>: Fragment(),MvpView {

    protected var presenter:P? = null

    abstract fun createPresenter():P

    fun getMvpView():V{
        return this as V
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = createPresenter()
        presenter?.attachView(getMvpView())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter?.deatchView()
    }

}
