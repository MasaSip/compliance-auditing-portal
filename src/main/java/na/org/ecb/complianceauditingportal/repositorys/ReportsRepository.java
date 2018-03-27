package na.org.ecb.complianceauditingportal.repositorys;

import na.org.ecb.complianceauditingportal.database.Report;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource(
        collectionResourceRel = "reports",
        path = "reports"
)
public interface ReportsRepository extends PagingAndSortingRepository<Report, Long> {
    Report findByName(
            @Param("reportname") String name
    );

    @Override
    @PreAuthorize("hasRole('ROLE_USER') AND (#report.user.username == authentication.name)")
    Report save(Report report);

    @Override
    @PreAuthorize("hasRole('ROLE_USER') AND (#report.user.username == authentication.name)")
    /**
     * Only the user who owns the report should be able to delete it.
     */
    void delete(Report report);
}