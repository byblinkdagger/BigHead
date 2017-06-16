package com.blink.dagger.bighead.net.response

/**
 * Created by lucky on 2017/6/13.
 */
class ReadDataRes{
    private var res: Int = 0
    private var data: List<DataBean>? = null

    fun getRes(): Int {
        return res
    }

    fun setRes(res: Int) {
        this.res = res
    }

    fun getData(): List<DataBean>? {
        return data
    }

    fun setData(data: List<DataBean>) {
        this.data = data
    }

    class DataBean {
        /**
         * id : 12109
         * category : 1
         * display_category : 6
         * item_id : 2517
         * title : 她移动了底线然后又越过了底线
         * forward : 消费是21世纪人类建立的最为世俗化的宗教。
         * img_url : http://image.wufazhuce.com/Fjf2k0DnHxXPHhY3CFgx_15ct2JN
         * like_count : 50
         * post_date : 2017-06-13 12:06:00
         * last_update_date : 2017-06-13 12:07:41
         * author : {"user_id":"7654034","user_name":"黄集伟","desc":"黄集伟，专栏作者，曾有\u201c阅读笔记\u201d系列、\u201c语词笔记\u201d系列、《孤岛访谈录》等闲书出版。","wb_name":"","is_settled":"0","settled_type":"0","summary":"黄集伟，专栏作者。","fans_total":"1771","web_url":"http://image.wufazhuce.com/FvVmWbqlle7jlUCTeozoval9NyBH"}
         * video_url :
         * audio_url :
         * audio_platform : 2
         * start_video :
         * volume : 0
         * pic_info :
         * words_info :
         * subtitle :
         * number : 0
         * serial_id : 0
         * serial_list : []
         * movie_story_id : 0
         * ad_id : 0
         * ad_type : 0
         * ad_pvurl :
         * ad_linkurl :
         * ad_makettime :
         * ad_closetime :
         * ad_share_cnt :
         * ad_pvurl_vendor :
         * content_id : 2517
         * content_type : 1
         * content_bgcolor : #FFFFFF
         * share_url : http://m.wufazhuce.com/article/2517
         * share_info : {"url":"http://m.wufazhuce.com/article/2517","image":"http://image.wufazhuce.com/Fjf2k0DnHxXPHhY3CFgx_15ct2JN","title":"她移动了底线然后又越过了底线 作者/黄集伟","content":"消费是21世纪人类建立的最为世俗化的宗教"}
         * share_list : {"wx":{"title":"一周语文 | 她移动了底线然后又越过了底线","desc":"文/黄集伟 消费是21世纪人类建立的最为世俗化的宗教","link":"http://m.wufazhuce.com/article/2517?channel=singlemessage","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""},"wx_timeline":{"title":"一周语文 | 她移动了底线然后又越过了底线","desc":"文/黄集伟 消费是21世纪人类建立的最为世俗化的宗教","link":"http://m.wufazhuce.com/article/2517?channel=timeline","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""},"weibo":{"title":"ONE一个《一周语文 | 她移动了底线然后又越过了底线》 文/黄集伟： 消费是21世纪人类建立的最为世俗化的宗教 阅读全文：http://m.wufazhuce.com/article/2517?channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874","desc":"","link":"http://m.wufazhuce.com/article/2517?channel=weibo","imgUrl":"","audio":""},"qq":{"title":"她移动了底线然后又越过了底线","desc":"消费是21世纪人类建立的最为世俗化的宗教","link":"http://m.wufazhuce.com/article/2517?channel=qq","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""}}
         * tag_list : [{"id":"3","title":"一周语文"}]
         */

        var id: String? = null
        var category: String? = null
        var display_category: Int = 0
        var item_id: String? = null
        var title: String? = null
        var forward: String? = null
        var img_url: String? = null
        var like_count: Int = 0
        var post_date: String? = null
        var last_update_date: String? = null
        var author: AuthorBean? = null
        var video_url: String? = null
        var audio_url: String? = null
        var audio_platform: Int = 0
        var start_video: String? = null
        var volume: Int = 0
        var pic_info: String? = null
        var words_info: String? = null
        var subtitle: String? = null
        var number: Int = 0
        var serial_id: Int = 0
        var movie_story_id: Int = 0
        var ad_id: Int = 0
        var ad_type: Int = 0
        var ad_pvurl: String? = null
        var ad_linkurl: String? = null
        var ad_makettime: String? = null
        var ad_closetime: String? = null
        var ad_share_cnt: String? = null
        var ad_pvurl_vendor: String? = null
        var content_id: String? = null
        var content_type: String? = null
        var content_bgcolor: String? = null
        var share_url: String? = null
        var share_info: ShareInfoBean? = null
        var share_list: ShareListBean? = null
        var serial_list: List<*>? = null
        var tag_list: List<TagListBean>? = null

        class AuthorBean {
            /**
             * user_id : 7654034
             * user_name : 黄集伟
             * desc : 黄集伟，专栏作者，曾有“阅读笔记”系列、“语词笔记”系列、《孤岛访谈录》等闲书出版。
             * wb_name :
             * is_settled : 0
             * settled_type : 0
             * summary : 黄集伟，专栏作者。
             * fans_total : 1771
             * web_url : http://image.wufazhuce.com/FvVmWbqlle7jlUCTeozoval9NyBH
             */

            var user_id: String? = null
            var user_name: String? = null
            var desc: String? = null
            var wb_name: String? = null
            var is_settled: String? = null
            var settled_type: String? = null
            var summary: String? = null
            var fans_total: String? = null
            var web_url: String? = null
        }

        class ShareInfoBean {
            /**
             * url : http://m.wufazhuce.com/article/2517
             * image : http://image.wufazhuce.com/Fjf2k0DnHxXPHhY3CFgx_15ct2JN
             * title : 她移动了底线然后又越过了底线 作者/黄集伟
             * content : 消费是21世纪人类建立的最为世俗化的宗教
             */

            var url: String? = null
            var image: String? = null
            var title: String? = null
            var content: String? = null
        }

        class ShareListBean {
            /**
             * wx : {"title":"一周语文 | 她移动了底线然后又越过了底线","desc":"文/黄集伟 消费是21世纪人类建立的最为世俗化的宗教","link":"http://m.wufazhuce.com/article/2517?channel=singlemessage","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""}
             * wx_timeline : {"title":"一周语文 | 她移动了底线然后又越过了底线","desc":"文/黄集伟 消费是21世纪人类建立的最为世俗化的宗教","link":"http://m.wufazhuce.com/article/2517?channel=timeline","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""}
             * weibo : {"title":"ONE一个《一周语文 | 她移动了底线然后又越过了底线》 文/黄集伟： 消费是21世纪人类建立的最为世俗化的宗教 阅读全文：http://m.wufazhuce.com/article/2517?channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874","desc":"","link":"http://m.wufazhuce.com/article/2517?channel=weibo","imgUrl":"","audio":""}
             * qq : {"title":"她移动了底线然后又越过了底线","desc":"消费是21世纪人类建立的最为世俗化的宗教","link":"http://m.wufazhuce.com/article/2517?channel=qq","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""}
             */

            var wx: WxBean? = null
            var wx_timeline: WxTimelineBean? = null
            var weibo: WeiboBean? = null
            var qq: QqBean? = null

            class WxBean {
                /**
                 * title : 一周语文 | 她移动了底线然后又越过了底线
                 * desc : 文/黄集伟 消费是21世纪人类建立的最为世俗化的宗教
                 * link : http://m.wufazhuce.com/article/2517?channel=singlemessage
                 * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
                 * audio :
                 */

                var title: String? = null
                var desc: String? = null
                var link: String? = null
                var imgUrl: String? = null
                var audio: String? = null
            }

            class WxTimelineBean {
                /**
                 * title : 一周语文 | 她移动了底线然后又越过了底线
                 * desc : 文/黄集伟 消费是21世纪人类建立的最为世俗化的宗教
                 * link : http://m.wufazhuce.com/article/2517?channel=timeline
                 * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
                 * audio :
                 */

                var title: String? = null
                var desc: String? = null
                var link: String? = null
                var imgUrl: String? = null
                var audio: String? = null
            }

            class WeiboBean {
                /**
                 * title : ONE一个《一周语文 | 她移动了底线然后又越过了底线》 文/黄集伟： 消费是21世纪人类建立的最为世俗化的宗教 阅读全文：http://m.wufazhuce.com/article/2517?channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874
                 * desc :
                 * link : http://m.wufazhuce.com/article/2517?channel=weibo
                 * imgUrl :
                 * audio :
                 */

                var title: String? = null
                var desc: String? = null
                var link: String? = null
                var imgUrl: String? = null
                var audio: String? = null
            }

            class QqBean {
                /**
                 * title : 她移动了底线然后又越过了底线
                 * desc : 消费是21世纪人类建立的最为世俗化的宗教
                 * link : http://m.wufazhuce.com/article/2517?channel=qq
                 * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
                 * audio :
                 */

                var title: String? = null
                var desc: String? = null
                var link: String? = null
                var imgUrl: String? = null
                var audio: String? = null
            }
        }

        class TagListBean {
            /**
             * id : 3
             * title : 一周语文
             */

            var id: String? = null
            var title: String? = null
        }
    }
}