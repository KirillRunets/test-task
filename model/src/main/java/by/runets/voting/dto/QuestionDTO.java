package by.runets.voting.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {
    private int id;
    private String description;
    private boolean enabled;
    private List<AnswerDTO> answers;
}
