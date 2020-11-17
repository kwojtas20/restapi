package pl.nullpointerexeption.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.nullpointerexeption.restapi.controller.mapper.UserMapper;
import pl.nullpointerexeption.restapi.controller.model.UserModel;
import pl.nullpointerexeption.restapi.controller.view.UserView;
import pl.nullpointerexeption.restapi.repository.UserRepository;
import pl.nullpointerexeption.restapi.repository.entity.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    public static final int PAGE_SIZE = 10;

    private final UserRepository userRepository;

    @Cacheable(cacheNames = "SingleUser", key = "#id")
    public UserView getSingleUser(Long id) {
        return UserMapper.mapToUserView(userRepository.findById(id).orElseThrow());
    }

    public UserView addUser(UserModel user) {
        return UserMapper.mapToUserView(userRepository.save(UserMapper.mapToUser(user)));
    }

    public List<UserView> getUsers(int page, Sort.Direction sort) {
        return UserMapper.mapToUserViews(userRepository.findAllUsers(
                PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id"))
        ));
    }

    @CachePut(cacheNames = "SingleUser", key = "#result.id")
    public UserView editUser(Long id, UserModel user) {
        User userEdited = userRepository.findById(id).orElseThrow();
        userEdited.setFirstName(user.getFirstName());
        userEdited.setSecondName(user.getSecondName());
        userEdited.setSurname(user.getSurname());
        return UserMapper.mapToUserView(userRepository.save(userEdited));
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
