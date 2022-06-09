package electiviesforumbackend.platform.repository.reviewRepository;

import electiviesforumbackend.platform.entity.Elective;
import electiviesforumbackend.platform.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewRepositoryIml implements ReviewRepository {
    private final ReviewDao reviewDao;

    @Override
    public void saveReview(Review review) {
        reviewDao.saveAndFlush(review);
    }

}
