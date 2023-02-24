import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { environment } from '../environments/environment';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent {
	
	// TODO Task 4 and Task 5
	// For View 3

  name: string = "";
  cuisine: string = "";
  address: string = "";
  mapUrl=environment.map_url;
  comment: string = "";
  params$! : Subscription;

  constructor(private rstSvc: RestaurantService, 
      private activatedRoute: ActivatedRoute, private router: Router){

  }

  ngOnInit(): void {
    console.log("ngOnInit ...");
    this.params$ = this.activatedRoute.params.subscribe(
      (params)=>{
        console.log("param val : " + params['city']);
        this.mapUrl = params['mapUrl'];
    });
    console.log(this.name);
    this.getImgFromAPI(this.name);
  }

  ngDestroy(): void{
    console.log("destroy subscription observable !");
    this.params$.unsubscribe();
  }

  getImgFromAPI(city: string){
    this.rstSvc.getRestaurant()
      .then((result)=>{
        
        
    }).catch((err)=>{
      console.log(err);
    })
  }
}



