package electiviesforumbackend.platform.service.reviewService;

import electiviesforumbackend.platform.dto.ReviewModel;
import electiviesforumbackend.platform.entity.Review;

public interface ReviewService {
    Boolean saveReview(ReviewModel review);
}


