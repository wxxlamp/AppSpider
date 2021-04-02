package cn.wxxlamp.spider.pipeline;

import cn.wxxlamp.spider.dao.AppDescMapper;
import cn.wxxlamp.spider.model.AppDesc;
import cn.wxxlamp.spider.model.bean.MiAppDetail;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

/**
 * @author wxxlamp
 * @date 2021/04/02~10:44
 */
@PipelineName("miAppDetailPipeline")
public class MiAppDetailPipeline implements Pipeline<MiAppDetail> {

    private static final String MI_APP = "MI";

    @Override
    public void process(MiAppDetail bean) {
        AppDesc appDesc = getAppDesc(bean);
        AppDescMapper.mapper(appDesc);
    }

    private AppDesc getAppDesc(MiAppDetail bean) {
        AppDesc appDesc = new AppDesc();
        appDesc.setVersion(bean.getVersion());
        appDesc.setUrl(bean.getUrl());
        appDesc.setTagName(bean.getTagName());
        appDesc.setPackageName(bean.getApkName());
        appDesc.setKindName(bean.getTagName());
        appDesc.setSize(bean.getSize());
        appDesc.setAppStore(MI_APP);
        appDesc.setName(bean.getAppName());
        appDesc.setAppId(bean.getAppId());
        return appDesc;
    }
}
