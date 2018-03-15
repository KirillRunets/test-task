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
    @Column(name = "q_id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "question")
    List<Answer> answers;
}
