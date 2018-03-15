package by.runets.voting.service.impl;

import by.runets.voting.dto.QuestionDTO;
import by.runets.voting.exception.ResourceNotFoundException;
import by.runets.voting.model.Question;
import by.runets.voting.repository.QuestionRepository;
import by.runets.voting.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    @Override
    public QuestionDTO find(Integer id) {
        return null;
    }

    @Override
    public List<QuestionDTO> findAll() {
        return null;
    }

    @Override
    @Transactional
    public void save(QuestionDTO entity) {
        Question question = modelMapper.map(entity, Question.class);
        questionRepository.save(question);
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        Optional<Question> question = questionRepository.findById(id);

        if (question.isPresent()){
            questionRepository.delete(question.get());
        } else {
            throw new ResourceNotFoundException("Question bu id does not exist: " + id);
        }
    }
}
