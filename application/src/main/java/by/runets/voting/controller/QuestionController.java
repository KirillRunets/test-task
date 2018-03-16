package by.runets.voting.controller;

import by.runets.voting.dto.QuestionDTO;
import by.runets.voting.exception.ResourceNotFoundException;
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

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public ResponseEntity<QuestionDTO> create(@RequestBody @Valid final QuestionDTO questionDTO){
        questionService.save(questionDTO);
        return ResponseEntity.ok(questionDTO);
    }

    @RequestMapping(value = "/question/{id}/disable", method = RequestMethod.PUT)
    public ResponseEntity<QuestionDTO> disable(@RequestBody @Valid final QuestionDTO questionDTO){
        questionDTO.setEnabled(false);
        questionService.save(questionDTO);
        return ResponseEntity.ok(questionDTO);
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
}
