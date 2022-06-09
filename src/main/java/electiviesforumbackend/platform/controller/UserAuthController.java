package electiviesforumbackend.platform.controller;

import electiviesforumbackend.platform.dto.AuthenticationRequestModel;
import electiviesforumbackend.platform.dto.UserModel;
import electiviesforumbackend.platform.entity.Institute;
import electiviesforumbackend.platform.entity.User;
import electiviesforumbackend.platform.exeptions.UserAlreadyExistAuthenticationException;
import electiviesforumbackend.platform.security.jwt.JwtTokenProvider;
import electiviesforumbackend.platform.service.instituteService.InstituteService;
import electiviesforumbackend.platform.service.userService.UserService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Data
@RestController
@RequestMapping(value = "/api/auth/")
public class UserAuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final InstituteService instituteService;

    @PostMapping("register")
    public ResponseEntity register(@RequestBody UserModel userModel) throws UserAlreadyExistAuthenticationException {

            Institute institute = instituteService.getInstituteById(userModel.getInstituteId());

            User user = userService.findByLogin(userModel.getLogin());

            if (user != null) {
                throw new UserAlreadyExistAuthenticationException(String.format("The user - %s already exists!", user.getLogin()));
            }
            User newUser = userModel.toUser(userModel, institute);
            userService.register(newUser);
            return ResponseEntity.ok(HttpStatus.OK);
        }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestModel requestDto) {
        try {
            String login = requestDto.getLogin();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, requestDto.getPassword()));
            User user = userService.findByLogin(login);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + login + " not found");
            }

            String token = jwtTokenProvider.createToken(login);

            Map<Object, Object> response = new HashMap<>();
            response.put("email", user.getEmail());
            response.put("username", login);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}