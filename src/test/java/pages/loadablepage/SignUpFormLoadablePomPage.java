package pages.loadablepage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpFormLoadablePomPage extends BaseLoadablePomPage {
    private By REGISTER_BUTTON = By.cssSelector("[value=Register]");

    public SignUpFormLoadablePomPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isRegisterDisplayed();
    }

    public boolean isRegisterDisplayed() {
        return driver.findElement(REGISTER_BUTTON).isDisplayed();
    }
}