package cn.wxxlamp.spider.dao;

import cn.wxxlamp.spider.config.MybatisConfiguration;
import cn.wxxlamp.spider.model.AppDesc;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/03/30~17:44
 */
public class AppDescMapper {

    private static final ThreadLocal<AppDescDao> APP_DESC_DAO = new ThreadLocal<>();

    private static final Log LOGGER = LogFactory.getLog(AppDescMapper.class);

    public static void mapper(AppDesc appDesc) {
        if (APP_DESC_DAO.get() == null) {
            APP_DESC_DAO.set(MybatisConfiguration.getDao(AppDescDao.class));
        }
        AppDescDao appDescDao = APP_DESC_DAO.get();
        List<AppDesc> appDescList = appDescDao.selectAppDescByPackageName(appDesc.getPackageName());
        if (appDescList == null || appDescList.size() == 0) {
            appDescDao.insertAppDesc(appDesc);
        } else {
            LOGGER.info(appDescList.get(0));
        }
//        AppDesc rawAppDesc = appDescDao.selectAppDescByAppIdAndAppStore(appDesc.getAppId(), appDesc.getAppStore());
//        if (rawAppDesc == null) {
//            appDescDao.insertAppDesc(appDesc);
//        } else if (!rawAppDesc.equals(appDesc)) {
//            appDesc.setId(rawAppDesc.getId());
//            appDescDao.updateAppDescById(appDesc);
//        }
    }
}
