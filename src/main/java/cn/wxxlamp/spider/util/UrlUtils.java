package cn.wxxlamp.spider.util;

/**
 * @author wxxlamp
 * @date 2021/03/29~11:58
 */
public class UrlUtils {

    private static final Integer ZERO = 48;

    private static final String REQ_PAGE_NUM = "reqPageNum=";

    private static final char AND = '&';

    /**
     * 获得下一页的url
     * 目前针对于huawei
     * @param origin 原始url
     * @return 下一页的url
     */
    public static String getNextUrl(String origin) {
        int index = origin.indexOf(REQ_PAGE_NUM) + REQ_PAGE_NUM.length();
        int currPage = 0;
        while (origin.charAt(index) != AND) {
            currPage *= 10;
            currPage += origin.charAt(index ++) - ZERO;
        }
        return origin.replace(REQ_PAGE_NUM + currPage, REQ_PAGE_NUM + (currPage + 1));
    }
}
