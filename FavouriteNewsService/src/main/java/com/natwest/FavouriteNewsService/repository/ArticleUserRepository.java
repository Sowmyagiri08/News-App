package com.natwest.FavouriteNewsService.repository;

import com.natwest.FavouriteNewsService.model.Article;
import com.natwest.FavouriteNewsService.model.ArticleUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleUserRepository extends MongoRepository<ArticleUser,String> {
}
