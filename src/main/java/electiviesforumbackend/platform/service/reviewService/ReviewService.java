package electiviesforumbackend.platform.service.reviewService;

import electiviesforumbackend.platform.dto.ReviewModel;
import electiviesforumbackend.platform.entity.Elective;
import electiviesforumbackend.platform.entity.Review;

import java.util.List;

public interface ReviewService {
    void saveReview(ReviewModel review);
}


