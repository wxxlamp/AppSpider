package cn.wxxlamp.spider.model.search;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @author wxxlamp
 * @date 2021/04/08~09:08
 */
@Gecco(matchUrl = "https://cmd5.com/", pipelines = "beanPipeline")
public class Bean implements HtmlBean {

    private static final long serialVersionUID = 6756623354386222318L;

    @Request
    private HttpRequest request;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }
}
