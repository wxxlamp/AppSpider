package cn.wxxlamp.spider.dao;

import cn.wxxlamp.spider.config.MybatisConfiguration;
import cn.wxxlamp.spider.model.AppDesc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wxxlamp
 * @date 2021/03/30~17:44
 */
public class AppDescMapper {

    private static final ThreadLocal<AppDescDao> APP_DESC_DAO = new ThreadLocal<>();

    private static final AtomicInteger COUNT = new AtomicInteger(0);

    /**
     * 防止mybatis的insert数据一直在缓存中,500次数据一次事务commit
     */
    private static final int THRESHOLD = 500;

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
        if (COUNT.incrementAndGet() == THRESHOLD) {
            APP_DESC_DAO.remove();
            COUNT.set(0);
        }
    }
}
