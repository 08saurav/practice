package RatingSystem.services;

import RatingSystem.models.Rating;
import RatingSystem.repositories.RatingRepository;

import java.util.List;

public class RatingService {
    RatingRepository ratingRepository;
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    public void addRating(String item,int score) {
        if (score < 1 || score > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        ratingRepository.addRating(new Rating(item,score));
    }
    public Double getAvgRating(String itemId) {
        return ratingRepository.getAverageRatingByItemId(itemId);
    }
    public List<Rating> getRatingByItemId(String itemId) {
        return ratingRepository.getRatingsByItemId(itemId);
    }
}
