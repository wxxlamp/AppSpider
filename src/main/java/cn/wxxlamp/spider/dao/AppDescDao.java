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
    String selectAppDescByAppIdAndAppStore(@Param("appId") String appId, @Param("appStore") String appStore);

    /**
     * 通过id更新
     * @param appDesc appDesc
     * @return 是否成功
     */
    int updateAppDescById(AppDesc appDesc);

    /**
     * 自增
     * 插入AppDescription
     * @param appDesc appDesc
     * @return 是否成功
     */
    int insertAppDesc(AppDesc appDesc);
}
