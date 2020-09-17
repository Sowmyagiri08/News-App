import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Article } from '../article';
import { NewsService } from '../services/news.service';


@Component({
  selector: 'app-trending-view',
  templateUrl: './trending-view.component.html',
  styleUrls: ['./trending-view.component.css']
})
export class TrendingViewComponent implements OnInit {

  public topTen: Array<Article>;
  constructor(public newsService: NewsService) {

  }

  ngOnInit() {
    this.newsService.fetchAllNews();
    this.newsService.getNews().subscribe(data => {
      this.topTen = data['articles'];
    });
  }

}
