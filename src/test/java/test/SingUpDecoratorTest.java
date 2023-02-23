package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.decorator.ZipCodeDecoratorPage;
import pages.pagefactorypages.SignUpFormFactoryPage;
import utils.FakeMessageGenerator;

public class SingUpDecoratorTest extends BaseTest {

    @Test
    public void fiveZipCodeTest() {
        ZipCodeDecoratorPage zipCodeDecoratorPage = new ZipCodeDecoratorPage(driver);
        zipCodeDecoratorPage.openZipcodePage();
        zipCodeDecoratorPage.inputZipcode(FakeMessageGenerator.generateFiveZipCode());
        zipCodeDecoratorPage.clickContinue();
        zipCodeDecoratorPage.goBackInHistory();
        zipCodeDecoratorPage.clearAndInput(FakeMessageGenerator.generateFiveZipCode());
        zipCodeDecoratorPage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(driver);
        Assert.assertTrue(signUpFormFactoryPage.isRegisterDisplayed(), "'Register' button isn't displayed");
    }
}