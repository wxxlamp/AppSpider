package cn.wxxlamp.spider.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void md5Test() {
        System.out.println(Md5Utils.getMd5("快手com.api.ui"));
    }
}
