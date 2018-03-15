package by.runets.voting.controller;

import by.runets.voting.dto.QuestionDTO;
import by.runets.voting.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

}
