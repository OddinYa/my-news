package ser.jir.mynews.job;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;
import ser.jir.mynews.model.News;
import ser.jir.mynews.service.NewsService;

import java.io.IOException;
import java.lang.annotation.Documented;

@Component
public class ParseTask {
    @Autowired
    NewsService newsService;


    @Scheduled(fixedDelay = 10000)
    public void parseNew() throws IOException {
        String url = "https://news.ycombinator.com/";

        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla")
                .timeout(5000)
                .referrer("https://google.com")
                .get();

        Elements news = doc.getElementsByClass("titlelink");
        for (Element el: news)
        {
            String title = el.ownText();

            if(!newsService.isExist(title)){
                News obj = new News(title);
                newsService.save(obj);
            }

        }
    }


}
