package elements.decoratorelements;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

import static java.lang.String.format;

public class DefaultElementFactory {

    public <E extends Element> E create(final Class<E> elementClass,
                                        final WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private <E extends Element> Class<? extends E>
    findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>)
                    Class.forName(format("%s.%sImpl", getClass().getPackage().getName(),
                            elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}