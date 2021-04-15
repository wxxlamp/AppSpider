package cn.wxxlamp.spider.dao;

import cn.wxxlamp.spider.config.MybatisConfiguration;
import cn.wxxlamp.spider.model.AppDesc;
import cn.wxxlamp.spider.util.OtherUtils;
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
        int count = 0;
        AppDescDao appDescDao = MybatisConfiguration.getDao(AppDescDao.class);
        for (String s : OtherUtils.ERROR_PACKAGE_LIST) {
            List<AppDesc> appDescList = appDescDao.selectAppDescByPackageName(s);
            if (appDescList != null && appDescList.size() != 0) {
                count ++;
            }
            System.out.println(s + ": " + appDescDao.selectAppDescByPackageName(s));
        }
        System.out.println(count + "/" + OtherUtils.ERROR_PACKAGE_LIST.size());
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