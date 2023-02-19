package pages.pompages;

import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZipcodePomPage extends BasePomPage {
    private By ZIPCODE_INPUT = By.name("zip_code");
    private By CONTINUE_BUTTON = By.cssSelector("[value=Continue]");

    public ZipcodePomPage(WebDriver driver) {
        super(driver);
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
