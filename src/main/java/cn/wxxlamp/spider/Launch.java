package cn.wxxlamp.spider;

import com.geccocrawler.gecco.GeccoEngine;

/**
 * @author wxxlamp
 * @date 2021/03/29~10:24
 */
public class Launch {
    public static void main(String[] args) {
        GeccoEngine.create()
                .classpath("cn.wxxlamp.spider")
                .interval(1500)
                .thread(8)
                .start();
    }
}
