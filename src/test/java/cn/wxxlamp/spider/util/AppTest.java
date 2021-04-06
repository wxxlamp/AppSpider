package cn.wxxlamp.spider.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void md5Test() {
        System.out.println(Md5Utils.getMd5("快手com.api.ui"));
    }

    @Test
    public void UrlEncodeTest() throws UnsupportedEncodingException {
        System.out.println(URLEncoder.encode("直播", "UTF-8"));
        System.out.println(URLDecoder.decode("%7C%E7%9B%B4%E6%92%AD", "UTF-8"));

        System.out.println("https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=searchApp|图书阅读&maxResults=25&zone=&locale=zh".charAt(121));
    }
}
