package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/04/09~17:02
 */
@Gecco(matchUrl = "https://www.iuuu9.com/app/c-{page}", pipelines = "consolePipeline")
public class Iuuu9Category implements HtmlBean {

    private static final long serialVersionUID = 6766623354383912318L;

    @Href(click = true)
    @HtmlField(cssPath = "body > div:nth-child(6) > div.recommendList > ul > li > a:nth-child(1)")
    private List<String> appHref;

    @Href(click = true)
    @HtmlField(cssPath = "body > div:nth-child(6) > div.recommendList > div > a:nth-child(7)")
    private String nextPage;

    public List<String> getAppHref() {
        return appHref;
    }

    public void setAppHref(List<String> appHref) {
        this.appHref = appHref;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    @Override
    public String toString() {
        return "Iuuu9Category{" +
                "appHref=" + appHref +
                ", nextPage='" + nextPage + '\'' +
                '}';
    }
}
