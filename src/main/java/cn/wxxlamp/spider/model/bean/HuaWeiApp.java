package cn.wxxlamp.spider.model.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.spider.JsonBean;

import java.util.List;

/**
 * @author wxxlamp
 * @date 2021/03/29~11:07
 */
@Gecco(matchUrl = "https://web-drcn.hispace.dbankcloud.cn/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum={page}&uri={kindUrl}&maxResults=25&zone=&locale=zh", pipelines = {"consolePipeline"})
public class HuaWeiApp implements JsonBean {

    public static final long serialVersionUID = 28393020212827837L;

    @JSONPath("$.layoutData[0].dataList.name")
    private List<String> name;

    @JSONPath("$.layoutData[0].dataList.kindName")
    private List<String> kindName;

    @JSONPath("$.layoutData[0].dataList.tagName")
    private List<String> tagName;

    @JSONPath("$.layoutData[0].dataList.sizeDesc")
    private List<String> size;

    @JSONPath("$.layoutData[0].dataList.package")
    private List<String> packageName;

    @JSONPath("$.layoutData[0].dataList.appVersionName")
    private List<String> version;

    @JSONPath("$.hasNextPage")
    private Integer hasNextPage;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getKindName() {
        return kindName;
    }

    public void setKindName(List<String> kindName) {
        this.kindName = kindName;
    }

    public List<String> getTagName() {
        return tagName;
    }

    public void setTagName(List<String> tagName) {
        this.tagName = tagName;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public List<String> getPackageName() {
        return packageName;
    }

    public void setPackageName(List<String> packageName) {
        this.packageName = packageName;
    }

    public List<String> getVersion() {
        return version;
    }

    public void setVersion(List<String> version) {
        this.version = version;
    }

    public Integer getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Integer hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    @Override
    public String toString() {
        return "HuaWeiApp{" +
                "name=" + name +
                ", kindName=" + kindName +
                ", tagName=" + tagName +
                ", size=" + size +
                ", packageName=" + packageName +
                ", version=" + version +
                ", hasNextPage=" + hasNextPage +
                '}';
    }
}
