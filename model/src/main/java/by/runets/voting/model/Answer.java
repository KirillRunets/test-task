package by.runets.voting.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "body")
    private String body;

    @Column(name = "voting_amount")
    private int votingAmount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="q_id")
    private Question question;
}
