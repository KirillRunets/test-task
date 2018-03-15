package by.runets.voting.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnswerDTO {
    private int id;
    private String description;
    private QuestionDTO questionDTO;
    private List<UserDTO> users;
}
