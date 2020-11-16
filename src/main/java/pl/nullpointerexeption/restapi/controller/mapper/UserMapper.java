package pl.nullpointerexeption.restapi.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.nullpointerexeption.restapi.controller.view.UserView;
import pl.nullpointerexeption.restapi.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static List<UserView> mapToUserViews(List<User> users) {
        return users.stream()
                .map(UserMapper::mapToUserView)
                .collect(Collectors.toList());
    }

    public static UserView mapToUserView(User user) {
        return new UserView(user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getSurname(),
                user.getCreated(),
                user.getModified());
    }
}
