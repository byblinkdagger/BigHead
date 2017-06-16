package com.blink.dagger.bighead.mvp

/**
 * Created by lucky on 2017/6/12.
 */
interface IBaseView<M> : MvpView{
    /**
     * 装载数据
     */
    fun setData(data: M)
}