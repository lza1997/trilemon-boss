package com.trilemon.boss.poster.template;

import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;

import static com.trilemon.boss.poster.template.PosterTemplateConstants.*;

/**
 * @author kevin
 */
public class PublishUtils {
    /**
     * 添加列表
     *
     * @param position
     * @param tag
     * @param html
     * @param desc
     * @return
     */
    public static String addHtml2DetailPage(byte position, String tag, Long pid, String html, String desc) {

        //生成待假如代码块
        String divId = tag + "-" + pid;
        StringBuilder sb = new StringBuilder();
        sb.append("<div id=\"" + divId + "\">");
        sb.append(html);
        sb.append("</div>");

        //插入宝贝描述
        switch (position) {
            case POSITION_TOP_START:
                desc = append2DescTopFirst(tag, pid, sb.toString(), desc);
                break;
            case POSITION_TOP_END:
                desc = append2DescTopLast(tag, pid, sb.toString(), desc);
                break;
            case POSITION_BOTTOM_START:
                desc = append2DescBottomFirst(tag, pid, sb.toString(), desc);
                break;
            case POSITION_BOTTOM_END:
                desc = append2DescBottomLast(tag, pid, sb.toString(), desc);
                break;
        }
        return desc;
    }

    private static String append2DescBottomFirst(String tag, Long pid, String html, String desc) {
        Document document = Jsoup.parseBodyFragment(desc);
        Elements elements = document.select("#" + tag);
        if (CollectionUtils.isEmpty(elements)) {
            return append2DescBottomLast(tag, pid, html, desc);
        } else {
            //寻找描述下面第一段我方代码，插入活动代码
            Element element = elements.last();
            element.append(html);
        }
        return document.body().html();
    }

    private static String append2DescTopFirst(String tag, Long pid, String html, String desc) {
        return html + desc;
    }

    private static String append2DescTopLast(String tag, Long pid, String html, String desc) {
        Document document = Jsoup.parseBodyFragment(desc);
        Elements elements = document.select("#" + tag);
        if (CollectionUtils.isEmpty(elements)) {
            return append2DescTopFirst(tag, pid, html, desc);
        } else {
            //寻找描述上面最后一段我方代码，插入活动代码
            Element element = elements.first();
            element.append(html);
        }
        return document.body().html();
    }

    private static String append2DescBottomLast(String tag, Long pid, String html, String desc) {
        return desc + html;
    }

    /**
     * 删除列表
     *
     * @param tag
     * @param desc
     */
    public static void deleteHtmlFromDetailPage(String tag, String desc) {
        Document document = Jsoup.parseBodyFragment(desc);
        Elements elements = document.select("#" + tag);
        for (Element element : elements) {
            element.remove();
        }
    }

    /**
     * 获取宝贝详情页中的活动列表
     *
     * @param desc
     * @return
     */
    public static Map<String, String> getDetailPageList(String tag, String desc) {
        Document document = Jsoup.parseBodyFragment(desc);
        Map<String, String> map = Maps.newHashMap();
        Elements elements = document.select("#" + tag);
        for (Element element : elements) {
            map.put(element.id(), element.html());
        }
        return map;
    }
}
