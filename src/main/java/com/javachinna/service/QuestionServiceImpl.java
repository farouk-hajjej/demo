package com.javachinna.service;

import com.javachinna.model.Question;
import com.javachinna.model.User;
import com.javachinna.repo.IQuestionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
   private IQuestionRepo questionRepo;
    @Override
    public void addQuestion(Question q) {
        questionRepo.save(q);

    }

    @Override
    public void UpdateQuestion(Question q, Long idQu) {
        Question question=questionRepo.findById(idQu).orElse(null);
        q.setCategorie(q.getCategorie());
        q.setContenu(q.getContenu());
        q.setDomain(q.getDomain());
        q.setMesure(q.getMesure());
        q.setRecommandation(q.getRecommandation());
        q.setCode(q.getCode());
        q.setType(q.getType());
        questionRepo.save(q);

    }

    @Override
    public List<Question> retrieveAllQuestions() {
        List<Question> questions = new ArrayList<Question>();
        questionRepo.findAll().forEach(question -> {
            questions.add(question);
        });
        return questions;

    }

    @Override
    public void deleteQuestion(Long idQes) {
        questionRepo.deleteById(idQes);

    }
}
