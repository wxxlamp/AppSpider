package cn.wxxlamp.spider.pipeline;

import cn.wxxlamp.spider.dao.AppDescMapper;
import cn.wxxlamp.spider.model.AppDesc;
import cn.wxxlamp.spider.model.bean.MyAppJson;
import cn.wxxlamp.spider.util.TagSearchUtils;
import cn.wxxlamp.spider.util.UrlUtils;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;

/**
 * @author wxxlamp
 * @date 2021/03/30~17:09
 */
@PipelineName("myAppJsonPipeline")
public class MyAppJsonPipeline implements Pipeline<MyAppJson> {

    private static final String APP_STORE = "MY_APP";

    private static final int COUNT = 20;

    @Override
    public void process(MyAppJson bean) {
        HttpRequest request = bean.getRequest();
        if (bean.getCount() == COUNT) {
            DeriveSchedulerContext.into(request.subRequest(UrlUtils.getMyAppNextUrl(request.getUrl())));
        }
        for (int i = 0; i < bean.getSize().size(); i++) {
            AppDesc appDesc = getAppDesc(bean, i);
            AppDescMapper.mapper(appDesc);
            // 搜索华为
            if (!TagSearchUtils.checkTag(appDesc.getTagName())) {
                DeriveSchedulerContext.into(bean.getRequest().subRequest(TagSearchUtils.getUrl(appDesc.getTagName())));
            }
        }
    }

    private AppDesc getAppDesc(MyAppJson bean, int i) {
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
