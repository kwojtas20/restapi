package pl.nullpointerexeption.restapi.controller.view;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Ta klasa jest wykorzystywana przy pobieraniu danych w restach GET
 */
@Value
public class UserView {

    Long id;
    LocalDateTime created;
    LocalDateTime modified;
    String firstName;
    String secondName;
    String surname;
    List<PostView> posts;
}
