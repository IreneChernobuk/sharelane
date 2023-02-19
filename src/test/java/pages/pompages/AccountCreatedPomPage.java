package pages.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPomPage extends BasePomPage {
    private By ACCOUNT_CREATED_MESSAGE = By.className("confirmation_message");

    public AccountCreatedPomPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(ACCOUNT_CREATED_MESSAGE).isDisplayed();
    }
}
