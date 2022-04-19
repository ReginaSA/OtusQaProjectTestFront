import components.UserBlock;
import io.qameta.allure.Description;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class CheckUserInfoTest {

    String userId = "68";

    @Test
    @Description("Поиск пользователя по id и переход на его страницу c проверкой URL")
    public void goToUserPageById() throws InterruptedException {

        new MainPage().open();
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'" + userId + "')]"))
                .scrollIntoView(true).click();
        webdriver().shouldHave(url("http://localhost:3000/" + userId));
    }

    @Test
    @Description("Переход на страницу рандомного пользователя")
    public void goToUserPage() {

        new MainPage().open();
        String urlPage = new UserBlock()
                .clickRandomUserItem()
                .getUrlPage();
        urlPage.contains(userId);
    }
}
