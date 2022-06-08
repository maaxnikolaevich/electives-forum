package electiviesforumbackend.platform.repository.reviewRepository;

import electiviesforumbackend.platform.entity.Review;

public interface ReviewRepository {
    void saveReview(Review review);
}