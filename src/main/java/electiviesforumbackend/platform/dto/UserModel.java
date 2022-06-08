package electiviesforumbackend.platform.dto;

import electiviesforumbackend.platform.entity.Institute;
import electiviesforumbackend.platform.entity.User;
import lombok.Data;

@Data
public class UserModel {

    private String email;

    private String login;

    private String password;

    private Long instituteId;

    public User toUser(UserModel userModel, Institute institute){
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setInstitute(institute);
        return user;
    }
}
