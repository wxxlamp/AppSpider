# AppSpider
爬取市面上的一些App，包括 包名，大小，名字，版本号，大分类，细分类，下载地址，应用市场，市场中应用唯一ID

### 功能模块：
1. 爬虫模块：采用Gecco完成
2. 持久化模块：前期采用MySQL数据库，后期上线采用Oracle
3. 测试模块：采用Junit完成测试
4. 日志模块：采用log4j完成日志记录
5. 调度模块：暂时未定
6. 管理模块，目前准备采用命令行的方式

### 爬虫的初始URL
```json
[
  {
    "//": "华为影音娱乐",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=33ef450cbac34770a477cfa78db4cf8c&maxResults=25&zone=&locale=zh"
  },
  {
    "//": "华为实用工具",
    "url": "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=8e62cf6d238c4abdb892b400ff072f43&maxResults=25&zone=&locale=zh"
  }
]
```


之前爬过一次，但是被业务方换需求了，详情请见： https://github.com/wxxlamp/Fac

