package com.blink.dagger.bighead.view.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_read.*;

import com.blink.dagger.bighead.R
import com.blink.dagger.bighead.common.CommonRecyclerAdapter
import com.blink.dagger.bighead.model.ReadModel
import com.blink.dagger.bighead.net.response.ReadDataRes
import com.blink.dagger.bighead.presenter.ReadPresenter
import com.blink.dagger.bighead.view.iview.IReadView
import com.blink.dagger.bighead.widget.RefreshRecyclerView
import android.view.Gravity
import android.widget.TextView
import android.widget.LinearLayout
import com.blink.dagger.bighead.view.activity.ReadDetailActivity

/**
 * A simple [Fragment] subclass.
 */
class ReadFragment : BaseFragment<IReadView,ReadPresenter>(),IReadView {

    var readCommentAdapter:CommonRecyclerAdapter<ReadDataRes.DataBean>? = null
    var readData :ArrayList<ReadDataRes.DataBean>?= ArrayList<ReadDataRes.DataBean>()

    override fun showLoading() {
    }

    override fun showContent() {
    }

    override fun setData(data: ReadModel) {
        Log.d("luck",data.data?.get(0)?.title)
        readData?.clear()
        readData?.addAll(data.data!!)
        Log.d("luck","size :"+readData?.size)
        readCommentAdapter?.notifyDataSetChanged()
    }

    override fun createPresenter(): ReadPresenter {
        return ReadPresenter(context)
    }

    override fun initViews() {

        readCommentAdapter = object:CommonRecyclerAdapter<ReadDataRes.DataBean>(context,R.layout.item_read_content,readData){
            override fun convert(holder: ViewHolder, t: ReadDataRes.DataBean, position: Int) {
                holder.setText(R.id.article_name, t.title!!)
                t.author.let { holder.setText(R.id.article_auth, "文/"+t.author?.user_name?:"文/佚名") }
                holder.setText(R.id.article_desc, t.forward!!)
                holder.setText(R.id.article_time, t.post_date!!)
                holder.setImageURI(R.id.article_img, t.img_url!!)
            }
        }

        (readCommentAdapter as CommonRecyclerAdapter<ReadDataRes.DataBean>).setOnRecyclerViewItemClickListener(object:CommonRecyclerAdapter.OnRecyclerViewItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                val intent:Intent = Intent(context,ReadDetailActivity::class.java)
                intent.putExtra("itemId",readData?.get(position)?.item_id)
                startActivity(intent)
            }

        })

        rvContent?.setMyRecyclerView(LinearLayoutManager(context),readCommentAdapter)

        val headText = TextView(context)
        headText.text = "放开我~你就能刷新了哦(●'◡'●)"
        headText.gravity = Gravity.CENTER
        headText.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        val footText = TextView(context)
        footText.text = "抱歉~暂时没有其他内容了哦(lll￢ω￢)"
        rvContent?.addHeaderView(headText,100)
        footText.gravity = Gravity.CENTER
        rvContent?.addFooterView(footText,100)
    }

    override fun initData() {
        presenter?.getReadData()
    }

    override fun initListeners() {
        rvContent?.addOnTouchUpListener(object : RefreshRecyclerView.OnTouchUpListener{
            override fun onRefresh() {
                presenter?.getReadData()
            }

            override fun onLoadMore() {
                Log.d("luck","load more")
            }

        })
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_read, container, false)
    }

}// Required empty public constructor
