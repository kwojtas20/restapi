package pl.nullpointerexeption.restapi.controller.view;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class UserView {

    long id;
    String firstName;
    String secondName;
    String surname;
    LocalDateTime created;
    LocalDateTime modified;
}

