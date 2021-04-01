package cn.wxxlamp.spider.dao;

import cn.wxxlamp.spider.config.MybatisConfiguration;
import cn.wxxlamp.spider.model.AppDesc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wxxlamp
 * @date 2021/03/30~17:44
 */
public class AppDescMapper {

    private static AppDescDao appDescDao;

    /**
     * 防止mybatis的insert数据一直在缓存中
     */
    private static final AtomicInteger COUNT = new AtomicInteger(0);

    private static final int THRESHOLD = 500;

    public static void mapper(AppDesc appDesc) {
        if (appDescDao == null) {
            appDescDao = MybatisConfiguration.getDao(AppDescDao.class);
        }
        AppDesc rawAppDesc = appDescDao.selectAppDescByAppIdAndAppStore(appDesc.getAppId(), appDesc.getAppStore());
        if (rawAppDesc == null) {
            appDescDao.insertAppDesc(appDesc);
        } else if (!rawAppDesc.equals(appDesc)) {
            appDescDao.updateAppDescById(appDesc);
        }
        if (COUNT.incrementAndGet() == THRESHOLD) {
            appDescDao = null;
            COUNT.set(0);
        }
    }
}
