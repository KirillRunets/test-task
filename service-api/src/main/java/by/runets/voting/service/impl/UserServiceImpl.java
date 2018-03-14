package by.runets.voting.service.impl;

import by.runets.voting.exception.ResourceNotFoundException;
import by.runets.voting.model.User;
import by.runets.voting.repository.UserRepository;
import by.runets.voting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findUserByEmail(String email) throws ResourceNotFoundException {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }

    @Override
    public User findUserByEmailPassword(String email, String password) throws ResourceNotFoundException {
        return userRepository.findUserByEmailPassword(email, password)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email or password: " + email + " " + password));
    }
}
