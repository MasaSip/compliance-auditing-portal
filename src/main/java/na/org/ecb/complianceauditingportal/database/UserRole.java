package na.org.ecb.complianceauditingportal.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue()
    private Long id;

    @Getter
    @Setter
    private String role;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne(optional = false)
    private User user;

    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }

    protected UserRole(){}

}
