package cn.wxxlamp.spider.pipeline;

import cn.wxxlamp.spider.model.bean.MyAppHtml;
import cn.wxxlamp.spider.util.UrlUtils;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;

/**
 * @author wxxlamp
 * @date 2021/03/30~17:07
 */
@PipelineName("myAppHtmlPipeline")
public class MyAppHtmlPipeline implements Pipeline<MyAppHtml> {

    @Override
    public void process(MyAppHtml bean) {
        HttpRequest request = bean.getRequest();
        bean.getCategoryUrlList().forEach(e -> DeriveSchedulerContext.into(request.subRequest(getJsonUrl(e))));
    }

    private String getJsonUrl(String url) {
        int kindValue = UrlUtils.getUrlValue(url, UrlUtils.MY_APP_KIND);
        int categoryValue = UrlUtils.getUrlValue(url, UrlUtils.MY_APP_CATEGORY);
        return "https://android.myapp.com/cate/appList.htm?orgame=" + kindValue + "&categoryId=" + categoryValue + "&pageSize=20&pageContext=0";
    }

}
