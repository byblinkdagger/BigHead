package com.blink.dagger.bighead.common


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextWatcher
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide

import android.view.View.GONE


/**
 * Created by lucky on 16-8-1.
 */
abstract class CommonRecyclerAdapter<T> @JvmOverloads constructor(private val context: Context, private val layoutResId: Int, val data: ArrayList<T>? = null) : RecyclerView.Adapter<CommonRecyclerAdapter.ViewHolder>() {

    private var onRecyclerViewItemClickListener: OnRecyclerViewItemClickListener? = null

    //用于回调子view的点击
    interface OnRecyclerViewItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    //设置listener
    fun setOnRecyclerViewItemClickListener(onRecyclerViewItemClickListener: OnRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(layoutResId, parent, false)
        val holder = ViewHolder(context, view)
        if (onRecyclerViewItemClickListener != null) {
            holder.itemView.setOnClickListener { v -> onRecyclerViewItemClickListener!!.onItemClick(v, holder.layoutPosition) }
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        convert(holder, data!!.get(position), position)
    }

    //在具体的adapter中实现此抽象方法即可
    protected abstract fun convert(holder: ViewHolder, t: T, position: Int)

    override fun getItemCount(): Int {
        return data!!.size
    }

    class ViewHolder//将holder中的子view存储至SparseArray中
    (private val context: Context, private val convertView: View) : RecyclerView.ViewHolder(convertView) {
        private val views: SparseArray<View>

        init {
            this.views = SparseArray<View>()
        }

        //每次操作子View前，执行此方法，若该子view已在SparseArray中直接返回，如不存在则实例化它并将其存放至SparseArray
        protected fun <T : View> retrieveView(viewId: Int): T {
            var view: View? = views.get(viewId)
            if (view == null) {
                view = convertView.findViewById(viewId)
                views.put(viewId, view)
            }
            return (view as T?)!!
        }

        //处理子View (根据具体情况还可增加setChecked,setTag,setvisible等方法)
        fun setText(viewId: Int, value: String): ViewHolder {
            val view = retrieveView<TextView>(viewId)
            view.text = value
            return this
        }

        fun setCharSequence(viewId: Int, value: CharSequence): ViewHolder {
            val view = retrieveView<TextView>(viewId)
            view.text = value
            return this
        }

        fun setImageResource(viewId: Int, imageResId: Int): ViewHolder {
            val view = retrieveView<ImageView>(viewId)
            view.setImageResource(imageResId)
            return this
        }

        //add for loading image
        fun setImageURI(viewId: Int, imageURI: String): ViewHolder {
            val view = retrieveView<ImageView>(viewId)
            Glide.with(context).load(imageURI).into(view)
            return this
        }

        fun setBackgroundColor(viewId: Int, color: Int): ViewHolder {
            val view = retrieveView<View>(viewId)
            view.setBackgroundColor(color)
            return this
        }

        fun setOnClickListener(viewId: Int, listener: View.OnClickListener) {
            val view = retrieveView<View>(viewId)
            view.setOnClickListener(listener)
        }

        fun setOnCheckedChangeListener(viewId: Int, listener: CompoundButton.OnCheckedChangeListener) {
            val view = retrieveView<CheckBox>(viewId)
            view.setOnCheckedChangeListener(listener)
        }

        fun addTextChangeListener(viewId: Int, watcher: TextWatcher) {
            val view = retrieveView<EditText>(viewId)
            view.addTextChangedListener(watcher)
        }

        fun setViewVisible(viewId: Int, flag: Boolean) {
            val view = retrieveView<View>(viewId)
            view.visibility = if (flag) View.VISIBLE else GONE
        }

    }
}