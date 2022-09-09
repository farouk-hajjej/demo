package com.javachinna.service;

import com.javachinna.model.Question;


import java.util.List;

public interface QuestionService {
    void addQuestion(Question q);
    void UpdateQuestion(Question q, Long idQu);
    List<Question> retrieveAllQuestions();
    void deleteQuestion ( Long idQes);
}
