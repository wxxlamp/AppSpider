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

    public static String getUrl(String tag) {
        if (checkTag(tag)) {
            return null;
        }
        SET.add(tag);
        String codeTag = "|" + tag;
        try {
            codeTag = URLEncoder.encode(codeTag, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&uri=searchApp"
                + codeTag + "&maxResults=25&zone=CN&locale=zh";
    }
}
