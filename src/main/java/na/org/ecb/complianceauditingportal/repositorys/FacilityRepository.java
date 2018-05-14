package na.org.ecb.complianceauditingportal.repositorys;

import na.org.ecb.complianceauditingportal.database.Facility;
import na.org.ecb.complianceauditingportal.database.NonCompliance;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "facilities", path = "facilities")
public interface FacilityRepository extends PagingAndSortingRepository<Facility, Long> {

}