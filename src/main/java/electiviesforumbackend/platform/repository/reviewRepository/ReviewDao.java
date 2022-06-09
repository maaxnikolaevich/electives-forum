package electiviesforumbackend.platform.repository.reviewRepository;
import electiviesforumbackend.platform.entity.Elective;
import electiviesforumbackend.platform.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface ReviewDao extends JpaRepository<Review, Long>, JpaSpecificationExecutor<Review> {}

