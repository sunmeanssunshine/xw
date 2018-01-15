import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by xuwei on 2018/1/4.
 */
public class CrawlerStudy {
    @Test
    public void test1() throws IOException {
        String baseUrl = "https://www.zhihu.com/explore/recommendations";

        Document doc = Jsoup
                .connect(baseUrl)
                .userAgent("Mozilla/6.0")
                .get();

        Element main = doc.getElementById("zh-recommend-list-full");
        Elements url = main.select("div").select("div:nth-child(2)")
                .select("h2").select("a[class=question_link]");
        for(Element question:url){
            //输出href后的值，即主页上每个关注问题的链接
            String URL=question.attr("abs:href");
            //下载问题链接指向的页面
            Document document2=Jsoup.connect(URL)
                    .userAgent("Mozilla/6.0")
                    .get();
            //问题
            //Elements title=document2.select("#zh-question-title").select("h2").select("a");
            Elements title = document2.body().select("h1");
            //问题描述
            //Elements detail = document2.select("#zh-question-detail");
            Elements detail = document2.select("#QuestionHeader-detail");
            //回答
            Elements answer=document2.select("#zh-question-answer-wrap")
                    .select("div.zm-item-rich-text.expandable.js-collapse-body")
                    .select("div.zm-editable-content.clearfix");
            System.out.println("\n"+"链接："+URL
                    +"\n"+"标题："+title.text()
                    +"\n"+"问题描述："+detail.text()
                    +"\n"+"回答："+answer.text());
        }
    }
}
