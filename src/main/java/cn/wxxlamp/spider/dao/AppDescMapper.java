package cn.wxxlamp.spider.dao;

import cn.wxxlamp.spider.config.MybatisConfiguration;
import cn.wxxlamp.spider.model.AppDesc;

/**
 * @author wxxlamp
 * @date 2021/03/30~17:44
 */
public class AppDescMapper {

    private static final ThreadLocal<AppDescDao> APP_DESC_DAO = new ThreadLocal<>();

    public static void mapper(AppDesc appDesc) {
        if (APP_DESC_DAO.get() == null) {
            APP_DESC_DAO.set(MybatisConfiguration.getDao(AppDescDao.class));
        }
        AppDescDao appDescDao = APP_DESC_DAO.get();
        AppDesc rawAppDesc = appDescDao.selectAppDescByAppIdAndAppStore(appDesc.getAppId(), appDesc.getAppStore());
        if (rawAppDesc == null) {
            appDescDao.insertAppDesc(appDesc);
        } else if (!rawAppDesc.equals(appDesc)) {
            appDesc.setId(rawAppDesc.getId());
            appDescDao.updateAppDescById(appDesc);
        }
    }
}
