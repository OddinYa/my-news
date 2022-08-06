package ser.jir.mynews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ser.jir.mynews.service.NewsService;
import ser.jir.mynews.model.News;
import java.util.List;

@RestController
public class NewController {

    @Autowired
    NewsService newService;

    @GetMapping(value = "/news")
    public List<News> getAllNews(){
        return newService.getAllNews();
    }

}
