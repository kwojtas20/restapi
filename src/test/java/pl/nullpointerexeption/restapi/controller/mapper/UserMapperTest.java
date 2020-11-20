package pl.nullpointerexeption.restapi.controller.mapper;

import org.junit.jupiter.api.Test;
import pl.nullpointerexeption.restapi.controller.model.UserModel;
import pl.nullpointerexeption.restapi.controller.view.UserView;
import pl.nullpointerexeption.restapi.repository.entity.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserMapperTest {

    @Test
    void shouldMapToUserViews() {
        //given
        User user1 = new User();
        user1.setFirstName("Kinga");
        user1.setSecondName("Barbara");
        user1.setSurname("Wojtaś");
        user1.setId(1L);
        user1.setCreated(LocalDateTime.of(2020, Month.APRIL, 21, 10, 0));
        user1.setModified(LocalDateTime.of(2019, Month.APRIL, 21, 10, 0));

        User user2 = new User();
        user2.setFirstName("Kinga");
        user2.setSecondName("Barbara");
        user2.setSurname("Wojtaś");
        user2.setId(2L);
        user2.setCreated(LocalDateTime.of(2020, Month.APRIL, 21, 10, 0));
        user2.setModified(LocalDateTime.of(2019, Month.APRIL, 21, 10, 0));

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        //when
        List<UserView> userViews = UserMapper.mapToUserViews(users);
        //then
        assertThat(userViews).isNotNull();
        assertThat(userViews.size()).isEqualTo(users.size());
    }

    @Test
    void shouldMapToUserView() {
        //given
        User user1 = new User();
        user1.setFirstName("Kinga");
        user1.setSecondName("Barbara");
        user1.setSurname("Wojtaś");
        user1.setId(1L);
        user1.setCreated(LocalDateTime.of(2020, Month.APRIL, 21, 10, 0));
        user1.setModified(LocalDateTime.of(2019, Month.APRIL, 21, 10, 0));
        //when
        UserView userView = UserMapper.mapToUserView(user1);
        //then
        assertThat(userView).isNotNull();
        assertThat(userView.getFirstName()).isEqualTo(user1.getFirstName());
        assertThat(userView.getSecondName()).isEqualTo(user1.getSecondName());
        assertThat(userView.getSurname()).isEqualTo(user1.getSurname());
        assertThat(userView.getId()).isEqualTo(user1.getId());
        assertThat(userView.getCreated()).isEqualTo(user1.getCreated());
        assertThat(userView.getModified()).isEqualTo(user1.getModified());
    }

    @Test
    void shouldReturnNullWhenUserIsNull() {
        //when
        UserView userView = UserMapper.mapToUserView(null);
        //expect
        assertNull(userView);
    }

    @Test
    void shouldReturnEmptyListNullWhenUserListIsNull() {
        //when
        List<UserView> userViews = UserMapper.mapToUserViews(null);
        //expect
        assertTrue(userViews.isEmpty());
    }

    @Test
    void shouldMapToUsers() {
        //given
        List<UserModel> userModels = new ArrayList<>();
        userModels.add(new UserModel("Kinga1", "Barbara1", "Wojtaś1"));
        userModels.add(new UserModel("Kinga2", "Barbara2", "Wojtaś2"));
        //when
        List<User> users = UserMapper.mapToUsers(userModels);
        //then
        assertThat(users).isNotNull();
        assertThat(users.size()).isEqualTo(userModels.size());
    }

    @Test
    void shouldMapToUser() {
        //given
        UserModel userModel = new UserModel("Kinga", "Barbara", "Wojtaś");
        User.builder().firstName("Kinga");
        User.builder().secondName("Barbara");
        User.builder().surname("Wojtaś");
        User.builder();
        //when
        User user = UserMapper.mapToUser(userModel);
        //then
        assertThat(user.getFirstName()).isEqualTo(userModel.getFirstName());
        assertThat(user.getSecondName()).isEqualTo(userModel.getSecondName());
        assertThat(user.getSurname()).isEqualTo(userModel.getSurname());
    }

    @Test
    void shouldReturnNullWhenUserModelIsNull() {
        //when
        User user = UserMapper.mapToUser(null);
        //expect
        assertNull(user);
    }

    @Test
    void shouldReturnEmptyListNullWhenUserModelListIsNull() {
        //when
        List<User> users = UserMapper.mapToUsers(null);
        //expect
        assertTrue(users.isEmpty());
    }
}