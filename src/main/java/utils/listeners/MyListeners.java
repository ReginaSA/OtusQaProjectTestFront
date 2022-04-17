package utils.listeners;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;


public class MyListeners implements WebDriverListener {


    @Override
    public void beforeClick(WebElement element) {
        ((JavascriptExecutor) Selenide.webdriver()).executeScript("arguments[0].style.border='3px solid red'", element);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
