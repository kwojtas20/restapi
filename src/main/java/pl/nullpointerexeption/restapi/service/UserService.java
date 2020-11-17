package pl.nullpointerexeption.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.nullpointerexeption.restapi.controller.mapper.UserMapper;
import pl.nullpointerexeption.restapi.controller.model.UserModel;
import pl.nullpointerexeption.restapi.controller.view.UserView;
import pl.nullpointerexeption.restapi.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public static final int PAGE_SIZE = 10;

    @Cacheable(cacheNames = "SingleUser", key = "#id")
    public UserView getSingleUser(long id) {
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
}

