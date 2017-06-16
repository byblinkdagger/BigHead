package com.blink.dagger.bighead.mvp

import java.lang.ref.WeakReference

/**
 * Created by lucky on 2017/6/12.
 */
open class MvpBasePresenter<V : MvpView> : MvpPresenter<V>{

    var viewRef: WeakReference<V>? = null;

    override fun attachView(view: V) {
        viewRef = WeakReference<V>(view)
    }

    override fun deatchView() {
        viewRef?.let {
            viewRef?.clear()
            viewRef = null
        }
    }

    fun isViewAttached():Boolean{
        return viewRef != null && viewRef?.get() != null
    }

    fun getView():V?{
        return viewRef?.get()
    }
}