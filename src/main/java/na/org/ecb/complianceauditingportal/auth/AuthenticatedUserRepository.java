package na.org.ecb.complianceauditingportal.auth;

import na.org.ecb.complianceauditingportal.database.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * This only exist because {link UserRepository} has spring security enabled.
 *
 * should be removed in the future if there is a better solution.
 */
public interface AuthenticatedUserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(
            @Param("username") String username
    );
}
