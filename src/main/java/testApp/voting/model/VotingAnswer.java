package testApp.voting.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "votingAnswer")
public class VotingAnswer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "voteText")
    private String voteText;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Vote> vote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoteText() {
        return voteText;
    }

    public void setVoteText(String voteText) {
        this.voteText = voteText;
    }


}
