package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @author wxxlamp
 * @date 2021/04/09~17:05
 */
@Gecco(matchUrl = "https://www.iuuu9.com/ap{p}/{package}", pipelines = "iuuu9DetailPipeline", timeout = 10_000)
public class Iuuu9Detail implements HtmlBean {

    private static final long serialVersionUID = 6763623354386912318L;

    @Request
    private HttpRequest request;

    @HtmlField(cssPath = "body > div:nth-child(5) > div.infoSub > div.subAppicon > h3")
    private String name;

    @HtmlField(cssPath = "body > div:nth-child(4) > p > a:nth-child(5)")
    private String kindName;

    @HtmlField(cssPath = "body > div:nth-child(5) > div.infoMain > table > tbody > tr:nth-child(1) > td:nth-child(1)")
    private String tagName;

    @HtmlField(cssPath = "body > div:nth-child(5) > div.infoMain > table > tbody > tr:nth-child(1) > td:nth-child(2)")
    private String size;

    @HtmlField(cssPath = "body > div:nth-child(5) > div.infoMain > table > tbody > tr:nth-child(2) > td:nth-child(1)")
    private String version;

    @Href
    @HtmlField(cssPath = "body > div:nth-child(5) > div.infoSub > div.subAppicon > div.btnAndroid > a")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }
}
