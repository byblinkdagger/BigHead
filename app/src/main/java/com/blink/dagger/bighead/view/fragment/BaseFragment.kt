package com.blink.dagger.bighead.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.blink.dagger.bighead.common.showToast
import com.blink.dagger.bighead.mvp.MvpFragment
import com.blink.dagger.bighead.mvp.MvpPresenter
import com.blink.dagger.bighead.mvp.MvpView

/**
 * Created by lucky on 2017/6/12.
 */
abstract class BaseFragment<V: MvpView,P: MvpPresenter<V>>:MvpFragment<V,P>(){

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initData()
        initListeners()
    }

    abstract fun initViews()

    abstract fun initData()

    abstract fun initListeners()

    override fun showError(msg: String) {
        context.showToast(msg)
    }

}