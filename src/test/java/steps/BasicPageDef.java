package steps;

import config.EnvConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasicPage;

import static com.codeborne.selenide.Selenide.open;

public class BasicPageDef {
    BasicPage basicPage = new BasicPage();

    @Then("Выбираем меню {string}")
    public void clickMenu(String arg0) {
        basicPage.clickMenu(arg0);
    }

    @Then("Нажимаем на кнопку {string}")
    public void clickButton(String arg0) {
        basicPage.clickButton(arg0);
    }

    @Then("Контент содержащий фразу {string} отображается")
    public void contentIsVisible(String arg0) {
        basicPage.contentIsVisible(arg0);
    }

    @Given("Открываем страницу {string}")
    public void openPage(String arg0) {
        open(EnvConfig.URI_LOGIN + arg0);
    }
}
