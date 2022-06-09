package electiviesforumbackend.platform.service.reviewService;

import electiviesforumbackend.platform.dto.ReviewModel;
import electiviesforumbackend.platform.entity.Review;

public interface ReviewService {
    void saveReview(ReviewModel review);
}


