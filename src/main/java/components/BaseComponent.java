package components;

import static com.codeborne.selenide.Selenide.$;

import annotations.Component;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

public abstract class BaseComponent<T> {

    {
        $(getComponentBy()).shouldBe(Condition.visible);
    }

    private By getComponentBy() {
        Component component = getClass().getAnnotation(Component.class);
        if(component != null) {
            return component.value().startsWith("/")
                    ? By.xpath(component.value())
                    : By.cssSelector(component.value());
        }

        return null;
    }

}
