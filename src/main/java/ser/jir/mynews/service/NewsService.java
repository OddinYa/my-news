package ser.jir.mynews.service;

import org.springframework.stereotype.Service;
import ser.jir.mynews.model.News;

import java.util.List;

@Service
public interface NewsService {

     void save(News news);


     boolean isExist(String newsTitle);


     List<News> getAllNews();


}
