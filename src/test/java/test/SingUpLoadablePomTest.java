package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loadablepage.SignUpFormLoadablePomPage;
import pages.loadablepage.ZipcodeLoadablePomPage;
import pages.pompages.AccountCreatedPomPage;
import pages.pompages.SignUpFormPomPage;
import pages.services.SendZipService;
import utils.FakeMessageGenerator;

public class SingUpLoadablePomTest extends BaseTest {

    @Test
    public void fiveZipCodeTest() {
        ZipcodeLoadablePomPage zipPage = new ZipcodeLoadablePomPage(driver);
        zipPage.openZipCodePage();
        Assert.assertTrue(zipPage.isPageOpened(), "Continue button isn't displayed");
    zipPage.inputZipcode(FakeMessageGenerator.generateFiveZipCode());
    zipPage.clickContinue();
    SignUpFormLoadablePomPage signUpFormLoadablePomPage = new SignUpFormLoadablePomPage(driver);
    Assert.assertTrue(signUpFormLoadablePomPage.isRegisterDisplayed());
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


