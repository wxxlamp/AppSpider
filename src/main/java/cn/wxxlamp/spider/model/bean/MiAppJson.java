package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.JsonBean;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/04/02~09:46
 */
@Gecco(matchUrl = "https://app.mi.com/categotyAllListApi?page={p}&categoryId={id}&pageSize=30", pipelines = {"miAppJsonPipeline"})
public class MiAppJson implements JsonBean {

    private static final long serialVersionUID = 6756623354386912318L;

    @Request
    private HttpRequest request;

    @JSONPath("$.data.packageName")
    private List<String> urlDetail;

    public List<String> getUrlDetail() {
        return urlDetail;
    }

    public void setUrlDetail(List<String> urlDetail) {
        this.urlDetail = urlDetail;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "MiApp{" +
                "request=" + request.getUrl() +
                "urlDetail=" + urlDetail +
                '}';
    }
}
