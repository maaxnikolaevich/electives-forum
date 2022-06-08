package electiviesforumbackend.platform.dto;

import lombok.Data;

@Data
public class AuthenticationRequestModel {
    private String login;
    private String password;
}
