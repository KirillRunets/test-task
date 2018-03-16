package by.runets.voting.service.impl;

import by.runets.voting.dto.QuestionDTO;
import by.runets.voting.exception.ResourceNotFoundException;
import by.runets.voting.model.Question;
import by.runets.voting.repository.QuestionRepository;
import by.runets.voting.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    @Override
    public QuestionDTO find(Integer id) throws ResourceNotFoundException {
        Optional<Question> question = questionRepository.findById(id);

        if (!question.isPresent()) {
            throw new ResourceNotFoundException("Cannot find question by id: " + id);
        }

        return modelMapper.map(question.get(), QuestionDTO.class);
    }

    @Override
    public List<QuestionDTO> findAll() {
        List<Question> questions = questionRepository.findAll();

        Type listType = new TypeToken<List<QuestionDTO>>() {
        }.getType();


        return modelMapper.map(questions, listType);
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

        if (!question.isPresent()){
            throw new ResourceNotFoundException("Cannot delete question by id: " + id);
        }

        questionRepository.delete(question.get());

    }

    @Override
    public QuestionDTO disable(int id) throws ResourceNotFoundException {
        Optional<Question> optional = questionRepository.findById(id);

        if (!optional.isPresent()){
            throw new ResourceNotFoundException("Cannot find question by id: " + id);
        }

        optional.get().setEnabled(false);
        questionRepository.save(optional.get());

        return modelMapper.map(optional.get(), QuestionDTO.class);
    }
}
