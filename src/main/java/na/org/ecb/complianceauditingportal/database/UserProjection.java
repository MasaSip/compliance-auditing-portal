package na.org.ecb.complianceauditingportal.database;

import na.org.ecb.complianceauditingportal.database.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedded", types = User.class)
public interface UserProjection {
    Long getId();

    String getUsername();
}
