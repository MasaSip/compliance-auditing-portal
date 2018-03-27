package na.org.ecb.complianceauditingportal.repositorys;

import na.org.ecb.complianceauditingportal.database.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    User save(User user);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(User user);

    User findByUsername(
            @Param("username") String username
    );

}
