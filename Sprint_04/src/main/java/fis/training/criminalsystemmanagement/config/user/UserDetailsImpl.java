package fis.training.criminalsystemmanagement.config.user;

import fis.training.criminalsystemmanagement.model.Detective;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String username;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(Detective detective) {
        List<GrantedAuthority> authorities =
                Collections.singletonList(new SimpleGrantedAuthority(detective.getRank().name()));
        // lay ra danh sach role cua detective
        return new UserDetailsImpl(detective.getId(), detective.getUsername(), detective.getPassword(), authorities);
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.username;
    }

    @Override
    public String getUsername() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
