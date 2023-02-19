package pages.testdata;

import model.RegistrationModel;
import utils.FakeMessageGenerator;

public class PrepareRegistrationData {

    public static RegistrationModel getValidRegistration() {
        String password = FakeMessageGenerator.generatePassword();
        return RegistrationModel
                .builder()
                .zipCode(FakeMessageGenerator.generateFiveZipCode())
                .firstName(FakeMessageGenerator.generateFirstName())
                .lastName(FakeMessageGenerator.generateLastName())
                .email(FakeMessageGenerator.generateEmail())
                .password(password)
                .confirmPassword(password)
                .build();
    }
}