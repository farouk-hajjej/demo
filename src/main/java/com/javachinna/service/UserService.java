package com.javachinna.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import com.javachinna.dto.LocalUser;
import com.javachinna.dto.SignUpRequest;
import com.javachinna.exception.UserAlreadyExistAuthenticationException;
import com.javachinna.model.User;

/**
 * @author Chinna
 * @since 26/3/18
 */
public interface UserService {

 void addUser(User user);
	void updateUser(User u, Long idU);
	List<User> retrieveAllUsers();
	void deleteUser ( Long id);

	User retrieveUser (Long id);


	void SearchHistorique(String keyword);
	User findById(Long id);

	List<User> searchmultilplUser(String key);
	 User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

	User findUserByEmail(String email);

	Optional<User> findUserById(Long id);

	LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
