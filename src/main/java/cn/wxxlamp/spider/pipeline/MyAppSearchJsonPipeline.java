package cn.wxxlamp.spider.pipeline;

import cn.wxxlamp.spider.dao.AppDescDao;
import cn.wxxlamp.spider.dao.AppDescMapper;
import cn.wxxlamp.spider.model.AppDesc;
import cn.wxxlamp.spider.model.bean.MyAppJson;
import cn.wxxlamp.spider.model.bean.MyAppSearchJson;
import cn.wxxlamp.spider.util.UrlUtils;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author wxxlamp
 * @date 2021/04/07~09:41
 */
@PipelineName("myAppSearchJsonPipeline")
public class MyAppSearchJsonPipeline implements Pipeline<MyAppSearchJson> {

    private static final String APP_STORE = "MY_APP";
    private static final String KEY = "pns=";

    @Override
    public void process(MyAppSearchJson bean) {
        if (!bean.getSuccess()) {
            return;
        }
        HttpRequest request = bean.getRequest();
        if (bean.getHasNext() == 1) {
            DeriveSchedulerContext.into(request.subRequest(this.getNextUrl(request.getUrl())));
        }
        for (int i = 0; i < bean.getAppId().size(); i++) {
            AppDesc appdesc = this.getAppDesc(bean, i);
            AppDescMapper.mapper(appdesc);
            // 这个不用通过分类搜索，因为一定存在
        }
    }

    private String getNextUrl(String url) {
        String value = UrlUtils.getUrlStrValue(url, KEY);
        int currPage = 0;
        for (byte b : Base64.getDecoder().decode(value.getBytes(StandardCharsets.UTF_8))) {
            currPage *= 10;
            currPage += b - 48;
        }
        String nextPage = Base64.getEncoder().encodeToString(String.valueOf(currPage + 10).getBytes(StandardCharsets.UTF_8));
        return url.replace(KEY + value, KEY + nextPage);
    }

    private AppDesc getAppDesc(MyAppSearchJson bean, int i) {
        AppDesc appDesc = new AppDesc();
        appDesc.setName(bean.getName().get(i));
        appDesc.setAppId(bean.getAppId().get(i).toString());
        appDesc.setAppStore(APP_STORE);
        appDesc.setKindName(bean.getTagName().get(i));
        appDesc.setPackageName(bean.getPackageName().get(i));
        appDesc.setSize(bean.getSize().get(i).toString());
        appDesc.setTagName(bean.getTagName().get(i));
        appDesc.setUrl(bean.getUrl().get(i));
        appDesc.setVersion(bean.getVersion().get(i));
        return appDesc;
    }
}
