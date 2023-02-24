package vttp2022.csf.assessment.server.models;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

// Do not modify this class
public class Restaurant {
	
	private String restaurantId;
	private String name;
	private String cuisine;
	private String address;
	private LatLng coordinates;
	private String mapUrl;

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantId() {
		return this.restaurantId;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getCuisine() {
		return this.cuisine;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}

	public void setCoordinates(LatLng coordinates) {
		this.coordinates = coordinates;
	}
	public LatLng getCoordinates() {
		return this.coordinates;
	}

	public void setMapURL(String mapUrl) {
		this.mapUrl = mapUrl;
	}
	public String getMapURL() {
		return this.mapUrl;
	}

	@Override
    public String toString() {
        return "restaurant [rid= "
                .concat("" + this.restaurantId)
                .concat(", name=")
                .concat(this.name)
                .concat(", cuisine=".replaceAll("/", "_"))
                .concat("" + this.cuisine)
                .concat(", address=")
                .concat("" + this.address)
                .concat(", coordinates=")
                .concat("" + this.getCoordinates())
                .concat(", mapUrl=")
                .concat(this.mapUrl);
    }

    public static Restaurant create(Document d) {
        Restaurant r = new Restaurant();
        r.setRestaurantId(d.getString("rid"));
        r.setCuisine(d.getString("name"));
		r.setAddress(d.getString("address"));
		//r.setCoordinates(d.latLang("coordinates"));
		r.setMapURL(d.getString("mapUrl"));
        return r;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("rid", getRestaurantId())
                .add("name", getName())	
                .add("cuisine", getCuisine())
                .add("address", getAddress())
				.add("mapUrl", getMapURL())
				// .add("coordinates"), getCoordinates())
                .build();
    }
}
