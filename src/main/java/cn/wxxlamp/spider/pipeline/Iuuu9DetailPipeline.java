package cn.wxxlamp.spider.pipeline;

import cn.wxxlamp.spider.dao.AppDescMapper;
import cn.wxxlamp.spider.model.AppDesc;
import cn.wxxlamp.spider.model.bean.Iuuu9Detail;
import cn.wxxlamp.spider.util.Md5Utils;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;

/**
 * @author wxxlamp
 * @date 2021/04/10~17:49
 */
@PipelineName("iuuu9DetailPipeline")
public class Iuuu9DetailPipeline implements Pipeline<Iuuu9Detail> {

    private static final String APP_STORE = "IUUU_9";

    @Override
    public void process(Iuuu9Detail bean) {
        if (checkUrlAndProcess(bean.getRequest())) {
            AppDesc appDesc = getAppDesc(bean);
            AppDescMapper.mapper(appDesc);
        }
    }

    private boolean checkUrlAndProcess(HttpRequest request) {
        String url = request.getUrl();
        if (url.length() == 26 || url.contains("/app/c-")) {
            return false;
        }
        if (url.contains("/apk/c-")) {
            String nextUrl = url.replace("/apk/","/app/");
            DeriveSchedulerContext.into(request.subRequest(nextUrl));
            return false;
        }
        return true;
    }

    private AppDesc getAppDesc(Iuuu9Detail bean) {
        String packageName = bean.getRequest().getUrl().substring(26);
        String size = bean.getSize().substring(12);
        String tagName = bean.getTagName().substring(10);
        String version = bean.getVersion().substring(13);
        AppDesc appDesc = new AppDesc();
        appDesc.setName(bean.getName());
        appDesc.setAppId(Md5Utils.getMd5(bean.getName() + packageName));
        appDesc.setAppStore(APP_STORE);
        appDesc.setKindName(bean.getKindName());
        appDesc.setPackageName(packageName);
        appDesc.setSize(size);
        appDesc.setTagName(tagName);
        appDesc.setUrl(bean.getUrl());
        appDesc.setVersion(version);
        return appDesc;
    }
}
