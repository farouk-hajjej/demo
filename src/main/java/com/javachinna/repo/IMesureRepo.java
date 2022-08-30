package com.javachinna.repo;

import com.javachinna.model.Mesure;
import org.springframework.data.repository.CrudRepository;

public interface IMesureRepo extends CrudRepository<Mesure,Long> {
}
