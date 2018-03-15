package by.runets.voting.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private AnswerDTO answer;
}
