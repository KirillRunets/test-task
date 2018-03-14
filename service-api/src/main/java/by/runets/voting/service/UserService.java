package by.runets.voting.service;

import by.runets.voting.exception.ResourceNotFoundException;
import by.runets.voting.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    User findUserByEmail(String email) throws ResourceNotFoundException;

    User findUserByEmailPassword(String email, String password) throws ResourceNotFoundException;
}
