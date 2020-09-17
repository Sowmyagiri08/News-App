import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(public router: Router, public location: Location) { }

  routeToFavourites() {
    this.router.navigate(['/favourites']);
  }

  routeToLogin() {
    this.router.navigate(['/login']);
  }


  routeBack() {
    this.location.back();
  }


  routeToAddFavourites() {
    this.router.navigate(['favourites', 'addtofavourites']);
  }

  routeToViewFavourites() {
    this.router.navigate(['favourites', 'viewfavourites']);
  }
}
