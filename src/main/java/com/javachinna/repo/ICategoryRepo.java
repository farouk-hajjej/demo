package com.javachinna.repo;

import com.javachinna.model.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepo extends CrudRepository<Categorie,Long> {
}
