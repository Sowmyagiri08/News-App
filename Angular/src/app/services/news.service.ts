import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Article } from '../article';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  articles: Array<Article> = [];
  subject: BehaviorSubject<Array<Article>>;
  favourites = [];
  favouritesSubject: BehaviorSubject<any>;

  constructor(public httpClient: HttpClient, public authService: AuthenticationService) {
    this.subject = new BehaviorSubject(this.articles);
    this.favouritesSubject = new BehaviorSubject(this.favourites);
  }

  fetchAllNews(): any {
    this.httpClient.get<Article[]>(`https://newsapi.org/v2/top-headlines?country=us&apiKey=1e936053fccd414a8493b0c167e8d17f`)
      .subscribe((data) => {
        this.articles = data;
        this.subject.next(this.articles);
      });
  }

  getNews(): BehaviorSubject<Array<Article>> {
    return this.subject;
  }

  addToFavourites(article, userId): Observable<Article> {
    article.articleAddedBy = userId
    return this.httpClient.post<Article>('http://localhost:8765/favourite-service/api/v1/article',article,{
      headers: new HttpHeaders().set('Authorization', `Bearer ${this.authService.getBearerToken()}`)})
      .pipe(tap(newArticle => {
        this.favourites.push(newArticle);
        this.favouritesSubject.next(this.favourites);
      }));
  }

  fetchAllFavourites(): any {
    let userId = this.authService.getUserId();
    this.httpClient.get<any>(`http://localhost:8765/favourite-service/api/v1/article/${userId}`,{
      headers: new HttpHeaders().set('Authorization', `Bearer ${this.authService.getBearerToken()}`)})
      .subscribe((data) => {
        this.favourites = data;
        this.favouritesSubject.next(this.favourites);
      });
  }

  getAllFavourites(): BehaviorSubject<any> {
    return this.favouritesSubject;
  }

  deleteFavourite(id): any {
    let userId = this.authService.getUserId()
    return this.httpClient.delete(`http://localhost:8765/favourite-service/api/v1/article/${userId}/${id}`,{
      headers: new HttpHeaders().set('Authorization', `Bearer ${this.authService.getBearerToken()}`)});

  }
}
