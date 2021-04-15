package cn.wxxlamp.spider.pipeline;

import cn.wxxlamp.spider.model.bean.Iuuu9Index;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/04/13~10:51
 */
@PipelineName("iuuu9IndexPipeline")
public class Iuuu9IndexPipeline implements Pipeline<Iuuu9Index> {

    public static List<HttpRequest> list = new ArrayList<>(128);

    @Override
    public void process(Iuuu9Index bean) {
        for (String s : bean.getAppHref()) {
            list.add(bean.getRequest().subRequest(s));
        }
        for (String s : bean.getGameHref()) {
            list.add(bean.getRequest().subRequest(s));
        }
        Collections.reverse(list);
    }
}
