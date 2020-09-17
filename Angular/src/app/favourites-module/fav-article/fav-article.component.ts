import { Component, OnInit, Input } from '@angular/core';
import { Article } from 'src/app/article';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-fav-article',
  templateUrl: './fav-article.component.html',
  styleUrls: ['./fav-article.component.css']
})
export class FavArticleComponent implements OnInit {

  public message: string;
  public success: boolean;
  public favouritesList: any;

  constructor(public newsService: NewsService, public authService: AuthenticationService) { }

  @Input()
  public article: Article;


  ngOnInit() {
  }

  addToFavourites(article) {
    const userId = this.authService.getUserId();
    article.source = "News API";
    console.log(article.title);
    this.newsService.getAllFavourites().subscribe(data => {
      this.favouritesList = data;
      console.log(this.favouritesList);
      if(data==null){
        this.favouritesList=[]
      }
      let a = this.favouritesList.find(p => p['title'] == article.title);
      if (a === undefined) {
        this.newsService.addToFavourites(article, userId).subscribe(data => {
          this.message = 'Successfully added to Favourites!';
          this.success = true;
        },
          error => {
            this.message = 'Error occurred while adding to favourites';
            this.success = false;
          });
      } else {
        this.message='Already added to favourites!'
        this.success=false;
      }

    });


  }


}
