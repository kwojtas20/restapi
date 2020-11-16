package pl.nullpointerexeption.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexeption.restapi.controller.view.UserView;
import pl.nullpointerexeption.restapi.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserView getSingleUser(@PathVariable Long userId) {
        return userService.getSingleUser(userId);
    }
}
