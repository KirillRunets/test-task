package by.runets.voting.service.impl;

import by.runets.voting.dto.UserDTO;
import by.runets.voting.model.User;
import by.runets.voting.repository.UserRepository;
import by.runets.voting.service.UserService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;


@Service
@Data
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
    public void delete(Integer id) {
    }
}
