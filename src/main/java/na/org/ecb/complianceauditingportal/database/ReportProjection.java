package na.org.ecb.complianceauditingportal.database;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedded", types = Report.class)
public interface ReportProjection {
    Long getId();

    String getName();

    UserProjection getUser();

    List<NonComplianceProjection> getNonCompliances();
}