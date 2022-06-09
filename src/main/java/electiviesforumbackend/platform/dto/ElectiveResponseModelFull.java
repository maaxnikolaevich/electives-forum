package electiviesforumbackend.platform.dto;

import electiviesforumbackend.platform.entity.*;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.*;

@Data
public class ElectiveResponseModelFull extends ElectiveResponseModel {

    private List<Map<Object, Object>> reviewsCommentators = new ArrayList<>();

    public void toElectiveResponseModelFull(Elective elective){
        List<Review> reviews = elective.getReviews();
        this.toElectiveResponseModel(elective);
        reviews.forEach(currentReview->{
            Map<Object, Object> reviewsCommentators = new HashMap<>();

            reviewsCommentators.put(currentReview.getTitle(), currentReview.getUser().getLogin());
            this.reviewsCommentators.add(reviewsCommentators);
        });
    }
}
