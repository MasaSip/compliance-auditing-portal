package na.org.ecb.complianceauditingportal.database;

import na.org.ecb.complianceauditingportal.database.User;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedded", types = User.class)
public interface UserProjection {
    Long getId();

    String getUsername();
    String getFirstName();
    String getLastName();

    List<UserRole> getRoles();
}
