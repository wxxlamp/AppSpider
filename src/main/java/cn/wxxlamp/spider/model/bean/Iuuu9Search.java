package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/04/09~17:11
 */
@Gecco(matchUrl = "https://www.iuuu9.com/s/s-{kw}")
public class Iuuu9Search {

    @Href(click = true)
    @HtmlField(cssPath = "body > div.wrap > div.main > div.searApp > dl > dd:nth-child(2) > h3 > a")
    private List<String> href;

    @Href(click = true)
    @HtmlField(cssPath = "body > div.wrap > div.main > div.searApp > div > a:nth-child(3)")
    private String nextPage;
}
