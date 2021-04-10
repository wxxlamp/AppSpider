package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * https://www.iuuu9.com/
 * @author wxxlamp
 * @date 2021/04/09~16:59
 */
@Gecco(matchUrl = "https://www.iuuu9.com/", pipelines = "consolePipeline")
public class Iuuu9Index implements HtmlBean {

    private static final long serialVersionUID = 6766623314386912318L;

    @Href(click = true)
    @HtmlField(cssPath = "body > div:nth-child(5) > div.box > div.w200.fl > ul > li > a")
    private List<String> appHref;

    @Href(click = true)
    @HtmlField(cssPath = "body > div:nth-child(7) > div.box > div.w200.fl > ul > li > a")
    private List<String> gameHref;

    public List<String> getAppHref() {
        return appHref;
    }

    public void setAppHref(List<String> appHref) {
        this.appHref = appHref;
    }

    public List<String> getGameHref() {
        return gameHref;
    }

    public void setGameHref(List<String> gameHref) {
        this.gameHref = gameHref;
    }

    @Override
    public String toString() {
        return "Iuuu9Index{" +
                "appHref=" + appHref +
                ", gameHref=" + gameHref +
                '}';
    }
}
