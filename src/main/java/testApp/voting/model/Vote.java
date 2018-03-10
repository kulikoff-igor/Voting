package testApp.voting.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vote")
public class Vote {

    public Vote() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "dateTimeVote")
    private String dateTimeVote;

    public Vote(String dateTimeVote) {
        this.dateTimeVote = dateTimeVote;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateTimeVote() {
        return dateTimeVote;
    }

    public void setDateTimeVote(String dateTimeVote) {
        this.dateTimeVote = dateTimeVote;
    }

}
