
import components.UserBlock;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import pages.MainPage;
import utils.extensions.UIExtension;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

@ExtendWith(UIExtension.class)
public class CheckUserInfoTest {

    String userId = "68";

    /**
     * Поиск пльзователя по id и переход на его страницу
     */
    @Test
    public void chekUserById() throws InterruptedException {

        new MainPage().open();
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'"+ userId + "')]")).scrollIntoView(true).click();
        webdriver().shouldHave(url( "http://localhost:3000/" + userId));
    }

    @Test
    public void goToUserPage() {

        new MainPage().open();
        new UserBlock()
                .clickRandomUserItem();
    }
}
