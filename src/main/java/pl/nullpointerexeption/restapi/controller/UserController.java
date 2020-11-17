package pl.nullpointerexeption.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexeption.restapi.controller.model.UserModel;
import pl.nullpointerexeption.restapi.controller.view.UserView;
import pl.nullpointerexeption.restapi.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserView getSingleUser(@PathVariable Long userId) {
        return userService.getSingleUser(userId);
    }

    @PostMapping
    public UserView addUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @GetMapping // Ta adnotacja oznacza utworzenie metody rest GET pod adresem /posts
    public List<UserView> getUsers(@RequestParam(required = false) Integer page,
                                   @RequestParam(required = false) Sort.Direction sortDirection) {
        return userService.getUsers(
                checkPageNumber(page),
                checkSortDirection(sortDirection)
        );

    }

    private int checkPageNumber(Integer page) {
        return page != null && page >= 0 ? page : 0;
    }

    private Sort.Direction checkSortDirection(Sort.Direction sort) {
        return sort != null ? sort : Sort.Direction.ASC;
    }

    @PutMapping("/{userId}")
    public UserView editUser(@PathVariable Long userId, @RequestBody UserModel userModel) {
        return userService.editUser(userId, userModel);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}

