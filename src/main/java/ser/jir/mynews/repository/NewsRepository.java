package ser.jir.mynews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ser.jir.mynews.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {
}
