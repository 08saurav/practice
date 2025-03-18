package RatingSystem.repositories;

import RatingSystem.models.Rating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRepository {
    Map<String, List<Rating>> ratings;
    Map<String,Integer> count;
    Map<String,Integer> totalScore;
    public RatingRepository() {
        ratings = new HashMap<>();
        count = new HashMap<>();
        totalScore = new HashMap<>();
    }
    public void addRating(Rating rating) {
        String itemId = rating.getItemId();
        ratings.computeIfAbsent(itemId,k -> new ArrayList<>()).add(rating);
        count.put(itemId,count.getOrDefault(itemId,0) + 1);
        totalScore.put(itemId,totalScore.getOrDefault(itemId,0) + rating.getScore());
    }
    public List<Rating> getRatingsByItemId(String itemId) {
        return ratings.getOrDefault(itemId,new ArrayList<>());
    }
    public double getAverageRatingByItemId(String itemId) {
        int score = totalScore.getOrDefault(itemId,0);
        int ct = count.getOrDefault(itemId,0);
        return ct == 0 ? 0.0 : (double)score/(double)ct;
    }
}
