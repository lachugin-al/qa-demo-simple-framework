package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.AccountPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class AccountPageDef {
    AccountPage accountPage = new AccountPage();

    @Then("Нажимаем на иконку личного кабинета")
    public void нажимаемНаИконкуЛичногоКабинета() {
        accountPage.avatar.scrollTo().click();
    }
}
