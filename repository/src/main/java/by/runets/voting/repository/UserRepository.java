package by.runets.voting.repository;

import by.runets.voting.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User saveUser(User user);

    List<User> findAllUser();

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByEmailPassword(String email, String password);
}
