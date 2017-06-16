package com.blink.dagger.bighead.view.activity

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.blink.dagger.bighead.common.showToast
import com.blink.dagger.bighead.mvp.MvpActivity
import com.blink.dagger.bighead.mvp.MvpPresenter
import com.blink.dagger.bighead.mvp.MvpView
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.view.inputmethod.InputMethodManager


/**
 * Created by lucky on 2017/6/12.
 */
abstract class BaseActivity<V:MvpView,P:MvpPresenter<V>> : MvpActivity<V, P>(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView());
        initViews()
        initData()
        initListeners()
    }

    abstract fun getContentView():View

    abstract fun initViews()

    abstract fun initData()

    abstract fun initListeners()

    override fun showError(msg: String) {
        showToast(msg)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (null != this.currentFocus) {
            val mInputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            return mInputMethodManager.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
        }
        return super.onTouchEvent(event)
    }
}