package pages;

import annotations.UrlPath;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

@UrlPath("/{id}")
public class UserPage extends BasePage{

    @Step
    public String getUrlPage() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        return currentUrl;
    }
}
