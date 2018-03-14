package by.runets.voting.mapper.impl;

import by.runets.voting.dto.UserDTO;
import by.runets.voting.mapper.GenericMapper;
import by.runets.voting.model.User;
import by.runets.voting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper implements GenericMapper<User, UserDTO> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User map(UserDTO userDTO) {
        return null;
    }

    @Override
    public User map(UserDTO userDTO, User entity) {
        return null;
    }
}
