package by.runets.voting.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "question")
    List<Answer> answers;

    @OneToMany(mappedBy = "questions")
    private Voting voting;
}
