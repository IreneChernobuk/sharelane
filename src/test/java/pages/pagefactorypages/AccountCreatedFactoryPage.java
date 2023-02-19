package pages.pagefactorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedFactoryPage extends BaseFactoryPage {
    @FindBy(className = "confirmation_message")
    private WebElement confirmationMessage;

    public AccountCreatedFactoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMessageDisplayed() {
        return confirmationMessage.isDisplayed();
    }

}
