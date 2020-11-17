package pl.nullpointerexeption.restapi.controller.model;

import lombok.Data;

/**
 * Ta klasa jest wykorzystywana przy ładowaniu danych w restach POST, PUT, PATCH
 */
@Data
public class UserModel {

    private final String firstName;
    private final String secondName;
    private final String surname;
}
