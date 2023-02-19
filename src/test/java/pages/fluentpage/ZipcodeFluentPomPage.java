package pages.fluentpage;

import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZipcodeFluentPomPage extends BaseFluentPomPage {
    private By ZIPCODE_INPUT = By.name("zip_code");
    private By CONTINUE_BUTTON = By.cssSelector("[value=Continue]");

    public ZipcodeFluentPomPage(WebDriver driver) {
        super(driver);
    }

    public ZipcodeFluentPomPage openZipCodePage() {
        driver.get(Urls.REGISTER_FORM_URL);
        return this;
    }

    public ZipcodeFluentPomPage inputZipcode(String zipCode) {
        driver.findElement(ZIPCODE_INPUT).sendKeys(zipCode);
        return this;
    }

    public SignUpFormFluentPomPage clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
        return new SignUpFormFluentPomPage(driver);
    }

    public void performZipSend(String zipCode){
        driver.get(Urls.REGISTER_FORM_URL);
        driver.findElement(ZIPCODE_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
