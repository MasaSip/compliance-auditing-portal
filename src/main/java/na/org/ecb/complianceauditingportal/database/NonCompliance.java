package na.org.ecb.complianceauditingportal.database;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;

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

    public NonCompliance(Report report, String comment)
    {
        this.report = report;
        this.comment = comment;
    }
}
