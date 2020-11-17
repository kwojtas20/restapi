package pl.nullpointerexeption.restapi.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.nullpointerexeption.restapi.controller.model.UserModel;
import pl.nullpointerexeption.restapi.controller.view.UserView;
import pl.nullpointerexeption.restapi.repository.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserView mapToUserView(User user) {
        return new UserView(user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getSurname(),
                user.getCreated(),
                user.getModified());
    }

    public static User mapToUser(UserModel userModel) {
        return User.builder()
                .firstName(userModel.getFirstName())
                .secondName(userModel.getSecondName())
                .surname(userModel.getSurname())
                .build();
    }
}
