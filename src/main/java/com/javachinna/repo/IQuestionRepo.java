package com.javachinna.repo;

import com.javachinna.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface IQuestionRepo extends CrudRepository<Question,Long> {
}
