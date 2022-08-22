package com.javachinna.repo;

import com.javachinna.model.Search;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ISearchRepo extends CrudRepository<Search,Integer> {

    @Query(value = "select u.displayName from User u where concat(u.displayName,u.email,u.enabled) like %?1% ")
    String keyWord(String keyword);



}
