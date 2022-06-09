package electiviesforumbackend.platform.repository.reviewRepository;

import electiviesforumbackend.platform.entity.Elective;
import electiviesforumbackend.platform.entity.Review;

import java.util.List;

public interface ReviewRepository {
    void saveReview(Review review);
}