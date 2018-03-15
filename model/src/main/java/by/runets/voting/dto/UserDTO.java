package by.runets.voting.dto;

import by.runets.voting.model.Gender;
import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private AnswerDTO answer;
    private String gender;
}
