package pages.pagefactorypages;

import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZipcodeFactorypage extends BaseFactoryPage {
    @FindBy(name = "zip_code")
    private WebElement zipCodeInput;

    @FindBy(css = "[value=Continue]")
    private WebElement continueButton;

    public ZipcodeFactorypage(WebDriver driver) {
        super(driver);
    }

    public void openZipcodePage() {
        driver.get(Urls.REGISTER_FORM_URL);
    }

    public void inputZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
