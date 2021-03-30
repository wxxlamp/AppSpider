package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.JsonBean;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/03/30~16:56
 */
@Gecco(matchUrl = "https://android.myapp.com/cate/appList.htm?orgame={game}&categoryId={id}&pageSize=20&pageContext={page}",
        pipelines = {"myAppJsonPipeline"})
public class MyAppJson implements JsonBean {

    private static final long serialVersionUID = -5696033709028657709L;

    @Request
    private HttpRequest request;

    @JSONPath("$obj.appId")
    private List<Integer> appId;

    @JSONPath("$obj.appName")
    private List<String> name;

    @JSONPath("$.obj.pkgName")
    private List<String> packageName;

    @JSONPath("$.obj.fileSize")
    private List<Integer> size;

    @JSONPath("$.obj.versionName")
    private List<String> version;

    @JSONPath("$.obj.categoryName")
    private List<String> tagName;

    @JSONPath("$.obj.apkUrl")
    private List<String> url;

    @JSONPath("$.count")
    private Integer count;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "MyAppJson{" +
                "appId=" + appId +
                ", name=" + name +
                ", packageName=" + packageName +
                ", size=" + size +
                ", version=" + version +
                ", tagName=" + tagName +
                ", url=" + url +
                ", count=" + count +
                '}';
    }
}
