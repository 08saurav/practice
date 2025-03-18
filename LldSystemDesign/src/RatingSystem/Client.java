package RatingSystem;

import RatingSystem.models.Rating;
import RatingSystem.repositories.RatingRepository;
import RatingSystem.services.RatingService;

public class Client {
    public static void main(String[] args) {
        RatingRepository ratingRepository = new RatingRepository();
        RatingService ratingService = new RatingService(ratingRepository);
        // Adding ratings
        ratingService.addRating("item1", 5);
        ratingService.addRating("item1", 4);
        ratingService.addRating("item1", 3);
        ratingService.addRating("item2", 2);
        ratingService.addRating("item2", 5);

        // Get average rating
        System.out.println("Average Rating for item1: " + ratingService.getAvgRating("item1"));
        System.out.println("Average Rating for item2: " + ratingService.getAvgRating("item2"));

        // Get all ratings
        System.out.println("All Ratings for item1: " + ratingService.getRatingByItemId("item1").size());
        System.out.println("All Ratings for item2: " + ratingService.getRatingByItemId("item2").size());
    }
}
