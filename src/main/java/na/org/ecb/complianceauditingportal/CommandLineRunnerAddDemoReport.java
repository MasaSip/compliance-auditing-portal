package na.org.ecb.complianceauditingportal;

import na.org.ecb.complianceauditingportal.auth.AuthenticatedUserRepository;
import na.org.ecb.complianceauditingportal.database.Facility;
import na.org.ecb.complianceauditingportal.database.NonCompliance;
import na.org.ecb.complianceauditingportal.database.Report;
import na.org.ecb.complianceauditingportal.database.User;
import na.org.ecb.complianceauditingportal.repositorys.ReportsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Create some test reports
 *
 * Automatically run after app context is loaded and {@link CommandLineRunnerAddUsers} has completed
 */
@Component
@Order(2) //has to run after users have created
public class CommandLineRunnerAddDemoReport implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerAddUsers.class);

    @Autowired
    private AuthenticatedUserRepository userRepository;

    @Autowired
    private ReportsRepository reportsRepository;

    @Override
    public void run(String...args) throws Exception {

        //The following allows this methode to call "ROLE_USER" protected functions.
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                "User",
                null,
                authorities
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepository.findByUsername("User");

        Report report = reportsRepository.findByName("Test Report 1");
        if(report == null) {
            report = new Report();
            report.setUser(user);
            report.setName("Test Report 1");

            Facility facility = new Facility(report,"Facility 1", "Description for Facility 1");

//            report.getFacilities().add(
//                    new Facility("Facility 1", "description for facility"
//            )
            facility.getNonCompliances().add(
                    new NonCompliance(facility, "what is the Problem?")
            );

            report.getFacilities().add(facility);

            reportsRepository.save(report);
        }

        // Drop all privileges
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
