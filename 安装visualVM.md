
1. 下载安装
按照如下路径搜索VisualVM，找到图示第一个插件点击install，安装完成后重启idea
preferences -> Plugings -> VisualVM launcher -> Search in repositories  ->  install ->  Restart IDEA
![在idea的markerplace搜索visualVM](https://upload-images.jianshu.io/upload_images/20792523-c46c8574f6b02bd9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
2. 配置使用
idea重启后工具栏会出现如下两个图标
![工具栏图标](https://upload-images.jianshu.io/upload_images/20792523-440ca513a082dceb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
preferences ->other settings -> visualVM launcher ->填写jdk及jvisualvm的地址
![配置visualVM](https://upload-images.jianshu.io/upload_images/20792523-8e353873e7feeb47.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
```
Mac上jdk默认安装路径
/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/bin
```
3. 启动项目时运行visualVM
![visualVM启动](https://upload-images.jianshu.io/upload_images/20792523-72042b725f4152a1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
启动成功后可以在可视化界面查看CPU、堆、jvm参数等信息
![visualVM界面](https://upload-images.jianshu.io/upload_images/20792523-7afaa3d2c11fab5a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
4. 在visualVM安装其他插件
如果想查看更多信息visualVM支持安装一些插件，此处安装View GC便于查看GC情况
Java VisualVM -> 工具 -> 插件
![插件安装](https://upload-images.jianshu.io/upload_images/20792523-7ad9fb5e9e69ba18.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
选择可安装的插件进行安装
![选择插件安装](https://upload-images.jianshu.io/upload_images/20792523-e54ada3d974e8dcc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
重启visualVM，界面大致如下
![点击view GC](https://upload-images.jianshu.io/upload_images/20792523-9cd7a2f86faba0f8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
