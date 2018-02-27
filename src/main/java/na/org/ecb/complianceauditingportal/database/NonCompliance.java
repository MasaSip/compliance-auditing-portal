package na.org.ecb.complianceauditingportal.database;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@ToString
public class NonCompliance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    private Report report;

    //private Long questionId; // @todo add here link to question in database

    @Getter
    @Setter
    private String question;

    @Getter
    @Setter
    private String comment;

    @Setter
    @Getter
    private UUID media_link;

}
