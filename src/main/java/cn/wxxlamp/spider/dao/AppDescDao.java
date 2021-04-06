package cn.wxxlamp.spider.dao;

import cn.wxxlamp.spider.model.AppDesc;
import org.apache.ibatis.annotations.Param;

/**
 * @author wxxlamp
 * @date 2021/03/29~19:11
 */
public interface AppDescDao {

    /**
     * 通过appId和appStore获得该数据
     * @param appId appId
     * @param appStore appStore
     * @return {@link cn.wxxlamp.spider.model.AppDesc}
     */
    AppDesc selectAppDescByAppIdAndAppStore(@Param("appId") String appId, @Param("appStore") String appStore);

    /**
     * 通过id更新
     * @param appDesc appDesc
     */
    void updateAppDescById(AppDesc appDesc);

    /**
     * 自增
     * 插入AppDescription
     * @param appDesc appDesc
     */
    void insertAppDesc(AppDesc appDesc);
}
