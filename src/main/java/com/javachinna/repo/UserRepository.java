package com.javachinna.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javachinna.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	boolean existsByEmail(String email);
//	@Query("SELECT u FROM User u WHERE u.id LIKE %:id% ")
	//Optional<User> findById(@Param("id") Long id);

	//Optional<Object> findById(@Param("fileId")Integer fileId);
	@Query(value = "select u from User u where concat(u.id,u.displayName,u.email,u.enabled,u.provider,u.providerUserId) like %?1% group by u ")
	List<User> rechmultiple(String keyword);
}
