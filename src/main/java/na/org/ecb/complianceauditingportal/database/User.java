package na.org.ecb.complianceauditingportal.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue()
    private long id;

    @Setter
    @Getter
    @NotEmpty(message = "username is required")
    @Column(unique = true)
    private String username;

    @Getter
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty(message = "password is required")
    private String password;


    @PreAuthorize("this.userName == authentication.name")
    public void setPassword(String password) {
        this.password = password;
    }

    protected User() {}

    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    @Setter
    @Getter
    @NotEmpty(message = "email is required")
    private String email;

    @Getter
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "user"
    )
    private List<UserRole> roles = new ArrayList<>();
}
