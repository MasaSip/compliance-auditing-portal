package na.org.ecb.complianceauditingportal.database;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedded", types = Facility.class)
public interface FacilityProjection {
    Long getId();

    String getDescription();

    String getName();

    List<NonComplianceProjection> getNonCompliances();
}