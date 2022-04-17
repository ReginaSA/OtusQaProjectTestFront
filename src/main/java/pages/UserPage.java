package pages;

import annotations.UrlPath;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

@UrlPath("/{id}")
public class UserPage extends BasePage{

    public String getUrlPage() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        return currentUrl;
    }
}
