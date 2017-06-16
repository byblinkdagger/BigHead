package com.blink.dagger.bighead.mvp

/**
 * Created by lucky on 2017/6/12.
 */
interface MvpView{

    fun showLoading()

    fun showContent()

    fun showError(msg:String = "u met a error !")
}
