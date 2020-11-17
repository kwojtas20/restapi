package pl.nullpointerexeption.restapi.controller.model;

import lombok.Data;

@Data
public class UserModel {

    private final String firstName;

    private final String secondName;

    private final String surname;
}
