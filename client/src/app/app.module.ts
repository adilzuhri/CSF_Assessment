import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { CuisineListComponent } from './components/cuisine-list.component';
import { RestaurantCuisineComponent } from './components/restaurant-cuisine.component';
import { RestaurantDetailsComponent } from './components/restaurant-details.component';

@NgModule({
  declarations: [
    AppComponent,
    CuisineListComponent,
    RestaurantCuisineComponent,
    RestaurantDetailsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
