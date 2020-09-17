package com.natwest.FavouriteNewsService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ArticleUser {

    @Id
    private String userId;
    private List<Article> articles;

    public ArticleUser() {
    }

    public ArticleUser(String userId, List<Article> articles) {
        this.userId = userId;
        this.articles = articles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "ArticleUser{" +
                "userId='" + userId + '\'' +
                ", articles=" + articles +
                '}';
    }
}
