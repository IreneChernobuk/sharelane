package elements.decoratorelements;

import org.openqa.selenium.WebElement;

public class TextFieldImpl implements TextField {
    protected final WebElement wrappedWebElement;

    public TextFieldImpl(WebElement wrappedWebElement) {
        this.wrappedWebElement = wrappedWebElement;
    }

    @Override
    public void type(String text) {
        wrappedWebElement.sendKeys(text);
    }

    @Override
    public void clear() {
        wrappedWebElement.clear();
    }

    @Override
    public void clearAndType(String text) {
        clear();
        type(text);
    }
}
