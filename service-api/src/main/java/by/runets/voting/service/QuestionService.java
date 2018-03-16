package by.runets.voting.service;

import by.runets.voting.dto.QuestionDTO;
import by.runets.voting.exception.ResourceNotFoundException;

public interface QuestionService extends AbstractService<QuestionDTO, Integer> {
    QuestionDTO disable(int id) throws ResourceNotFoundException;
}
