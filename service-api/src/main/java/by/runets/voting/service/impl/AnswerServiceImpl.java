package by.runets.voting.service.impl;


import by.runets.voting.dto.AnswerDTO;
import by.runets.voting.dto.QuestionDTO;
import by.runets.voting.exception.ResourceNotFoundException;
import by.runets.voting.model.Answer;
import by.runets.voting.repository.AnswerRepository;
import by.runets.voting.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService{

    private final AnswerRepository answerRepository;
    private final ModelMapper modelMapper;

    @Override
    public AnswerDTO find(Integer id) throws ResourceNotFoundException {
        Optional<Answer> answerOptional = answerRepository.findById(id);
        if (!answerOptional.isPresent()){
            throw new ResourceNotFoundException("Cannot find answer by id: " + id);
        }

        return modelMapper.map(answerOptional.get(), AnswerDTO.class);
    }

    @Override
    public List<AnswerDTO> findAll() {
        List<Answer> answers = answerRepository.findAll();

        Type listType = new TypeToken<List<QuestionDTO>>() {
        }.getType();

        return modelMapper.map(answers, listType);
    }

    @Override
    public void save(AnswerDTO entity) {
        Answer answer = modelMapper.map(entity, Answer.class);
        answerRepository.save(answer);
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        Optional<Answer> answer = answerRepository.findById(id);

        if (!answer.isPresent()){
            throw new ResourceNotFoundException("Cannot delete answer by id: " + id);
        }

        answerRepository.delete(answer.get());
    }

    @Override
    public Integer countVotes(AnswerDTO answerDTO) {
        return answerDTO.getUsers().size();
    }
}
