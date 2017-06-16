# BigHead

a kotlin client with news，music,movie and girls

* 主要使用框架或插件:
```
mvp
kotlin
retrofit2
rxjava
glide
```
mvp通过泛型的方式，将model、view、presenter从建类文件的时候就抽离开来（参考简化自[mosby](https://github.com/sockeqwe/mosby)）；
网络请求、图片加载还是采用主流的retrofit2&rxjava&glide；

* 接触kotlin才10多天，用的不是很熟练和正确，很多地方写得比较僵硬。不过用了kotlin就可以告别findViewById,lambda的简洁,避免setter、getter，避免nullpoint，函数拓展等等场景真得比较赞。其他的优势还在慢慢摸索中，个人觉得纯java开发还是有思路清晰、易于维护的优点，所以没必要那么着急将kotlin应用于项目。

* 使用截图：

![read.png](http://upload-images.jianshu.io/upload_images/2555073-854353fa44a65e4b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![read_detail.png](http://upload-images.jianshu.io/upload_images/2555073-e56387a78f71064c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![movie.png](http://upload-images.jianshu.io/upload_images/2555073-9b626f2514318bc8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![movie_detail.png](http://upload-images.jianshu.io/upload_images/2555073-99c74202297d2af1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![meizhi.png](http://upload-images.jianshu.io/upload_images/2555073-9f107ce4d57297f0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

> 最后感谢[Api](https://github.com/jokermonn/-Api)、gank.io的api,部分图片资源来自one，仅作学习使用
