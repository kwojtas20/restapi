package pl.nullpointerexeption.restapi.controller.validator;

import org.springframework.stereotype.Component;
import pl.nullpointerexeption.restapi.controller.model.UserModel;

@Component
public class UserValidator {

    public void checkUserModel(UserModel userModel) {
        checkFirstName(userModel);
        checkSecondName(userModel);
        checkSurname(userModel);
    }

    public void checkFirstName(UserModel userModel) {
        if (userModel.getFirstName() == null) {
            throw new RuntimeException("Brak pierwszego imienia");
        }
        if (userModel.getFirstName().length() > 2000) {
            throw new RuntimeException("Za długie pierwsze imienia");
        }
    }

    public void checkSecondName(UserModel userModel) {
        if (userModel.getSecondName() == null) {
            throw new RuntimeException("Brak drugie imienia");
        }
        if (userModel.getSecondName().length() > 2000) {
            throw new RuntimeException("Za długie drugie imienia");
        }
    }

    public void checkSurname(UserModel userModel) {
        if (userModel.getSurname() == null) {
            throw new RuntimeException("Brak nazwiska");
        }
        if (userModel.getSurname().length() > 2000) {
            throw new RuntimeException("Za długie nazwisko");
        }
    }
}
