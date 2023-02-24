import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Restaurant, Comment } from './models';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
	providedIn: 'root'
})

export class RestaurantService {

	constructor(private httpSvc: HttpClient) { }
	BACKEND_API_URL = "http://localhost:8080/api/rst/restaurants-ng";
  
	// TODO Task 2 
	// Use the following method to get a list of cuisines
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public getCuisineList(limit: number, offset: number): Observable<Restaurant[]> {
		const params = new HttpParams()
		  .set("limit", limit)
		  .set("offset", offset);
	
		  const headers= new HttpHeaders()
		  .set('content-type', 'application/json')
		  .set('Access-Control-Allow-Origin', '*');
	
		return this.httpSvc
			.get<Restaurant[]>(this.BACKEND_API_URL, { params: params, headers: headers });
	  }
	}

	// TODO Task 3 
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public getRestaurantsByCuisine(???) {
		// Implememntation in here

	}
	
	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	public getRestaurant(???): Promise<Restaurant> {
		// Implememntation in here

	}

	// TODO Task 5
	// Use this method to submit a comment
	// DO NOT CHANGE THE METHOD'S NAME OR SIGNATURE
	public postComment(comment: Comment): Promise<any> {
		// Implememntation in here

	}
}
