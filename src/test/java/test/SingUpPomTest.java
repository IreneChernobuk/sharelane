package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pompages.AccountCreatedPomPage;
import pages.pompages.SignUpFormPomPage;
import pages.services.SendZipService;
import utils.FakeMessageGenerator;

public class SingUpPomTest extends BaseTest {

    @Test
    public void fiveZipCodeTest() {
        SendZipService sendZipService = new SendZipService(driver);
        sendZipService.inputZipCode(FakeMessageGenerator.generateFiveZipCode());
        SignUpFormPomPage signUpFormPomPage = new SignUpFormPomPage(driver);
        Assert.assertTrue(signUpFormPomPage.isRegisterDisplayed(), "'Register' button isn't displayed");
    }

    @Test
    public void singUpTest() {
        SendZipService sendZipService = new SendZipService(driver);
        sendZipService.inputZipCode(FakeMessageGenerator.generateFiveZipCode());
        SignUpFormPomPage signUpFormPomPage = new SignUpFormPomPage(driver);
        signUpFormPomPage.inputFirstName(FakeMessageGenerator.generateFirstName());
        signUpFormPomPage.inputLastName(FakeMessageGenerator.generateLastName());
        signUpFormPomPage.inputEmail(FakeMessageGenerator.generateEmail());
        String password = FakeMessageGenerator.generatePassword();
        signUpFormPomPage.inputPassword(password);
        signUpFormPomPage.inputConfirmPassword(password);
        signUpFormPomPage.clickRegister();
        AccountCreatedPomPage accountCreatedPomPage = new AccountCreatedPomPage(driver);
        Assert.assertTrue(accountCreatedPomPage.isSuccessMessageDisplayed());
    }
}
