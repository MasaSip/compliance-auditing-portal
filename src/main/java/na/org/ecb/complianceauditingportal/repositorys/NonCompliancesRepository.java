package na.org.ecb.complianceauditingportal.repositorys;

import na.org.ecb.complianceauditingportal.database.NonCompliance;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "nonCompliances", path = "nonCompliances")
public interface NonCompliancesRepository extends PagingAndSortingRepository<NonCompliance, Long> {

}