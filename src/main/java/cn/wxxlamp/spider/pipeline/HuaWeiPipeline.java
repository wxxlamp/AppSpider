package cn.wxxlamp.spider.pipeline;

import cn.wxxlamp.spider.dao.AppDescMapper;
import cn.wxxlamp.spider.model.AppDesc;
import cn.wxxlamp.spider.model.bean.HuaWeiApp;
import cn.wxxlamp.spider.util.Md5Utils;
import cn.wxxlamp.spider.util.TagSearchUtils;
import cn.wxxlamp.spider.util.UrlUtils;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author wxxlamp
 * @date 2021/03/29~11:30
 */
@PipelineName("huaWeiPipeline")
public class HuaWeiPipeline implements Pipeline<HuaWeiApp> {

    public static final String APP_STORE = "HUAWEI";

    @Override
    public void process(HuaWeiApp bean) {
        if (bean.getHasNextPage() == 1) {
            HttpRequest request = bean.getRequest();
            String nextUrl = UrlUtils.getHuaWeiNextUrl(request.getUrl());
            DeriveSchedulerContext.into(request.subRequest(nextUrl));
        }
        // 默认bean属性的几个list#size全都一样
        for (int i = 0; i < bean.getName().size(); i++) {
            AppDesc appDesc = getAppDesc(bean, i);
            // Mybatis持久化
            AppDescMapper.mapper(appDesc);
            // 搜索华为和应用宝
            if (!TagSearchUtils.checkTag(appDesc.getTagName())) {
                for (String s : Objects.requireNonNull(TagSearchUtils.getUrl(appDesc.getTagName()))) {
                    DeriveSchedulerContext.into(bean.getRequest().subRequest(s));
                }
            }
            if (!TagSearchUtils.checkTag(appDesc.getName())) {
                for (String s : Objects.requireNonNull(TagSearchUtils.getUrl(appDesc.getName()))) {
                    DeriveSchedulerContext.into(bean.getRequest().subRequest(s));
                }
            }
        }
    }

   private AppDesc getAppDesc(HuaWeiApp bean, int i) {
        AppDesc appDesc = new AppDesc();
        appDesc.setName(bean.getName().get(i));
        appDesc.setAppId(Md5Utils.getMd5(bean.getName().get(i) + bean.getPackageName().get(i)));
        appDesc.setAppStore(APP_STORE);
        appDesc.setKindName(bean.getKindName().get(i));
        appDesc.setPackageName(bean.getPackageName().get(i));
        appDesc.setSize(bean.getSize().get(i));
        appDesc.setTagName(bean.getTagName().get(i));
        appDesc.setUrl("https://appgallery.huawei.com/#/app/" + bean.getAppId().get(i));
//        if (bean.getDownloadUrl() != null && bean.getDownloadUrl().size() > i) {
//            appDesc.setUrl(bean.getDownloadUrl().get(i));
//        }
        appDesc.setVersion(bean.getVersion().get(i));
        return appDesc;
   }
}
