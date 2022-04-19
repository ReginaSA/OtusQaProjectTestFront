package components;


import annotations.Component;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import pages.UserPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

@Component(".MuiPaper-root .MuiTypography-root")
public class UserBlock extends BaseComponent<UserBlock> {

    private ElementsCollection userBlock = $$(".MuiPaper-root .MuiTypography-root");

    @Step
    public UserPage clickRandomUserItem() {
        int userSize = userBlock
                .shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(10))
                .size();
        int index = new Faker().number().numberBetween(0, userSize);

        userBlock.get(index)
                .click();

        return page(UserPage.class);
    }
}
