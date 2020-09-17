import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Article } from 'src/app/article';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-view-favourites',
  templateUrl: './view-favourites.component.html',
  styleUrls: ['./view-favourites.component.css']
})
export class ViewFavouritesComponent implements OnInit {

  public favouritesList: any;
  public user: string;

  constructor(public newsService: NewsService, public authService: AuthenticationService) { }

  ngOnInit() {
    this.user = this.authService.getUserId();
    this.newsService.fetchAllFavourites();
    this.newsService.getAllFavourites().subscribe(data => {
      this.favouritesList = data;
      console.log(this.favouritesList);
      if (data == null)
        this.favouritesList = [];
    });
  }

  delete(id) {
    this.newsService.deleteFavourite(id).subscribe(data => {
      console.log(data);
      this.newsService.fetchAllFavourites();
      this.newsService.getAllFavourites().subscribe(data => {
        this.favouritesList = data;
        if (data == null)
        this.favouritesList = []
      });

    });

  }

}
