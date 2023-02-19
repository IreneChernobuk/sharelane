package pages.loadablepage;

import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZipcodeLoadablePomPage extends BaseLoadablePomPage {
    private By ZIPCODE_INPUT = By.name("zip_code");
    private By CONTINUE_BUTTON = By.cssSelector("[value=Continue]");

    public ZipcodeLoadablePomPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(CONTINUE_BUTTON).isDisplayed();
    }

    public void openZipCodePage() {
        driver.get(Urls.REGISTER_FORM_URL);
    }

    public void inputZipcode(String zipCode) {
        driver.findElement(ZIPCODE_INPUT).sendKeys(zipCode);
    }

    public void clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
