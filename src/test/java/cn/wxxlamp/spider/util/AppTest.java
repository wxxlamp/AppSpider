package cn.wxxlamp.spider.util;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void md5Test() {
        System.out.println(Md5Utils.getMd5("天行助手com.dxgl.wssistanf"));
    }

    @Test
    public void UrlEncodeTest() throws UnsupportedEncodingException {
        System.out.println(URLEncoder.encode("直播", "UTF-8"));
        System.out.println(URLDecoder.decode("%E9%87%91%E8%9E%8D", "UTF-8"));
    }

    @Test
    public void base64Test() {
        System.out.println(Base64.getEncoder().encodeToString("10".getBytes(StandardCharsets.UTF_8)));
        int index = 0;
        for (byte b : Base64.getDecoder().decode("MTA=".getBytes(StandardCharsets.UTF_8))) {
            index *= 10;
            index += b - 48;
        }
        System.out.println(index);
    }
}
