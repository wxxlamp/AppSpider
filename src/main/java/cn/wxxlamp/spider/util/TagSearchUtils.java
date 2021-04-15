package cn.wxxlamp.spider.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 在华为商城中，通过分类继续查询
 * @author wxxlamp
 * @date 2021/04/06~10:17
 */
public class TagSearchUtils {

    private static final CopyOnWriteArraySet<String> SET = new CopyOnWriteArraySet<>();

    public static boolean checkTag(String tag) {
        return SET.contains(tag);
    }

    public static String[] getUrl(String tag) {
        if (checkTag(tag)) {
            return new String[]{};
        }
        SET.add(tag);
        String codeTagHuaWei = "|" + tag;
        String codeTagMyApp = tag;
        try {
            codeTagHuaWei = URLEncoder.encode(codeTagHuaWei, "UTF-8");
            codeTagMyApp = URLEncoder.encode(codeTagMyApp, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String urlHuaWei = "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=searchApp"
                + codeTagHuaWei + "&maxResults=25&zone=CN&locale=zh";
        String urlMyApp = "https://android.myapp.com/myapp/searchAjax.htm?kw=" + codeTagMyApp + "&pns=MA==&sid=0";
        String iuuu9 = "https://www.iuuu9.com/s/s-" + codeTagMyApp;
        return new String[]{urlHuaWei};
    }
}
