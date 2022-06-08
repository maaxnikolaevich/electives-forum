package electiviesforumbackend.platform.security.jwt;

import electiviesforumbackend.platform.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
//                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())),
                user.getUpdated()
        );
    }

//    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
//        return userRoles.stream()
//                .map(role ->
//                        new SimpleGrantedAuthority(role.getName())
//                ).collect(Collectors.toList());
//    }
}
