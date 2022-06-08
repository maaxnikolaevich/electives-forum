package electiviesforumbackend.platform.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;


public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String password;
    private final String email;
//    private final boolean enabled;
    private final Date lastPasswordResetDate;
//    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(
            Long id,
            String username,
            String email,
            String password,
            Date lastPasswordResetDate
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
