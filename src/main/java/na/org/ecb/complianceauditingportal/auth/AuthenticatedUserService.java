package na.org.ecb.complianceauditingportal.auth;

import na.org.ecb.complianceauditingportal.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Authentication service for database user management
 */
@Service
public class AuthenticatedUserService implements UserDetailsService {

    @Autowired
    private AuthenticatedUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user " + username + " does not exist");
        }
        return new AuthenticatedUser(user);
    }
}