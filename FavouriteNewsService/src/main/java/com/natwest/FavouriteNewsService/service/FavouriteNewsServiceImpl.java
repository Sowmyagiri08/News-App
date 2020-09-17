package com.natwest.FavouriteNewsService.service;

import com.natwest.FavouriteNewsService.exception.ArticleNotFoundException;
import com.natwest.FavouriteNewsService.exception.UserNotFoundException;
import com.natwest.FavouriteNewsService.model.Article;
import com.natwest.FavouriteNewsService.model.ArticleUser;
import com.natwest.FavouriteNewsService.repository.ArticleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FavouriteNewsServiceImpl implements FavouriteNewsService {

    private ArticleUserRepository articleUserRepository;

    @Autowired
    public FavouriteNewsServiceImpl(ArticleUserRepository articleUserRepository) {
        this.articleUserRepository = articleUserRepository;
    }

    @Override
    public boolean createArticle(Article article) {
        UUID uuid=UUID.randomUUID();
        article.setArticleId(uuid.toString());
        ArticleUser newArticleUser = new ArticleUser();
        newArticleUser.setUserId(article.getArticleAddedBy());
        newArticleUser.setArticles(new ArrayList<>());
        newArticleUser.getArticles().add(article);
        ArticleUser addedArticleUser = null;
        Optional<ArticleUser> optionalArticleUser = articleUserRepository.findById(article.getArticleAddedBy());
        if (optionalArticleUser.isPresent()) {
            optionalArticleUser.get().getArticles().add(article);
            addedArticleUser = articleUserRepository.save(optionalArticleUser.get());
        } else {
            addedArticleUser = articleUserRepository.insert(newArticleUser);
        }
        if (addedArticleUser == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean deleteArticle(String userId, String articleId) {
        Optional<ArticleUser> articleUser = articleUserRepository.findById(userId);
        if (articleUser.isPresent()) {
            List<Article> articles = articleUser.get().getArticles();
            boolean status = articles.removeIf(n -> n.getArticleId().equals(articleId));
            articleUserRepository.save(articleUser.get());
            return status;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteAllArticles(String userId) throws UserNotFoundException, ArticleNotFoundException {
        Optional<ArticleUser> optionalArticleUser = articleUserRepository.findById(userId);
        if (optionalArticleUser.isPresent()) {
            ArticleUser articleUser = optionalArticleUser.get();
            List<Article> articles = articleUser.getArticles();
            if (articles.isEmpty()) {
                throw new ArticleNotFoundException("No Articles found");
            } else {
                articleUser.getArticles().clear();
                articleUserRepository.save(articleUser);
                return true;
            }
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public Article updateArticle(Article article, String articleId, String userId) throws ArticleNotFoundException {
        try {
            Optional<ArticleUser> articleUser = articleUserRepository.findById(userId);
            if (articleUser.isPresent()) {
                Article foundArticle = articleUser.get().getArticles().stream()
                        .filter(n -> n.getArticleId().equals(articleId))
                        .findAny()
                        .orElse(null);
                if (foundArticle != null) {
                    article.setArticleId(articleId);
                    ArticleUser foundArticleUser = articleUser.get();
                    copyArticle(article, foundArticle);
                    articleUserRepository.save(foundArticleUser);
                    return article;
                } else {
                    throw new ArticleNotFoundException("Article not found");
                }
            } else {
                throw new ArticleNotFoundException("Article not found");
            }
        } catch (NoSuchElementException e) {
            throw new ArticleNotFoundException("Article not found");
        }
    }

    @Override
    public Article getArticleByArticleId(String userId, String articleId) throws ArticleNotFoundException {
        try {
            Optional<ArticleUser> articleUser = articleUserRepository.findById(userId);
            if (articleUser.isPresent()) {
                Article article = articleUser.get().getArticles().stream().filter(n -> n.getArticleId().equals(articleId)).findAny().orElse(null);
                if (article != null) {
                    return article;
                } else {
                    throw new ArticleNotFoundException("Article not found");
                }
            } else {
                throw new ArticleNotFoundException("Article not found");
            }
        } catch (NoSuchElementException e) {
            throw new ArticleNotFoundException("Article not found");
        }
    }

    @Override
    public List<Article> getAllArticleByUserId(String userId) {
        Optional<ArticleUser> articleUser = articleUserRepository.findById(userId);
        if (articleUser.isPresent()) {
            return articleUser.get().getArticles();
        } else {
            return null;
        }
    }

    public void copyArticle(Article source, Article dest) {
        dest.setSource(source.getSource());
        dest.setAuthor(source.getAuthor());
        dest.setTitle(source.getTitle());
        dest.setDescription(source.getDescription());
        dest.setUrl(source.getUrl());
        dest.setUrlToImage(source.getUrlToImage());
        dest.setPublishedAt(source.getPublishedAt());
        dest.setContent(source.getContent());
    }
}
