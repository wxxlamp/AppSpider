package cn.wxxlamp.spider;

import cn.wxxlamp.spider.model.search.BeanPipeline;
import cn.wxxlamp.spider.pipeline.Iuuu9IndexPipeline;
import cn.wxxlamp.spider.pipeline.MiAppPipeline;
import com.geccocrawler.gecco.GeccoEngine;

/**
 * @author wxxlamp
 * @date 2021/03/29~10:24
 */
public class Launch {
    public static void main(String[] args) {

        GeccoEngine.create()
                .classpath("cn.wxxlamp.spider")
                .interval(2000)
                .run();

        GeccoEngine.create()
                .classpath("cn.wxxlamp.spider")
                .interval(3000)
                .thread(2)
                .start(BeanPipeline.list)
                .start();
    }
}
