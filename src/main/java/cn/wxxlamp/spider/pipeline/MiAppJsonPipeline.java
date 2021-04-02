package cn.wxxlamp.spider.pipeline;

import cn.wxxlamp.spider.model.bean.MiAppJson;
import cn.wxxlamp.spider.util.UrlUtils;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;

/**
 * @author wxxlamp
 * @date 2021/04/02~10:15
 */
@PipelineName("miAppJsonPipeline")
public class MiAppJsonPipeline implements Pipeline<MiAppJson> {

    private static final String URL = "https://app.mi.com/details?id=";

    @Override
    public void process(MiAppJson bean) {
        bean.getUrlDetail().forEach(e -> {
            if (e == null) {
                return;
            }
            String nextUrl = URL + e;
            DeriveSchedulerContext.into(bean.getRequest().subRequest(nextUrl));
        });
        if (bean.getUrlDetail().size() != 0) {
            String url = UrlUtils.getMiAppNextUrl(bean.getRequest().getUrl());
            DeriveSchedulerContext.into(bean.getRequest().subRequest(url));
        }
    }
}
