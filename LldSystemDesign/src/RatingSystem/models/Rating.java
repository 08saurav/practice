package RatingSystem.models;

public class Rating {
    String itemId;
    int Score;
    public Rating(String itemId, int Score) {
        this.itemId = itemId;
        this.Score = Score;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
