package by.runets.voting.controller;

import by.runets.voting.dto.AnswerDTO;
import by.runets.voting.dto.QuestionDTO;
import by.runets.voting.exception.ResourceNotFoundException;
import by.runets.voting.service.AnswerService;
import by.runets.voting.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class QuestionController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @RequestMapping(value = "/question/create", method = RequestMethod.POST)
    public ResponseEntity<QuestionDTO> create(@RequestBody @Valid final QuestionDTO questionDTO){
        questionService.save(questionDTO);
        return ResponseEntity.ok(questionDTO);
    }

    @RequestMapping(value = "/question/{id}/disable", method = RequestMethod.PUT)
    public ResponseEntity<QuestionDTO> disable(@PathVariable final int id){
        try {
            QuestionDTO questionDTO = questionService.disable(id);
            return ResponseEntity.ok(questionDTO);
        } catch (ResourceNotFoundException e) {
            log.error(e);
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/question/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<QuestionDTO> delete(@PathVariable int id) {
        try {
            questionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            log.error(e);
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuestionDTO> find(@PathVariable int id){
        try {
            QuestionDTO questionDTO = questionService.find(id);
            return ResponseEntity.ok(questionDTO);
        } catch (ResourceNotFoundException e) {
            log.error(e);
            return ResponseEntity.notFound().build();
        }
    }


    @RequestMapping(value = "/question/all", method = RequestMethod.GET)
    public ResponseEntity<List<QuestionDTO>> findAll(){
        List<QuestionDTO> questions = questionService.findAll();
        return ResponseEntity.ok(questions);
    }


    @RequestMapping(value = "question/{questionId}/answer/{id}/statistics", method = RequestMethod.GET)
    public ResponseEntity<Integer> getStatistics(@PathVariable int id){
        try {
            return ResponseEntity.ok(answerService.countVotes(id));
        } catch (ResourceNotFoundException e) {
            log.error(e);
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "question/{questionId}/user/{id}/answer/{answerId}", method = RequestMethod.POST)
    public ResponseEntity<AnswerDTO> save(@RequestBody @Valid final int answerId, @PathVariable final int userId, @PathVariable final int questionId) {
        try {
            AnswerDTO answerDTO = answerService.save(answerId, userId, questionId);
            return ResponseEntity.ok(answerDTO);
        } catch (ResourceNotFoundException e) {
            log.error(e);
            return ResponseEntity.notFound().build();
        }
    }
}
