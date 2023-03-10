package vttp2022.csf.assessment.server.repositories;

import java.util.List;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;

@Repository
public class RestaurantRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	// TODO Task 2
	// Use this method to retrive a list of cuisines from the restaurant collection
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	
	// db.restaurants.find( {cuisines: "American"})
	public List<Restaurant> getCuisines() {
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "cuisines"));
		return mongoTemplate.find(query, Document.class, "restaurants")
					.stream()
					.map(d -> Restaurant.create(d))
					.toList();

	}

	// TODO Task 3
	// Use this method to retrive a all restaurants for a particular cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method

	// db.restaurants.find( {restaurantsbycuisines: "American"}).sort( {name : 1})
	public List<Restaurant> getRestaurantsByCuisine() {
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "name"));
		return mongoTemplate.find(query, Document.class, "restaurants")
					.stream()
					.map(d -> Restaurant.create(d))
					.toList();

	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method

	// db.restaurants.find( {name: "Ajisen Ramen"})
	public List<Restaurant> getRestaurant() {
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "name"));
		return mongoTemplate.find(query, Document.class, "names")
					.stream()
					.map(d -> Restaurant.create(d))
					.toList();

	}
		

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//  
	public void addComment(Comment comment) {
		// Implmementation in here
		
	}
	
	// You may add other methods to this class

}
