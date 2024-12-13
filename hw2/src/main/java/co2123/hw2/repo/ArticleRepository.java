package co2123.hw2.repo;

import co2123.hw2.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

    List<Article> findByVisits(int visits);
}
