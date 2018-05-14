package na.org.ecb.complianceauditingportal.database;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facility")
@ToString
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;

    //private Long questionId; // @todo add here link to question in database

    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "facility"
    )
    private List<NonCompliance> nonCompliances = new ArrayList<>();

    protected Facility()
    {

    }

    public Facility(Report report, String name, String description) {
        this.setReport(report);
        this.setName(name);
        this.setDescription(description);
    }
}
