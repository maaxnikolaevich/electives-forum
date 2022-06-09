package electiviesforumbackend.platform.service.reviewService;

import electiviesforumbackend.platform.dto.ReviewModel;
import electiviesforumbackend.platform.entity.Elective;
import electiviesforumbackend.platform.entity.Review;
import electiviesforumbackend.platform.entity.User;
import electiviesforumbackend.platform.repository.ElectiveRepository;
import electiviesforumbackend.platform.repository.reviewRepository.ReviewRepository;
import electiviesforumbackend.platform.repository.userRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ElectiveRepository electiveRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    public void saveReview(ReviewModel review) {
        Elective currentElective = electiveRepository.getById(review.getElective_id());
        User currentUser = userRepository.getById(review.getUser_id());
        Review reviewDao = new Review();
        reviewDao.setUser(currentUser);
        reviewDao.setElective(currentElective);
        reviewDao.setTitle(review.getTitle());
        reviewRepository.saveReview(reviewDao);
    }
}
