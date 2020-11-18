package pl.nullpointerexeption.restapi.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.nullpointerexeption.restapi.controller.model.UserModel;
import pl.nullpointerexeption.restapi.controller.view.UserView;
import pl.nullpointerexeption.restapi.repository.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static List<UserView> mapToUserViews(List<User> users) {
        if (users == null) {
            return new ArrayList<>();
        }
        return users.stream()
                .map(UserMapper::mapToUserView)
                .collect(Collectors.toList());
    }

    public static UserView mapToUserView(User user) {
        if (user == null) {
            return null;
        }
        return new UserView(user.getId(),
                user.getCreated(),
                user.getModified(),
                user.getFirstName(),
                user.getSecondName(),
                user.getSurname(),
                PostMapper.mapToPostViews(user.getPosts()));
    }

    public static User mapToUser(UserModel userModel) {
        return User.builder()
                .firstName(userModel.getFirstName())
                .secondName(userModel.getSecondName())
                .surname(userModel.getSurname())
                .build();
    }
}
