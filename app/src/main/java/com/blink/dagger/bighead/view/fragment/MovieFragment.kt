package com.blink.dagger.bighead.view.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.blink.dagger.bighead.R
import com.blink.dagger.bighead.common.CommonRecyclerAdapter
import com.blink.dagger.bighead.model.MovieModel
import com.blink.dagger.bighead.net.response.MovieRes
import com.blink.dagger.bighead.presenter.MoviePresneter
import com.blink.dagger.bighead.view.activity.WebViewActivity
import com.blink.dagger.bighead.view.iview.IMovieView
import com.blink.dagger.bighead.widget.RefreshRecyclerView
import kotlinx.android.synthetic.main.fragment_movie.*


/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : BaseFragment<IMovieView,MoviePresneter>(),IMovieView {

    var movieAdapter:CommonRecyclerAdapter<MovieRes.DataBean>? = null
    var movieData:ArrayList<MovieRes.DataBean> = ArrayList()

    override fun showLoading() {

    }

    override fun showContent() {
    }

    override fun setData(data: MovieModel) {
        movieData.clear()
        movieData.addAll(data.data!!)
        movieAdapter?.notifyDataSetChanged()
        rvContent?.setRecyclerViewScrollToPosition(0)
    }

    override fun createPresenter(): MoviePresneter {
        return MoviePresneter(context)
    }

    override fun initViews() {

        movieAdapter = object:CommonRecyclerAdapter<MovieRes.DataBean>(context,R.layout.item_read_content,movieData){
            override fun convert(holder: ViewHolder, t: MovieRes.DataBean, position: Int) {
                holder.setText(R.id.article_type,"<"+t.subtitle+">");
                holder.setText(R.id.article_name, t.title!!)
                t.author.let { holder.setText(R.id.article_auth, "文/"+t.author?.user_name ?: "文/佚名") }
                holder.setText(R.id.article_desc, t.forward!!)
                holder.setText(R.id.article_time, t.post_date!!)
                holder.setImageURI(R.id.article_img, t.img_url!!)
            }
        }

        (movieAdapter as CommonRecyclerAdapter<MovieRes.DataBean>).setOnRecyclerViewItemClickListener(object:CommonRecyclerAdapter.OnRecyclerViewItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                val intent:Intent = Intent(context,WebViewActivity::class.java)
                intent.putExtra("url",movieData.get(position).share_url)
                startActivity(intent)
            }

        })

        rvContent?.setMyRecyclerView(LinearLayoutManager(context),movieAdapter)

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
        presenter?.getMovieData()
    }

    override fun initListeners() {
        rvContent?.addOnTouchUpListener(object : RefreshRecyclerView.OnTouchUpListener{
            override fun onRefresh() {
                presenter?.getMovieData()
            }

            override fun onLoadMore() {
                presenter?.getMoreMovieData(movieData.last().id)
            }

        })
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_movie, container, false)
    }

}
