package cn.wxxlamp.spider.util;

import cn.wxxlamp.spider.model.AppDesc;
import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/04/10~18:54
 */
public class OtherUtils {

    private static final String ERROR_PACKAGE = "[\n" +
            "  \"de.robv.android.xposed.installer\",\n" +
            "  \"com.soft.controllers\",\n" +
            "  \"com.soft.apk008v\",\n" +
            "  \"com.soft.apk008Tool\",\n" +
            "  \"com.doubee.ig\",\n" +
            "  \"com.cyjh.mobileanjian\",\n" +
            "  \"com.ruokuai.rktech\",\n" +
            "  \"com.topjohnwu.magisk\",\n" +
            "  \"com.kingroot.kinguser\",\n" +
            "  \"com.saurik.substrate\",\n" +
            "  \"com.touchsprite.android\",\n" +
            "  \"com.stardust.scriptdroid\",\n" +
            "  \"com.mobileuncle.toolhero\",\n" +
            "  \"com.huluxia.gametools\",\n" +
            "  \"com.gmail.heagoo.apkeditor.pro\",\n" +
            "  \"com.sollyu.xposed.hook.model.dev\",\n" +
            "  \"com.txy.anywhere\",\n" +
            "  \"pro.burgerz.wsm.manager\",\n" +
            "  \"com.virtualdroid.loc\",\n" +
            "  \"com.virtualdroid.txl\",\n" +
            "  \"com.virtualdroid.wzs\",\n" +
            "  \"com.virtualdroid.kit\",\n" +
            "  \"com.virtualdroid.wxg\",\n" +
            "  \"com.virtualdroid.gps\",\n" +
            "  \"top.a1024bytes.mockloc.ca.pro\",\n" +
            "  \"com.deruhai.guangzi.noroot2\",\n" +
            "  \"com.mcmonjmb.yggb\",\n" +
            "  \"xiake.xserver\",\n" +
            "  \"com.dracrays.fakeloc\",\n" +
            "  \"net.anylocation.ultra\",\n" +
            "  \"com.wifi99.android.locationcheater\",\n" +
            "  \"com.dingweizshou\",\n" +
            "  \"top.a1024bytes.mockloc.ca.pro\",\n" +
            "  \"com.txy.anywhere.clone\",\n" +
            "  \"com.dracrays.fakelocc\",\n" +
            "  \"com.tandy.android.mockwxlocation\",\n" +
            "  \"net.anylocation\",\n" +
            "  \"com.sigma_rt.totalcontrol\",\n" +
            "  \"com.chuangdian.ipjl2\"\n" +
            "]";

    public static List<String> ERROR_PACKAGE_LIST = JSON.parseArray(ERROR_PACKAGE, String.class);

    public static boolean contains(AppDesc appDesc) {
        if (ERROR_PACKAGE_LIST.contains(appDesc.getPackageName())) {
            IoUtils.writeFile("existApk", appDesc, true);
            return true;
        }
        return false;
    }
}
