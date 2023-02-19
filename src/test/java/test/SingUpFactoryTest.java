package test;


import model.RegistrationModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagefactorypages.AccountCreatedFactoryPage;
import pages.pagefactorypages.SignUpFormFactoryPage;
import pages.pagefactorypages.ZipcodeFactorypage;
import pages.testdata.PrepareRegistrationData;
import utils.FakeMessageGenerator;

public class SingUpFactoryTest extends BaseTest {

    @Test
    public void fiveZipCodeTest() {
        ZipcodeFactorypage zipcodeFactorypage = new ZipcodeFactorypage(driver);
        zipcodeFactorypage.openZipcodePage();
        zipcodeFactorypage.inputZipCode(FakeMessageGenerator.generateFiveZipCode());
        zipcodeFactorypage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(driver);
        Assert.assertTrue(signUpFormFactoryPage.isRegisterDisplayed(), "'Register' button isn't displayed");
    }

    @Test
    public void singUpTest() {
        ZipcodeFactorypage zipcodeFactorypage = new ZipcodeFactorypage(driver);
        zipcodeFactorypage.openZipcodePage();
        zipcodeFactorypage.inputZipCode(FakeMessageGenerator.generateFiveZipCode());
        zipcodeFactorypage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(driver);
        RegistrationModel registrationModel = PrepareRegistrationData.getValidRegistration();
        signUpFormFactoryPage.sendRegistrationForm(registrationModel);
        AccountCreatedFactoryPage accountCreatedFactoryPage = new AccountCreatedFactoryPage(driver);
        Assert.assertTrue(accountCreatedFactoryPage.isMessageDisplayed());
    }
}