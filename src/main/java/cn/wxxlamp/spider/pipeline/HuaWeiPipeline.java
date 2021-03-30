package cn.wxxlamp.spider.pipeline;

import cn.wxxlamp.spider.config.MybatisConfiguration;
import cn.wxxlamp.spider.dao.AppDescDao;
import cn.wxxlamp.spider.model.AppDesc;
import cn.wxxlamp.spider.model.bean.HuaWeiApp;
import cn.wxxlamp.spider.util.UrlUtils;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;

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
            String nextUrl = UrlUtils.getNextUrl(request.getUrl());
            DeriveSchedulerContext.into(request.subRequest(nextUrl));
        }
        // 默认bean属性的几个list#size全都一样
        for (int i = 0; i < bean.getName().size(); i++) {
            AppDesc appDesc = getAppDesc(bean, i);
            // Mybatis持久化
            AppDescDao appDescDao = MybatisConfiguration.getDao(AppDescDao.class);
            AppDesc rawAppDesc = appDescDao.selectAppDescByAppIdAndAppStore(appDesc.getAppId(), appDesc.getAppStore());
            if (rawAppDesc == null) {
                appDescDao.insertAppDesc(appDesc);
            } else if (!rawAppDesc.equals(appDesc)) {
                appDescDao.updateAppDescById(appDesc);
            }
        }
    }

   private AppDesc getAppDesc(HuaWeiApp bean, int i) {
        AppDesc appDesc = new AppDesc();
        appDesc.setName(bean.getName().get(i));
        appDesc.setAppId(bean.getId().get(i));
        appDesc.setAppStore(APP_STORE);
        appDesc.setKindName(bean.getKindName().get(i));
        appDesc.setPackageName(bean.getPackageName().get(i));
        appDesc.setSize(bean.getSize().get(i));
        appDesc.setTagName(bean.getTagName().get(i));
        appDesc.setUrl(bean.getDownloadUrl().get(i));
        appDesc.setVersion(bean.getVersion().get(i));
        return appDesc;
   }
}
