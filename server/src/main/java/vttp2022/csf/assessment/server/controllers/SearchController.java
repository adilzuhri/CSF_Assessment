package vttp2022.csf.assessment.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.services.RestaurantService;

@RestController
@RequestMapping(path = "/api/rst")
public class SearchController {

    @Autowired
    private RestaurantService rstSvc;

    @GetMapping(path = "/games")
    public ResponseEntity<String> getAllGame(
            @RequestParam Integer limit, @RequestParam Integer offset) {
        List<Restaurant> results = rstSvc.getRestaurant();
        System.out.println("size > " + results.size());
        return null;

    }

    @GetMapping(path = "/comment")
    public ResponseEntity<String> searchComment(
            @RequestParam String q, @RequestParam Float score) {

        System.out.printf("q=%s, score=%f\n", q, score);
        List<Comment> results = rstSvc.searchComment(q, score, 20, 0);
        JsonArray result = null;
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (Comment g : results)
            arrBuilder.add(g.toJSON());
        result = arrBuilder.build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
    }
}
