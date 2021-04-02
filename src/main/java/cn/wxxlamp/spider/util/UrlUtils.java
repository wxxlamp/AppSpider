package cn.wxxlamp.spider.util;

/**
 * @author wxxlamp
 * @date 2021/03/29~11:58
 */
public class UrlUtils {

    public static final String HUAWEI_KEY = "reqPageNum=";

    public static final String MY_APP_KIND = "orgame=";

    public static final String MY_APP_CATEGORY = "categoryId=";

    public static final String MY_APP_CONTEXT = "pageContext=";

    public static final String MI_APP_PAGE = "page=";

    private static final Integer ZERO = 48;

    private static final char AND = '&';

    private static final char MINUS = '-';

    /**
     * 获得下一页的url
     * 目前针对于huawei
     * @param origin 原始url
     * @return 下一页的url
     */
    public static String getHuaWeiNextUrl(String origin) {
        return getNextUrl(origin, HUAWEI_KEY, 1);
    }

    public static String getMyAppNextUrl(String origin) {
        return getNextUrl(origin, MY_APP_CONTEXT, 20);
    }

    public static String getMiAppNextUrl(String origin) {
        return getNextUrl(origin, MI_APP_PAGE, 1);
    }

    private static String getNextUrl(String url, String key, int step) {
        int currPage = getUrlValue(url, key);
        return url.replace(key + currPage, key + (currPage + step));
    }

    public static Integer getUrlValue(String url, String key) {
        int index = url.indexOf(key) + key.length();
        int value = 0;
        boolean minus = false;
        if (url.charAt(index) == MINUS) {
            index ++;
            minus = true;
        }
        while (index < url.length() && url.charAt(index) != AND) {
            value *= 10;
            value += url.charAt(index ++) - ZERO;
        }
        return minus ? -value : value;
    }
}
