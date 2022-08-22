package com.javachinna.controller;

import com.javachinna.model.Question;
import com.javachinna.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/Question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @PostMapping("/addQuestion")
    @ResponseBody
    @ApiOperation(value = "Add Question")
    public void addQuestion(@RequestBody Question q){
        questionService.addQuestion(q);

    }
    @ApiOperation(value = "update Question By Id ")
    @PutMapping("/updateQusetionById/{idQ}")
    @ResponseBody
    public void UpdateQuestion(@RequestBody Question q, @PathVariable(name="idQ") Long idQu){
     questionService.UpdateQuestion(q,idQu);
    }
    @ApiOperation(value = "retrieve All Questions ")
    @GetMapping("/retrieve-All-Questions")
    @ResponseBody
    public List<Question> retrieveAllQuestions(){
        return questionService.retrieveAllQuestions();
    }
    @ApiOperation(value = "delete Qusetion By Id ")
    @GetMapping("/deleteQuestionById/{idQu}")
    @ResponseBody
    public void deleteQuestion(@PathVariable("idQu")Long id)
    {
        questionService.deleteQuestion(id);
    }
}
