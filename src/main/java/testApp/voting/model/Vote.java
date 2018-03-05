package testApp.voting.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Vote {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "dateTimeVote")
    private Date dateTimeVote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTimeVote() {
        return dateTimeVote;
    }

    public void setDateTimeVote(Date dateTimeVote) {
        this.dateTimeVote = dateTimeVote;
    }

}
