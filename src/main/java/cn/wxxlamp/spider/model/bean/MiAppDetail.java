package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @author wxxlamp
 * @date 2021/04/02~09:56
 */
@Gecco(matchUrl = "https://app.mi.com/details?id={id}", pipelines = {"miAppDetailPipeline"})
public class MiAppDetail implements HtmlBean {

    private static final long serialVersionUID = 675462335438691818L;

    @HtmlField(cssPath = "body > div.main > div.container.cf > div.app-intro.cf > div > div > h3")
    private String appName;

    @HtmlField(cssPath = "body > div.main > div.container.cf > div:nth-child(10) > div.float-left > div:nth-child(2)")
    private String apkName;

    @HtmlField(cssPath = "body > div.main > div.container.cf > div:nth-child(4) > div.float-left > div:nth-child(2)")
    private String size;

    @Href
    @HtmlField(cssPath = "body > div.main > div.container.cf > div.app-intro.cf > div > div > div.app-info-down > a")
    private String url;

    @HtmlField(cssPath = "body > div.main > div.container.cf > div:nth-child(6) > div.float-left > div:nth-child(2)")
    private String version;

    @HtmlField(cssPath = "body > div.main > div.container.cf > div.bread-crumb > ul > li:nth-child(2) > a")
    private String tagName;

    @HtmlField(cssPath = "body > div.main > div.container.cf > div:nth-child(4) > div.float-right > div:nth-child(2)")
    private String appId;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "MiAppDetail{" +
                "appName='" + appName + '\'' +
                ", apkName='" + apkName + '\'' +
                ", size='" + size + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", tagName='" + tagName + '\'' +
                ", appId='" + appId + '\'' +
                '}';
    }
}
