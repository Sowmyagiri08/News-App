import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddFavouritesComponent } from './add-favourites/add-favourites.component';
import { FavArticleComponent } from './fav-article/fav-article.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSidenavModule, MatListModule, MatIconModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';


import { LayoutModule } from '@angular/cdk/layout';

import { MatChipsModule } from '@angular/material/chips';
import { ViewFavouritesComponent } from './view-favourites/view-favourites.component';





@NgModule({
  declarations: [
    AddFavouritesComponent,
    FavArticleComponent,
    FavouritesComponent,
    ViewFavouritesComponent

  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    HttpClientModule,
    MatCardModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatExpansionModule,
    MatInputModule,
    MatChipsModule,
    RouterModule

  ],
  exports: [
    AddFavouritesComponent,
    FavArticleComponent,
    FavouritesComponent
  ]
})
export class FavouritesModuleModule { }
