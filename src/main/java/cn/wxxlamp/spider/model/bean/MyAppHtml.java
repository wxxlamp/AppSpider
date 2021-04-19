package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * 爬取分类链接，为后续解析json做准备
 * @author wxxlamp
 * @date 2021/03/30~16:53
 */
@Gecco(matchUrl = "https://android.myapp.com/myapp/index.htm", pipelines = {"consolePipeline", "myAppHtmlPipeline"}, timeout = 20_000)
public class MyAppHtml implements HtmlBean {

    private static final long serialVersionUID = 665662335318691818L;

    @Request
    private HttpRequest request;

    @Href
    @HtmlField(cssPath = "body > div.com-container > div.ind-appbody-container > div.ind-appbody-left > div.ind-catelist > dl > dd > a")
    private List<String> categoryUrlList;

    public List<String> getCategoryUrlList() {
        return categoryUrlList;
    }

    public void setCategoryUrlList(List<String> categoryUrlList) {
        this.categoryUrlList = categoryUrlList;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "MyAppHtml{" +
                "categoryUrlList=" + categoryUrlList +
                '}';
    }
}
