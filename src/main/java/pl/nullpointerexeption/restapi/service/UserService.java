package pl.nullpointerexeption.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pl.nullpointerexeption.restapi.controller.mapper.UserMapper;
import pl.nullpointerexeption.restapi.controller.view.UserView;
import pl.nullpointerexeption.restapi.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Cacheable(cacheNames = "SingleUser", key = "#id")
    public UserView getSingleUser(long id) {
        return UserMapper.mapToUserView(userRepository.findById(id).orElseThrow());
    }
}
