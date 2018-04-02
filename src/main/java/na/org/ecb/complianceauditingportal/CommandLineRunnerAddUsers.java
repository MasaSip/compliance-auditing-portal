package na.org.ecb.complianceauditingportal;

import na.org.ecb.complianceauditingportal.auth.AuthenticatedUserRepository;
import na.org.ecb.complianceauditingportal.database.User;
import na.org.ecb.complianceauditingportal.database.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * Pre-load some test users
 *
 * Automatically run after app context is loaded.
 */
@Component
@Order(1) //has to run at first
public class CommandLineRunnerAddUsers implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerAddUsers.class);

    @Autowired
    private AuthenticatedUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String...args) throws Exception {
        User user = userRepository.findByUsername("User");
        if(user == null) {
            user = new User("User",passwordEncoder.encode("password"));
            // authorization: Basic VXNlcjpwYXNzd29yZA==
            user.setEmail("user@example.com");
            user.setFirstName("us");
            user.setLastName("er");
            user.getRoles().add(new UserRole(user, "ROLE_USER"));
            userRepository.save(user);
        }

        User adminUser = userRepository.findByUsername("Admin");
        if(adminUser == null) {
            adminUser = new User("Admin",passwordEncoder.encode("password"));
            // authorization: Basic QWRtaW46cGFzc3dvcmQ=
            adminUser.setEmail("admin@example.com");
            adminUser.setFirstName("ad");
            adminUser.setLastName("min");
            adminUser.getRoles().add(new UserRole(adminUser, "ROLE_USER"));
            adminUser.getRoles().add(new UserRole(adminUser, "ROLE_ADMIN"));
            userRepository.save(adminUser);
        }
    }
}
