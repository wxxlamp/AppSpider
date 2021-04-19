package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.JsonBean;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/04/07~09:38
 */
@Gecco(matchUrl = "https://android.myapp.com/myapp/searchAjax.htm?kw={kw}&pns={pns}&sid=0",
        pipelines = {"myAppSearchJsonPipeline"}, timeout = 20_000)
public class MyAppSearchJson implements JsonBean {

    private static final long serialVersionUID = -5696033709028657709L;

    @Request
    private HttpRequest request;

    @JSONPath("$.obj.appDetails.appId")
    private List<Integer> appId;

    @JSONPath("$.obj.appDetails.appName")
    private List<String> name;

    @JSONPath("$.obj.appDetails.pkgName")
    private List<String> packageName;

    @JSONPath("$.obj.appDetails.fileSize")
    private List<Integer> size;

    @JSONPath("$.obj.appDetails.versionName")
    private List<String> version;

    @JSONPath("$.obj.appDetails.categoryName")
    private List<String> tagName;

    @JSONPath("$.obj.appDetails.apkUrl")
    private List<String> url;

    @JSONPath("$.obj.hasNext")
    private Integer hasNext;

    @JSONPath("$.success")
    private Boolean success;

    public List<Integer> getAppId() {
        return appId;
    }

    public void setAppId(List<Integer> appId) {
        this.appId = appId;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getPackageName() {
        return packageName;
    }

    public void setPackageName(List<String> packageName) {
        this.packageName = packageName;
    }

    public List<Integer> getSize() {
        return size;
    }

    public void setSize(List<Integer> size) {
        this.size = size;
    }

    public List<String> getVersion() {
        return version;
    }

    public void setVersion(List<String> version) {
        this.version = version;
    }

    public List<String> getTagName() {
        return tagName;
    }

    public void setTagName(List<String> tagName) {
        this.tagName = tagName;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }


    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public Integer getHasNext() {
        return hasNext;
    }

    public void setHasNext(Integer hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "MyAppSearchJson{" +
                "request=" + request.getUrl() +
                ", appId=" + appId +
                ", name=" + name +
                ", packageName=" + packageName +
                ", size=" + size +
                ", version=" + version +
                ", tagName=" + tagName +
                ", url=" + url +
                ", hasNext=" + hasNext +
                ", success=" + success +
                '}';
    }
}
