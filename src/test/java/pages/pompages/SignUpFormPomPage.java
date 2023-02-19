package pages.pompages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpFormPomPage extends BasePomPage {

    private By FIRST_NAME_INPUT = By.name("first_name");
    private By LAST_NAME_INPUT = By.name("last_name");
    private By EMAIL_INPUT = By.name("email");
    private By PASSWORD_INPUT = By.name("password1");
    private By CONFIRM_PASSWORD_INPUT = By.name("password2");
    private By REGISTER_BUTTON = By.cssSelector("[value=Register]");

    public SignUpFormPomPage(WebDriver driver) {
        super(driver);
    }

    public void inputFirstName(String firstName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
    }

    public void inputEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void inputConfirmPassword(String confirmPassword) {
        driver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(confirmPassword);
    }

    public void clickRegister() {
        driver.findElement(REGISTER_BUTTON).click();
    }
    public boolean isRegisterDisplayed(){
        return driver.findElement(REGISTER_BUTTON).isDisplayed();
    }

}
