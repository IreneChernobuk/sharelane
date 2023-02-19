package pages.services;

import org.openqa.selenium.WebDriver;
import pages.pompages.ZipcodePomPage;

public class SendZipService {
    private WebDriver driver;
    public SendZipService(WebDriver driver){
        this.driver = driver;
    }
    public void inputZipCode(String zipCode){
        ZipcodePomPage zipcodePomPage = new ZipcodePomPage(driver);
        zipcodePomPage.openZipCodePage();
        zipcodePomPage.inputZipcode(zipCode);
        zipcodePomPage.clickContinue();
    }

}
