package com.natwest.FavouriteNewsService.service;

import com.natwest.FavouriteNewsService.exception.ArticleNotFoundException;
import com.natwest.FavouriteNewsService.exception.UserNotFoundException;
import com.natwest.FavouriteNewsService.model.Article;

import java.util.List;

public interface FavouriteNewsService {

    boolean createArticle(Article article);

    boolean deleteArticle(String userId, String articleId);

    boolean deleteAllArticles(String userId) throws UserNotFoundException, ArticleNotFoundException;

    Article updateArticle(Article article, String articleId, String userId) throws ArticleNotFoundException;

    Article getArticleByArticleId(String userId,String articleId) throws ArticleNotFoundException;

    List<Article> getAllArticleByUserId(String userId);
}
