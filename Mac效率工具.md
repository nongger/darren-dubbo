>原文地址：[Mac上提升效率的软件](https://mp.weixin.qq.com/s/8c-94YhOd5fLJbScW4MnFw)

## 1\. uTools（Windows/Mac）

还在为了翻译 English 而专门下载一个翻译软件吗？

还在为了格式某个 json 文本、时间戳转换而打开网址百度地址吗？

还在为了查找 linux/redis/vue 文档而打开你的浏览器搜索吗？

还在为了改动 hosts 文件专门下载软件或改动 hosts 文件吗 ？

还在为了从时间戳到秒而网上百度吗？

还在为了斗图赢过好友而网上百度吗？

这就是 utools 诞生的意义！**最重要的是它提供 API 以供用户自定义插件来解决重复和低效的操作，而上面所说的功能，都是通过不同的插件实现的，还有很多插件，像剪切板历史记录，密码管理，内网穿透，todo 列表等。**

1.  文档地址：https://u.tools/docs/guide/about-uTools.html
2.  交流论坛：https://yuanliao.info/t/utools

## 2\. brew（Mac）

为什么有 brew？因为 mac 平台的 appstore 非常的不好用，审核也很严，因此有**很多一些大家公认的“正版”好用的软件，都会在 homebrew 发布**，例如 openjdk、qq、maven、go 等，它是 Mac OSX 上的软件包管理工具，能够使用命令行实现安装、卸载、升级的功能。类似 ubuntu 系统下的 apt-get 的功能。而且很多软件都推荐使用 brew 安装，因为它可以帮助你解决安装依赖问题，例如你想下载 go、maven 这种命令行工具，你还需要配置其它的一些环境，而 brew 在安装的时候都帮你配置好了。

1.  主页地址：https://brew.sh/index_zh-cn
2.  支持安装的命令行软件列表：https://formulae.brew.sh/formula/
3.  支持安装的桌面端软件列表：https://formulae.brew.sh/cask/

> 
> 1.  命令行软件，例如 go、openjdk、maven、python 等。使用的基本命令为：`brew install openjdk`
> 2.  桌面端软件：例如 qq、微信、网易云音乐等桌面的软件。使用的基本命令为：`brew cask install qq`，只是多了一个 `cask` 参数。

常见命令整理如下，以下命令都可带上 `cask` 参数：

1.  `brew search name`：联网搜索软件是否存在 brew 中
2.  `brew install name`：安装软件
3.  `brew upgrade name`：更新软件
4.  `brew uninstall name`：卸载软件
5.  `brew reinstall name`：重新安装软件
6.  `brew info name`：查看软件安装地址
7.  `brew cleanup`：清理缓存等
8.  `brew doctor`：查看建议，例如升级等

## 3\. iterm2+zsh+json_pp（Mac）

这是我的一个套装组合，各个都可以拆分来使用，但是它们组合使用效率极高。

iTerm2 是 macOS 的终端仿真器，支持一个界面有多个 session 等，你可以把它当做 `SecureCRT` 命令行版，但是支持各种自定义配置。zsh 是 oh-my-zsh 的简称，我们默认都是用的 `bash` 终端，是不支持命令的自动填充高亮等。
json_pp 我主要是用来格式化 `curl` 命令行的结果，例如测试某个 restful 接口，返回的 json，在命令行就会自动给你格式化好输出，

1.  这三个软件都是搭配 `brew` 安装
2.  搭配安装教程地址：https://gist.github.com/kevin-smets/8568070
3.  iterm2 安装：`brew cask install iterm2`
4.  zsh 安装：https://ohmyz.sh/#install
5.  json_pp 安装：`brew install jsonpp`

> 
> 当安装了 zsh 后，你可以在 vscode/idea 软件中切换默认的 shell
> 
> ![image](https://upload-images.jianshu.io/upload_images/20792523-5cb8955d5f102aa2?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
> 
> 效果图如下，命令提示高亮，显示当前 git 分支![image](https://upload-images.jianshu.io/upload_images/20792523-a906c75956c55ca1?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 4\. Itsycal（Mac）

Mac 左上角的时间栏只能看当前时间不能看日历非常的不方便，因此有很多软件都支持左上角时间点击显示日历，但是 Itsycal 是我用过最方便轻量的免费软件， 不仅可以同步日历的事件，而且各种小功能也非常的实用：

1.  支持各种快捷键，包括创建事件、快速显示小日历等。
2.  支持高亮显示某星期、设置每周的第一天为周一或周日。
3.  自定义 dateformat 显示日期，我设置的为：YYYY-MM-dd EE HH:mm:ss
4.  支持暗黑模式，不过我都是设置为跟随系统主题，白天白色，晚上黑色自动切换。

![image](https://upload-images.jianshu.io/upload_images/20792523-5eec82c3239553b9?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1.  文档地址：https://www.mowglii.com/itsycal/
2.  下载：`brew cask install itsycal`

## 5\. xnip pro + QQ（Mac）

没错，这个 QQ 就是我们平常用的 QQ 聊天软件。
在电脑截图上，我经常用的功能包括：滚动截长图，快速截图、识别图片中的文字、快速录个电脑操作视频。这些操作中，xnip 支持滚动截长图，我个人用了几款，虽然有好用的，但是都是收费的，而 xnip 免费版滚动截图只会有个水印。
QQ 截图是结合截图、OCR 识别以及录视频为一体的超级功能！有时候发的截图里面的 token，或者手机号，又例如银行卡，就非常的方便，而且识别的非常准确！另外 qq 截图有个小技巧，截图双击时会截当前软件的边缘，不用自己手动拖拽。

1.  snip 地址：https://zh.xnipapp.com/
2.  QQ 地址：https://im.qq.com/macqq/

QQ 截图 OCR 识别：![image](https://upload-images.jianshu.io/upload_images/20792523-1e0ee2bf0d7d9a00?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

QQ 首选项配置截图、录制快捷键设置：![image](https://upload-images.jianshu.io/upload_images/20792523-252cd013e7d3fbd1?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 6\. 语雀（Windows/Mac）

我的笔记之路，从白嫖有道云笔记，再到买了一年的印象笔记的高级会员，最后是买了阿里云服务器自制了蚂蚁笔记服务端，自己的笔记之路一路折腾，最后我发现还是语雀符合我对笔记知识整合的理解。本篇文章也同步发布在了语雀。

1.  **界面清新，客户端启动快。**不像印象笔记，启动慢不说，运行久了还会卡。而且有很多我不必要的功能在那里。
2.  **支持现在流行的卡片式笔记，例如流程图、视频链接、思维导图等。**
3.  **快速发布，生成博文，可访问的链接，用于快速分享好基友，还支持多个文件形成目录后文件夹层级。**
4.  **免费使用 oss 存储，包括图片视频思维导图都可以免费存储并有单独的链接访问（个人版存储空间 90G 够用了）**

![image](https://upload-images.jianshu.io/upload_images/20792523-53a77f413bc1adbc?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

*个人感觉语雀还是很香的！自己用来记笔记还是当做博客都是非常不错的选择。*

1.  主页地址：https://www.yuque.com/
2.  帮助手册：https://www.yuque.com/yuque/help

## 7\. tencent-lemon（Mac）

腾讯柠檬清理，基本对标的就是 CleanMyMac，我个人没用过 CleanMyMac，但是感觉腾讯家的这个产品挺好用，在内测的时候就在一直用，产品在社区里面也一直听取用户的意见改进，持状态栏显示当前内存占用、网速等，对我来说是够用了。

![image](https://upload-images.jianshu.io/upload_images/20792523-1eb5941367d1eaf0?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image](https://upload-images.jianshu.io/upload_images/20792523-8060c92addb2a171?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1.  主页地址：https://lemon.qq.com/
2.  社区地址：https://support.qq.com/products/36664
3.  下载：`brew cask install tencent-lemon`

## 8.oss-brower （Windows/Mac）

这个仅适合使用了阿里云 oss 的用户，它是快速的方便用户对自己 oss 进行操作管理，而且还有权限功能，我平常都是电脑截图，然后拖拽图片到 oss-brower 里面，接着获取地址。另外该产品是开源的，我开始很难相信这是阿里出的产品。

![image](https://upload-images.jianshu.io/upload_images/20792523-1ce97f823dd581fb?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1.  主页地址：https://github.com/aliyun/oss-browser
2.  中文文档：https://github.com/aliyun/oss-browser/blob/master/README-CN.md

## 9\. ScreenTime（Mac）

即 apple 自带的屏幕时间，大家有时候可能想知道，我在 Mac 和 Iphone 上使用各个软件的时候大概是多久，可能 Iphone 大家都知道，但是 Mac 大家可能不怎么关注，但是其实 Mac 的屏幕时间更加方便和强大，因为它根据 icloud 可以获取所有设备的总时间，或其它设备（例如 watch???）的使用时间。

![image](https://upload-images.jianshu.io/upload_images/20792523-c82fbc520f4328f4?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 10\. BackgroudMusic（Mac）

这个软件用于单独为每个软件设置独立的音量大小。属于你不装的时候挺好，装了之后就严重依赖它的软件。属于开源软件，社区活跃，更新也频繁，我使用过程中已知的 bug 主要是在开启和关闭过程中会没声音，不过我设置开机启动就好了。

1.  上班时，我想设置音乐软件声音小，办公软件提示音大，它可以做到。
2.  在家时，我想设置小网页声音大，办公软件提示音小，它可以做到。
3.  我想设置声音左耳大，右耳小（这个功能我暂时没用上）。

![image](https://upload-images.jianshu.io/upload_images/20792523-1b60c1afd6c8ea04?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1.  主页地址：https://github.com/kyleneideck/BackgroundMusic
2.  下载地址：`brew cask install background-music`

## 11\. TeamViewer（Windows/Mac）

主要是方便自己的 Mac 远程连接好基友的 Win 电脑，来做一下操作。不过由于之前 TeamVierwer 曝出重大安全漏洞，现在国内都需要手机号验证了，但是不影响我们使用免费版。

![image](https://upload-images.jianshu.io/upload_images/20792523-d8acec3b946caa86?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1.  主页地址：https://www.teamviewer.cn/cn/
2.  下载：`brew cask install teamviewer`

## 12\. another redis desktop manager（Windows/Mac）

可视化的 Redis 管理软件，开源软件。颜值高、功能多、作者更新快的可视化 Redis 管理软件。

![image](https://upload-images.jianshu.io/upload_images/20792523-7b538a3464dd0d0f?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1.  主页地址：https://github.com/qishibo/AnotherRedisDesktopManager
2.  下载：`brew cask install another-redis-desktop-manager`

## 13\. IIna（Mac）

现代化的视频播放器，我用的功能只是本地播放，有次 Mac 自带的播放器无法播放某个特殊的小视频，因此在 Github 找到了它，目前视频类的格式它都能播放，功能齐全，设置速率、翻转等基本功能都有，我把它当做万能播放器使用。

![image](https://upload-images.jianshu.io/upload_images/20792523-6e4795b77efdb690?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1.  主页地址：https://github.com/iina/iina
2.  下载：`brew cask install iina`

## 14\. ffmpeg（Windows/Mac）

视频格式转换、视频转 gif、视频压缩等视频操作的命令行工具。基本现在播放器的软件都使用了该仓库的代码。我平常主要用它压缩视频，例如介绍 utools 章节的视频，原视频 23M，然后通过它压缩 8M，方便快捷。缺点是命令行复杂，需要好好调教，我本人用的较少。

![image](https://upload-images.jianshu.io/upload_images/20792523-dcb076aaccc55fa1?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1.  主页地址：https://github.com/FFmpeg/FFmpeg
2.  下载：`brew install ffmpeg`
