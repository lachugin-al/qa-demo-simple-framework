package steps;

import io.cucumber.java.en.Then;
import pages.BasicPage;

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

    @Then("Контент с фразой {string} отображается")
    public void contentIsVisible(String arg0) {
        basicPage.contentIsVisible(arg0);
    }

}
