package pages.fluentpage;

import org.openqa.selenium.WebDriver;

public class BaseFluentPomPage {
    public WebDriver driver;
    public BaseFluentPomPage(WebDriver driver) {
        this.driver = driver;
    }

}
