package com.blink.dagger.bighead.net

import com.blink.dagger.bighead.net.response.*
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by lucky on 2017/6/12.
 */
interface NetApiService {

    @GET("http://v3.wufazhuce.com:8000/api/channel/reading/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    fun getReadData():Observable<ReadDataRes>

    @GET("http://v3.wufazhuce.com:8000/api/essay/{itemId}?channel=wdj&source=channel_reading&source_id=9264&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    fun getReadDetail(@Path("itemId") itemId:String):Observable<ReadDetailRes>

    @GET("http://gank.io/api/data/福利/12/{page}")
    fun getMeizhiData(@Path("page") page:Int):Observable<MeizhiRes>

    @GET("http://http://gank.io/api/day/{year}/{month}/{day}")
    fun getGankData(@Path("year") year:Int,@Path("month") month:Int,@Path("day") day:Int):Observable<GankRes>

    @GET("http://v3.wufazhuce.com:8000/api/channel/movie/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    fun getMovieData():Observable<MovieRes>

    @GET("http://v3.wufazhuce.com:8000/api/channel/movie/more/{movieId}?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    fun getMoreMovieData(@Path("movieId") movieId:String):Observable<MovieRes>

    @GET("http://v3.wufazhuce.com:8000/api/channel/music/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    fun getMusicData():Observable<MusicRes>

}