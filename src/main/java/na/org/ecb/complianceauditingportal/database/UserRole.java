package na.org.ecb.complianceauditingportal.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_groups")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usergroup_id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "usergroup")
    private String role;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }

    protected UserRole(){}

}
