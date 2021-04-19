package cn.wxxlamp.spider.model.search;

import cn.wxxlamp.spider.config.MybatisConfiguration;
import cn.wxxlamp.spider.dao.AppDescDao;
import cn.wxxlamp.spider.util.OtherUtils;
import cn.wxxlamp.spider.util.TagSearchUtils;
import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author wxxlamp
 * @date 2021/04/08~09:10
 */
@PipelineName("beanPipeline")
public class BeanPipeline implements Pipeline<Bean> {

    public static List<HttpRequest> list = new ArrayList<>(10_000);

    @Override
    public void process(Bean bean) {
        List<String> tagNameList = MybatisConfiguration.getDao(AppDescDao.class).selectDistinctNameFromAppDesc();

        for (String tag : tagNameList) {
            for (String url : Objects.requireNonNull(TagSearchUtils.getUrl(tag))) {
                list.add(bean.getRequest().subRequest(url));
            }
        }

        Collections.reverse(tagNameList);
//        String url = "https://www.iuuu9.com/app/";
//        String input = "[\"com.fanweilin.coordinatemap\",\"com.hnnx.mbank\",\"com.midea.ai.appliances\",\"com.benqu.wuta\",\"com.tmri.app.main\",\"com.sankuai.meituan\",\"com.youku.phone\",\"com.xiaochang.easylive\",\"com.lemon.lv\",\"com.alibaba.ailabs.tg\",\"com.dianping.v1\",\"my.maya.android\",\"com.xinhang.mobileclient\",\"com.shyz.toutiao\",\"cn.gov.tax.its\",\"com.ss.android.homed\",\"com.iflytek.smartsq\",\"com.xingin.xhs\",\"com.tencent.mm\",\"com.anjuke.android.app\",\"com.csii.zybk.ui\",\"com.xiangguoapp.live\",\"com.tencent.android.qqdownloader\",\"com.baidu.searchbox\",\"net.xuele.xuelets\",\"com.wuba\",\"com.wisentsoft.chinapost.android\",\"com.happyelements.AndroidAnimal\",\"com.meitu.meiyancamera\",\"com.tencent.mtt\",\"com.xunmeng.pinduoduo\",\"com.tencent.weishi\",\"com.cubic.autohome\",\"com.haier.uhome.uplus\",\"com.ehs.flutterappehs\",\"com.tal.tiku\",\"com.lemon.faceu\",\"com.ss.android.article.news\",\"com.xsrm.news.yucheng\",\"com.UCMobile\",\"com.ss.android.ugc.aweme\",\"com.tencent.mobileqq\",\"com.netease.newsreader.activity\",\"app.ehafo\",\"com.kugou.android\",\"com.clipzz.media\",\"com.snda.wifilocating\",\"com.kwai.videoeditor\",\"com.chinamworld.main\",\"com.tencent.news\",\"com.jingdong.app.mall\",\"cn.xuexi.android\",\"com.autonavi.minimap\",\"ctrip.android.view\",\"com.alibaba.android.rimet\",\"com.shinemo.hncy\",\"com.moji.mjweather\",\"com.sina.weibo\",\"com.neusoft.smartcity.henan\",\"com.smile.gifmaker\",\"com.mobile.myeye\",\"com.ss.android.article.video\",\"com.yitong.mbank.psbc\",\"com.baidu.netdisk\",\"com.taobao.taobao\",\"com.eg.android.AlipayGphone\",\"cn.wps.moffice_eng\",\"com.bytedance.ad.videotool\",\"com.zzbank.pibp\",\"com.cctv.yangshipin.app.androidp\",\"com.icitysuzhou.szjt\",\"com.xinhang.mobileclient\",\"com.MobileTicket\",\"com.ifeng.news2\",\"com.tencent.mm\",\"com.chinamworld.bocmbci\",\"com.csii.zybk.ui\",\"com.baidu.searchbox\",\"com.snda.lantern.wifilocating\",\"com.icbc\",\"com.tencent.mtt\",\"com.xunmeng.pinduoduo\",\"com.ximalaya.ting.android\",\"com.baidu.BaiduMap\",\"com.chinamworld.main\",\"com.ecitic.bank.mobile\",\"com.jingdong.app.mall\",\"com.dianshijia.tvlive\",\"com.autonavi.minimap\",\"com.moji.mjweather\",\"com.sina.weibo\",\"com.cgws.wealth\",\"com.taobao.taobao\",\"com.sgcc.wsgw.cn\",\"com.qihoo.camera\",\"com.sina.news\",\"com.eg.android.AlipayGphone\",\"com.youdao.translator\",\"com.baidu.homework\",\"com.coloros.apprecover\",\"com.coloros.onekeylockscreen\",\"com.unionpay.tsmservice\",\"com.qiyi.video\",\"com.sankuai.meituan\",\"com.youku.phone\",\"com.coloros.translate\",\"com.nearme.play\",\"com.lemon.lv\",\"com.heytap.health\",\"com.xingin.xhs\",\"com.tencent.mm\",\"com.csii.zybk.ui\",\"com.baidu.searchbox\",\"com.wuba\",\"com.coloros.familyguard\",\"com.coloros.shortcuts\",\"com.happyelements.AndroidAnimal\",\"com.oppo.community\",\"com.tencent.qqlive\",\"com.coloros.securityguard\",\"cn.wps.moffice.lite\",\"com.redteamobile.roaming\",\"com.tencent.mtt\",\"com.xunmeng.pinduoduo\",\"com.coloros.weather2\",\"com.ss.android.article.news\",\"com.coloros.compass2\",\"com.nearme.gamecenter\",\"com.ss.android.ugc.aweme\",\"com.coloros.note\",\"com.tencent.mobileqq\",\"com.duoduo.child.story\",\"com.kugou.android\",\"com.coloros.calculator\",\"com.snda.wifilocating\",\"com.coloros.operationtips\",\"com.coloros.oppopods\",\"com.baidu.BaiduMap\",\"com.coloros.personalassistant\",\"com.coloros.gamespaceui\",\"com.heytap.lab\",\"com.jingdong.app.mall\",\"com.tencent.karaoke\",\"com.bokecc.dance\",\"com.autonavi.minimap\",\"com.oppo.store\",\"com.coloros.soundrecorder\",\"com.android.email\",\"com.sina.weibo\",\"com.smile.gifmaker\",\"com.mkydqreader.io\",\"com.taobao.taobao\",\"com.heytap.book\",\"com.heytap.yoli\",\"com.coloros.videoeditor\",\"com.coloros.favorite\",\"com.eg.android.AlipayGphone\",\"com.heytap.smarthome\",\"com.achievo.vipshop\",\"so.ofo.labofo\",\"com.cctv.yangshipin.app.androidp\",\"com.lalamove.huolala.client\",\"com.sankuai.meituan\",\"com.tencent.qqmusic\",\"com.tencent.androidqqmail\",\"com.cleanmaster.mguard_cn\",\"com.shyz.toutiao\",\"cn.gov.tax.its\",\"com.MobileTicket\",\"com.microsoft.office.excel\",\"com.zhkj.rsapp_android\",\"com.tencent.mm\",\"com.csii.zybk.ui\",\"com.tencent.android.qqdownloader\",\"com.baidu.searchbox\",\"com.wuba\",\"com.huaanzq.dzh\",\"com.bbk.iqoo.feedback\",\"com.tencent.qqlive\",\"com.tencent.mtt\",\"com.xunmeng.pinduoduo\",\"com.tencent.weishi\",\"com.example.examda\",\"com.microsoft.office.word\",\"com.ss.android.article.news\",\"com.baidu.wenku\",\"com.qihoo.video\",\"com.tencent.mobileqq\",\"app.ehafo\",\"sogou.mobile.explorer.fangbei\",\"com.ximalaya.ting.android\",\"com.tencent.mtt.shortcut.doc\",\"com.bankcomm.maidanba\",\"com.vivo.singularity\",\"com.chinamworld.main\",\"com.dragon.read\",\"com.qihoo.appstore\",\"com.forms\",\"com.nuomi\",\"com.android.bbk.lockscreen3\",\"com.meituan.android.bus.luoyang\",\"com.jingdong.app.mall\",\"com.tencent.karaoke\",\"com.autonavi.minimap\",\"com.dingqu.doudizhu\",\"com.taobao.idlefish\",\"com.alibaba.android.rimet\",\"com.kmxs.reader\",\"com.vivo.vhome\",\"com.hundsun.stockwinner.hazq\",\"com.smile.gifmaker\",\"com.intsig.camscanner\",\"com.ss.android.article.video\",\"com.taobao.taobao\",\"com.eg.android.AlipayGphone\",\"cn.wps.moffice_eng\",\"com.achievo.vipshop\"]";
//        String inp = "[\"com.hnnx.mbank\", \"com.sxnxs.mbank\", \"com.android.bankabc\", \"com.cgbchina.xpt\", \"com.viper.wormhole\", \"csii.com.qny\",\"com.bankcomm.Bankcomm\", \"com.chinamworld.bocmbci\",\"com.csii.zybk.ui\", \"com.cn.froad.mobileplatform\", \"com.icbc\",\"com.jxnxs.mobile.bank\",\"com.dxgl.wssistanf\",\"com.csii.mobilebank\", \"com.csii.gdnx.mobilebank\", \"com.yitong.mbank\", \"com.cebbank.mobile.cemb\",\"com.youba.barcode\", \"com.ecitic.bank.mobile\", \"com.droi.adocker.pro\",\"com.cib.cibmb\", \"com.magicpoint.mobile.bank\", \"cn.jsb.china\"]";
//        String jinlong = "[\"com.fenqile.fenqile\",\"com.tmliutian01.phonelive12921540\",\"com.tencent.tmgp.sgame\",\"com.sohu.inputmethod.sogou\",\"com.android.bankabc\",\"com.lemon.lv\",\"com.tmcaihong01.phonelive12501540\",\"com.opsdoc.flutter_bilibili\",\"com.bankcomm.Bankcomm\",\"com.tencent.mm\",\"com.csii.zybk.ui\",\"com.publicread.simulationclick\",\"com.tencent.android.qqdownloader\",\"com.icbc\",\"cn.com.spdb.mobilebank.per\",\"com.tuyatv123.phonelive\",\"com.tencent.mtt\",\"com.ss.android.ugc.aweme\",\"com.tencent.mobileqq\",\"com.xjbg.nb.cartoonflutter\",\"com.woyue.batchat\",\"cn.ninegame.gamemanager\",\"com.jd.jrapp\",\"com.xunrui.duokai_box\",\"com.taobao.idlefish\",\"com.cmri.universalapp\",\"com.putaotec.mvoice\",\"com.jajimide.xingdepagek1\",\"com.example.xmoveapp\",\"com.netease.mc.aligames\",\"com.cib.cibmb\",\"com.taobao.taobao\",\"com.jianbian.potato\",\"com.eg.android.AlipayGphone\",\"com.hxb.mobile.client\",\"com.yeahka.android.happypay\"]";
//        List<String> strings = JSON.parseArray(inp, String.class);
//        List<String> stringss = JSON.parseArray(input, String.class);
//        List<String> stringsss = JSON.parseArray(jinlong, String.class);
//        for (String string : strings) {
//            list.add(bean.getRequest().subRequest(url + string));
//        }
//        for (String string : stringss) {
//            list.add(bean.getRequest().subRequest(url + string));
//        }
//        for (String string : stringsss) {
//            list.add(bean.getRequest().subRequest(url + string));
//        }
//        for (String string : OtherUtils.ERROR_PACKAGE_LIST) {
//            list.add(bean.getRequest().subRequest(url + string));
//        }
    }
}
