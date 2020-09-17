import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl } from '@angular/forms';
import { Article } from 'src/app/article';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-add-favourites',
  templateUrl: './add-favourites.component.html',
  styleUrls: ['./add-favourites.component.css']
})
export class AddFavouritesComponent implements OnInit {
  public searchForm: FormGroup;
  public searchResults: Array<Article>;
  public allResults: Array<Article>;


  constructor(public newsService: NewsService) { }

  ngOnInit() {
    this.searchForm = new FormGroup({
      keyword: new FormControl(),
    });
    this.newsService.fetchAllNews();
  }

  searchSubmit() {
    this.newsService.getNews().subscribe(data => {
      this.allResults = data['articles'];
      this.searchResults = this.allResults.filter(a => a.title.includes(this.searchForm.value.keyword));

    });
  }
}
