package by.runets.voting.service;

import by.runets.voting.dto.AnswerDTO;
import by.runets.voting.exception.ResourceNotFoundException;

public interface AnswerService extends AbstractService<AnswerDTO, Integer> {
    Integer countVotes(int id) throws ResourceNotFoundException;
    AnswerDTO save(int answerId, int userId, int questionId) throws ResourceNotFoundException;
}
