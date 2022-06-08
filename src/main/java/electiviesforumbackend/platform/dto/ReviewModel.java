package electiviesforumbackend.platform.dto;

import lombok.Data;

@Data
public class ReviewModel {
    private String title;
    private Long elective_id;
    private Long user_id;
}
