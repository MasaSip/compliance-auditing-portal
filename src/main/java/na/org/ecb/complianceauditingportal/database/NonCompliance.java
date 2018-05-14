package na.org.ecb.complianceauditingportal.database;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import na.org.ecb.complianceauditingportal.json.LocalDateTimeSerializer;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "compliance")
@ToString
public class NonCompliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private Long id;

//    @Getter
//    @Setter
//    @ManyToOne
//    @JoinColumn(name = "report_id")
//    private Report report;

    //private Long questionId; // @todo add here link to question in database

    @Getter
    @Setter
    @Column(name = "comment")
    private String comment;

//
//    @Setter
//    @Getter
//    private UUID media_link;

    protected NonCompliance()
    {

    }

    public NonCompliance(Facility facility, String comment)
    {
        this.facility = facility;
        this.comment = comment;
    }



    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "compliance_date")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private java.time.LocalDateTime compliance_date;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
}
