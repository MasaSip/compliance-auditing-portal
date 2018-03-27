package na.org.ecb.complianceauditingportal.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import na.org.ecb.complianceauditingportal.json.LocalDateTimeSerializer;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
public class Report {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    // private Long licenseeId // @todo table not jet implemented

    @Getter
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private final java.time.LocalDateTime startTime = LocalDateTime.now();

    private java.time.LocalDateTime endTime;

    @Getter
    @Setter
    private String name;  // @todo remove when usertable is available

    @Getter
    @Setter
    @ManyToOne(optional = false)
    private User user;

    @Getter
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "report"
    )
    private List<NonCompliance> nonCompliances = new ArrayList<>();

}
