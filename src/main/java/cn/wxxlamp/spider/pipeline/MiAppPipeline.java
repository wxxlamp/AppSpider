package cn.wxxlamp.spider.pipeline;

import cn.wxxlamp.spider.model.bean.MiApp;
import cn.wxxlamp.spider.util.UrlUtils;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/04/02~10:06
 */
@PipelineName("miAppPipeline")
public class MiAppPipeline implements Pipeline<MiApp> {
    @Override
    public void process(MiApp bean) {
        subRequest(bean.getAppUrl(), bean.getRequest());
        subRequest(bean.getGameUrl(), bean.getRequest());
    }

    private void subRequest(List<String> urls, HttpRequest request) {
        for (String url : urls) {
            int categoryId = UrlUtils.getUrlValue(url, "/category/");
            DeriveSchedulerContext.into(request.subRequest
                    ("https://app.mi.com/categotyAllListApi?page=1&categoryId="
                            + categoryId + "&pageSize=30"));
        }
    }
}
