import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TrendingViewComponent } from './trending-view/trending-view.component';
import { LoginComponent } from './login/login.component';
import { CanActivateFavouritesGuard } from './can-activate-favourites.guard';
import { FavouritesComponent } from './favourites-module/favourites/favourites.component';
import { AddFavouritesComponent } from './favourites-module/add-favourites/add-favourites.component';
import { ViewFavouritesComponent } from './favourites-module/view-favourites/view-favourites.component';


const routes: Routes = [
  {
    path: 'trending',
    component: TrendingViewComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'favourites',
    component: FavouritesComponent,
    canActivate: [CanActivateFavouritesGuard],
    children: [
      {
        path: 'addtofavourites',
        component: AddFavouritesComponent
      },
      {
        path: 'viewfavourites',
        component: ViewFavouritesComponent
      },
      {
        path: '',
        redirectTo: 'viewfavourites',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/trending',
    pathMatch: 'full'

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
