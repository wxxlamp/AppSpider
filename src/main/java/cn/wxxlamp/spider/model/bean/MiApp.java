package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/04/02~09:50
 */
@Gecco(matchUrl = "https://app.mi.com/", pipelines = {"miAppPipeline"}, timeout = 10_000)
public class MiApp implements HtmlBean {

    private static final long serialVersionUID = 6766623354386912318L;

    @Request
    private HttpRequest request;

    @Href
    @HtmlField(cssPath = "body > div.main.index-page > div > div.sidebar > div:nth-child(2) > ul > li > a")
    private List<String> appUrl;

    @Href
    @HtmlField(cssPath = "body > div.main.index-page > div > div.sidebar > div:nth-child(3) > ul > li > a")
    private List<String> gameUrl;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<String> getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(List<String> appUrl) {
        this.appUrl = appUrl;
    }

    public List<String> getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(List<String> gameUrl) {
        this.gameUrl = gameUrl;
    }

    @Override
    public String toString() {
        return "MiApp{" +
                "request=" + request.getUrl() +
                ", appUrl=" + appUrl +
                ", gameUrl=" + gameUrl +
                '}';
    }
}
