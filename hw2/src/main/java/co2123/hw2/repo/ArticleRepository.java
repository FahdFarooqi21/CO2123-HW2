package co2123.hw2.repo;

import co2123.hw2.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
