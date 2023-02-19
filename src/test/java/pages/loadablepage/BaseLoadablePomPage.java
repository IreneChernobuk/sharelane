package pages.loadablepage;

import org.openqa.selenium.WebDriver;

public abstract class BaseLoadablePomPage {
    public WebDriver driver;

    public BaseLoadablePomPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract boolean isPageOpened();
}
