package na.org.ecb.complianceauditingportal.auth;


import na.org.ecb.complianceauditingportal.database.User;
import na.org.ecb.complianceauditingportal.database.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Authenticated User from the database.
 *
 * This decouples the database user from the spring user.
 */
public class AuthenticatedUser extends User implements UserDetails {
    private Collection<? extends GrantedAuthority> authorities;
    protected AuthenticatedUser(User user) {
        super(user.getUsername(), user.getPassword());
        {
            List<UserRole> roles = user.getRoles();
            List<GrantedAuthority> authorities = new ArrayList<>();

            for (UserRole role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            }

            this.authorities = authorities;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return AuthorityUtils.createAuthorityList("ROLE_USER");
        return authorities;
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