import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import org.junit.Test;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.MainPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.currentFrameUrl;

public class CheckUserInfoTest {

    String userId = "68";

    /**
     * Поиск пльзователя по id и переход на его страницу
     */
    @Test
    public void chekUserById() {

        new MainPage().open();
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'"+ userId + "')]")).click();
        webdriver().shouldHave(url( "http://localhost:3000/" + userId));
    }
}
