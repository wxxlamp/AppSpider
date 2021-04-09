package cn.wxxlamp.spider.dao;

import cn.wxxlamp.spider.config.MybatisConfiguration;
import cn.wxxlamp.spider.model.AppDesc;
import org.junit.Test;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/04/06~09:09
 */
public class AppDescMapperTest {

    @Test
    public void test() {
        AppDesc appDesc = getAppDesc();
        AppDescMapper.mapper(appDesc);
    }

    @Test
    public void testQuery(){
        System.out.println(MybatisConfiguration.getDao(AppDescDao.class).selectDistinctNameFromAppDesc().size());


    }

    private AppDesc getAppDesc() {
        AppDesc appDesc = new AppDesc();
        appDesc.setAppId("test");
        appDesc.setName("test");
        appDesc.setAppStore("test");
        appDesc.setSize("test");
        appDesc.setKindName("test");
        appDesc.setPackageName("test");
        appDesc.setTagName("test");
        appDesc.setUrl("test1");
        appDesc.setVersion("test");
        return appDesc;
    }
}