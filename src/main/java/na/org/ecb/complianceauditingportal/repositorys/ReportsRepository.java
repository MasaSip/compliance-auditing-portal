package na.org.ecb.complianceauditingportal.repositorys;

import na.org.ecb.complianceauditingportal.database.Report;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "reports", path = "reports")
public interface ReportsRepository extends PagingAndSortingRepository<Report, Long> {

}