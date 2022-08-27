package com.javachinna.repo;

import com.javachinna.model.Domain;
import org.springframework.data.repository.CrudRepository;

public interface IDomaineRepo extends CrudRepository<Domain,Long> {
}
