import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Article } from 'src/app/article';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { RouterService } from 'src/app/services/router.service';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {



  constructor(public routerservice: RouterService) { }

  ngOnInit() {

  }

  toAdd() {
    this.routerservice.routeToAddFavourites();
  }


  toView() {
    this.routerservice.routeToViewFavourites();
  }


}
