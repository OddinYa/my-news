package ser.jir.mynews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ser.jir.mynews.model.News;
import ser.jir.mynews.repository.NewsRepository;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsRepository repository;

    @Override
    public void save(News news) {

        repository.save(news);



    }

    @Override
    public boolean isExist(String newsTitle) {
       List<News> news = repository.findAll();
        for (News n: news)
        {
            if(n.getTitle().equals(newsTitle)){
                return true;
            }
        }
        return false;

    }

    @Override
    public List<News> getAllNews() {
        return repository.findAll();
    }
}
