# AppSpider
爬取市面上的一些App，包括 包名，大小，名字，版本号，大分类，细分类，下载地址，应用市场，市场中应用唯一ID

### 功能模块：
1. 爬虫模块：采用Gecco完成
2. 持久化模块：前期采用MySQL数据库，后期上线采用Oracle
3. 测试模块：采用Junit完成测试
4. 日志模块：采用log4j完成日志记录
5. 调度模块：暂时未定
6. 管理模块，目前准备采用命令行的方式

### 问题
华为的appId不太对
ac6829897ec3484a8f0efb881420d361
### 爬虫的初始URL
```json
[
  {
    "//": "应用宝",
    "url": "https://android.myapp.com/myapp/index.htm"
  },
  {
    "//": "华为影音娱乐",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=33ef450cbac34770a477cfa78db4cf8c&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为实用工具",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=8e62cf6d238c4abdb892b400ff072f43&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为社交通讯",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=79bd417da03d470287c0c7c2ef8f2c96&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为教育",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=84471de6a7524d4a9242903fbc9bbe8b&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为新闻阅读",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=65696386add14dda8b7ee8a20be03aad&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为拍摄美化",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=07e66002a01c442990ed5630aa460d48&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为美食",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=c946b166e7c34dcab8a8960bf6979dd3&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为出行导航",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=50151113bc4143d0aa7013843ff0ef32&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为旅游住宿",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=ce87048699a64f5db8a90bca7bcf68fd&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为购物比价",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=e3beb74372c44ee899709a038eabfc70&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为商务",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=4d5e752fde6c4b33869058a69565171e&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为儿童",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=24305799357048a4a9585f4f4c05dc1e&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为金融理财",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=2d2b18f338244b9db71d1ec30b257f1e&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为运动健康",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=7e04648230ca4bbaa836fa8c027517ba&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为便捷生活",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=a29745005a8942b797d3d5ddf6bb1b48&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为汽车",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=d6566ca265754426b36cc6a12fa1e2cd&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为角色扮演",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=44b299f655c743af9582c5c9dfabfdd5&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为休闲益智",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=5e4425e03ae44a87a5293dc2d9ebcfde&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为经营策略",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=3ae307aff6c541818f3f9c242f18fd85&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为体育竞速",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=3e28c821504e473c9f4990d78d235837&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为动作射击",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=ee252e5e36524275b17d5bbee7ab08a5&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "华为棋牌桌游",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=43285bc8c9344cd2b973165ef8fc9aee&maxResults=25&zone=CN&locale=zh"
  },
  {
    "//": "小米",
    "url": "https://app.mi.com/"
  }
]
```


之前爬过一次，但是被业务方换需求了，详情请见： https://github.com/wxxlamp/Fac

