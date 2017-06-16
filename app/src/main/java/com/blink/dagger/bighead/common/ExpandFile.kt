package com.blink.dagger.bighead.common

import android.content.Context
import android.widget.Toast

/**
 * Created by lucky on 2017/6/12.
 */
fun Context.showToast(message:String = "this is a toast", length : Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,length)
}