package com.blink.dagger.bighead.view.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.blink.dagger.bighead.R
import com.blink.dagger.bighead.common.CommonRecyclerAdapter
import com.blink.dagger.bighead.model.MusicModel
import com.blink.dagger.bighead.net.response.MusicRes
import com.blink.dagger.bighead.presenter.MusicPresenter
import com.blink.dagger.bighead.view.activity.WebViewActivity
import com.blink.dagger.bighead.view.iview.IMusicView
import com.blink.dagger.bighead.widget.RefreshRecyclerView
import kotlinx.android.synthetic.main.fragment_music.*


/**
 * A simple [Fragment] subclass.
 */
class MusicFragment : BaseFragment<IMusicView,MusicPresenter>(),IMusicView {

    var musicAdapter:CommonRecyclerAdapter<MusicRes.DataBean>? = null
    var musciData:ArrayList<MusicRes.DataBean> = ArrayList()

    override fun showLoading() {
    }

    override fun showContent() {
    }

    override fun setData(data: MusicModel) {
        musciData.clear()
        musciData.addAll(data.data!!)
        musicAdapter?.notifyDataSetChanged()
    }

    override fun createPresenter(): MusicPresenter {
        return MusicPresenter(context)
    }

    override fun initViews() {
        musicAdapter = object:CommonRecyclerAdapter<MusicRes.DataBean>(context,R.layout.item_read_content,musciData){
            override fun convert(holder: ViewHolder, t: MusicRes.DataBean, position: Int) {
                holder.setText(R.id.article_type, t.subtitle!!);
                holder.setText(R.id.article_name, t.title!!)
                t.author.let { holder.setText(R.id.article_auth, "文/"+t.author?.user_name ?: "文/佚名") }
                holder.setText(R.id.article_desc, t.forward!!)
                holder.setText(R.id.article_time, t.post_date!!)
                holder.setImageURI(R.id.article_img, t.img_url!!)
            }
        }

        (musicAdapter as CommonRecyclerAdapter<MusicRes.DataBean>).setOnRecyclerViewItemClickListener(object:CommonRecyclerAdapter.OnRecyclerViewItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                val intent: Intent = Intent(context, WebViewActivity::class.java)
                intent.putExtra("url",musciData.get(position).share_url)
                startActivity(intent)
            }

        })

        rvContent?.setMyRecyclerView(LinearLayoutManager(context),musicAdapter)

        val headText = TextView(context)
        headText.text = "放开我~你就能刷新了哦(●'◡'●)"
        headText.gravity = Gravity.CENTER
        headText.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        val footText = TextView(context)
        footText.text = "查看更多历史影视咯(lll￢ω￢)"
        rvContent?.addHeaderView(headText,100)
        footText.gravity = Gravity.CENTER
        rvContent?.addFooterView(footText,100)
    }

    override fun initData() {
        presenter?.getMusicData()
    }

    override fun initListeners() {
        rvContent.addOnTouchUpListener(object :RefreshRecyclerView.OnTouchUpListener{
            override fun onRefresh() {
                presenter?.getMusicData()
            }

            override fun onLoadMore() {
                Log.d("luck","load more")
            }
        })
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_music, container, false)
    }

}
