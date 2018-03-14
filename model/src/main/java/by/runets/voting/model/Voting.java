package by.runets.voting.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "voting")
@Data
public class Voting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "voting_time")
    private Instant votingTime;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="u_id")
    private List<User> users;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="q_id")
    private List<Question> questions;
}
