package com.natwest.FavouriteNewsService.controller;

import com.natwest.FavouriteNewsService.exception.ArticleNotFoundException;
import com.natwest.FavouriteNewsService.exception.UserNotFoundException;
import com.natwest.FavouriteNewsService.model.Article;
import com.natwest.FavouriteNewsService.service.FavouriteNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class FavouriteNewsController {

    private FavouriteNewsService favouriteNewsService;
    private ResponseEntity responseEntity;

    @Autowired
    public FavouriteNewsController(FavouriteNewsService favouriteNewsService) {
        this.favouriteNewsService = favouriteNewsService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Favourite News Service";
    }

    @PostMapping("/article")
    public ResponseEntity<?> createArticle(@RequestBody Article article) {
        try {
            boolean status = favouriteNewsService.createArticle(article);
            if (status) {
                responseEntity = new ResponseEntity(article, HttpStatus.CREATED);
            } else {
                responseEntity = new ResponseEntity("Article already exists", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Some Internal Error Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/article/{userId}/{articleId}")
    public ResponseEntity<?> deleteArticle(@PathVariable String userId, @PathVariable String articleId) {
        try {
            boolean status = favouriteNewsService.deleteArticle(userId, articleId);
            if (status) {
                responseEntity = new ResponseEntity(HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity("Article does not exist", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Some Internal Error Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/article/{userId}")
    public ResponseEntity<?> deleteAllArticles(@PathVariable String userId) {
        try {
            boolean status = favouriteNewsService.deleteAllArticles(userId);
            if (status) {
                responseEntity = new ResponseEntity("All articles deleted", HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity("User/Articles does not exist", HttpStatus.NOT_FOUND);
            }
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        } catch (ArticleNotFoundException e) {
            responseEntity = new ResponseEntity("Articles not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            responseEntity = new ResponseEntity("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/article/{userId}/{articleId}")
    public ResponseEntity<?> updateArticle(@PathVariable String userId, @PathVariable String articleId, @RequestBody Article article) {
        try {
            Article updatedArticle = favouriteNewsService.updateArticle(article, articleId, userId);
            responseEntity = new ResponseEntity(updatedArticle, HttpStatus.OK);

        } catch (ArticleNotFoundException e) {
            responseEntity = new ResponseEntity("Article does not exist", HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            responseEntity = new ResponseEntity("Some Internal Error Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/article/{userId}")
    public ResponseEntity<?> getAllArticles(@PathVariable String userId) {
        try {
            List<Article> list = favouriteNewsService.getAllArticleByUserId(userId);
            responseEntity = new ResponseEntity(list, HttpStatus.OK);

        } catch (Exception e) {
            responseEntity = new ResponseEntity("Some Internal Error Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }



    @GetMapping("/article/{userId}/{articleId}")
    public ResponseEntity<?> getNoteById(@PathVariable String userId, @PathVariable String articleId) {
        try {
            Article article = favouriteNewsService.getArticleByArticleId(userId, articleId);
            responseEntity = new ResponseEntity(article, HttpStatus.OK);

        } catch (ArticleNotFoundException e) {
            responseEntity = new ResponseEntity("Article does not exist", HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            responseEntity = new ResponseEntity("Some Internal Error Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
