package by.runets.voting.service.impl;

import by.runets.voting.dto.UserDTO;
import by.runets.voting.exception.ResourceNotFoundException;
import by.runets.voting.model.Question;
import by.runets.voting.model.User;
import by.runets.voting.repository.UserRepository;
import by.runets.voting.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO find(Integer id) {
        User user =  userRepository.getOne(id);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();

        Type listType = new TypeToken<List<UserDTO>>() {
        }.getType();

        return modelMapper.map(users, listType);
    }

    @Override
    @Transactional
    public void save(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()){
            throw new ResourceNotFoundException("Cannot delete user by id: " + id);
        }

        userRepository.delete(user.get());

    }
}
