package com.javachinna.repo;

import com.javachinna.model.DatabaseFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DatabaseFileRepository extends CrudRepository<DatabaseFile, String> {

}
