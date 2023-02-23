package pages.decorator;

import constants.Urls;
import elements.decoratorelements.ExtendedFieldDecorator;
import elements.decoratorelements.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZipCodeDecoratorPage {

    @FindBy(name = "zip_code")
    TextField zipcodeInput;

    public WebDriver driver;

    @FindBy(css = "[value=Continue]")
    private WebElement continueButton;

    public ZipCodeDecoratorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }

    public void openZipcodePage() {
        driver.get(Urls.REGISTER_FORM_URL);
    }

    public void inputZipcode(String zipCode) {
        zipcodeInput.type(zipCode);
    }

    public void goBackInHistory() {
        driver.navigate().back();
    }

    public void clearAndInput(String text) {
        zipcodeInput.clearAndType(text);
    }

    public void clickContinue() {
        continueButton.click();
    }
}