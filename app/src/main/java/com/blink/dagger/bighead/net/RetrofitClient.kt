package com.blink.dagger.bighead.net

import android.content.Context
import okhttp3.Cache
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * Created by lucky on 2017/6/13.
 */
class RetrofitClient {

    val Base_URL = "http://tongji.oudot.cn/tongji_app/JsonManageServlet/"
    private val DEFAULT_TIMEOUT = 5

    @Volatile private var retrofit: Retrofit? = null
    private var okHttpClient: OkHttpClient? = null
    private var cache: Cache? = null

    /**
     * @return
     */
     fun getInstance(context: Context): NetApiService {
        if (retrofit == null) {
            synchronized(RetrofitClient::class.java) {
                if (retrofit == null) {

                    try {
                        if (cache == null) {
                            cache = Cache(File(context.getCacheDir(), "bigHead"), 10 * 1024 * 1024)
                        }
                    } catch (e: Exception) {
                    }

                    //缓存配置
                    okHttpClient = OkHttpClient.Builder()
                            .cache(cache)
                            .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                            .connectionPool(ConnectionPool(8, 15, TimeUnit.SECONDS))
                            .build()

                    retrofit = Retrofit.Builder().baseUrl(Base_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(okHttpClient!!)
                            .build()
                }
            }
        }
        return retrofit!!.create<NetApiService>(NetApiService::class.java!!)
    }
}