import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { Restaurant } from '../models';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-cuisine',
  templateUrl: './restaurant-cuisine.component.html',
  styleUrls: ['./restaurant-cuisine.component.css']
})	

// TODO Task 3
// For View 2

export class RestaurantCuisineComponent implements OnInit{
  @Input() pagePerRec = 0;
  restaurant !: Restaurant[];
  currentIndex: number = 0;
  pageNo: number = 1;
  
  constructor(private restSvc: RestaurantService) {}
 
  ngOnChanges(changes: SimpleChanges) {
    console.log(changes);
    console.log(changes['pagePerRec'].currentValue);
    if(changes['pagePerRec'].currentValue == null)
      this.pagePerRec = 10;
    else
      this.pagePerRec = changes['pagePerRec'].currentValue;

    this.restSvc.getRestaurantsByCuisine (this.pagePerRec, this.currentIndex).subscribe((resp)=> {
      console.log(resp);
      this.restaurant = resp;
    })
  }

  nextPage(){
    this.pageNo++;
    this.currentIndex = this.currentIndex + this.pagePerRec;
    this.restSvc.getRestaurantsByCuisine(this.pagePerRec, this.currentIndex).subscribe((resp)=> {
      console.log(resp);
      this.restaurant = resp;
    })
  }

  previousPage(){
    this.pageNo--;
    this.currentIndex = this.currentIndex - this.pagePerRec;
    this.restSvc.getRestaurantsByCuisine(this.pagePerRec, this.currentIndex).subscribe((resp)=> {
      console.log(resp);
      this.restaurant = resp;
    })
  }

  ngOnInit(): void {
      console.log("pagePerRec> " + this.pagePerRec);
      if(this.pagePerRec ==null)
        this.pagePerRec = 10;
      console.log(this.pagePerRec)
      this.restSvc.getRestaurantsByCuisine(this.pagePerRec, this.currentIndex).subscribe((resp)=> {
        console.log(resp);
        this.restaurant = resp;
      })
  }
}
