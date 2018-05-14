package na.org.ecb.complianceauditingportal.database;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedded", types = NonCompliance.class)
public interface NonComplianceProjection {
    Long getId();

    String getComment();
}