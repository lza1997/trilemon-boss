package com.trilemon.boss.poster.template;

import com.google.common.collect.Maps;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;

import static com.trilemon.boss.poster.template.PosterTemplateConstants.PUBLISH_POSITION_BOTTOM;
import static com.trilemon.boss.poster.template.PosterTemplateConstants.PUBLISH_POSITION_TOP;

/**
 * @author kevin
 */
public class PublishUtils {
    /**
     * 添加列表
     *
     * @param position
     * @param pType
     * @param html
     * @param desc
     * @return
     */
    public static String addHtml2DetailPage(byte position, String pType, Long pid, String html, String desc) {

        //生成待假如代码块
        StringBuilder sb = new StringBuilder();
        sb.append("<div id=\"" + getTag(pType, pid) + "\">");
        sb.append(html);
        sb.append("</div>");

        //插入宝贝描述
        switch (position) {
            case PUBLISH_POSITION_TOP:
                desc = append2DescTopFirst(pType, pid, sb.toString(), desc);
                break;
            case PUBLISH_POSITION_BOTTOM:
                desc = append2DescBottomLast(pType, pid, sb.toString(), desc);
                break;
        }
        return desc;
    }

    private static String append2DescTopFirst(String pType, Long pid, String html, String desc) {
        return html + desc;
    }

    private static String append2DescBottomLast(String pType, Long pid, String html, String desc) {
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

    /**
     * 把海报从详情页中移除
     *
     * @param pType
     * @param pid
     * @param desc
     * @return
     */
    public static String removeHtmlFromDetailPage(String pType, Long pid, String desc) {
        deleteHtmlFromDetailPage(getTag(pType, pid), desc);
        return desc;
    }

    public static String getTag(String pType, Long pid) {
        return pType + "-" + pid;

    }
}
