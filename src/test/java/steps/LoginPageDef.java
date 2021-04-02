package steps;

import config.UserConfig;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginPageDef {
    LoginPage loginPage = new LoginPage();

    @Then("Вводит данные в поле логин")
    public void inputLogin() {
        loginPage.setLoginInput(UserConfig.USER_LOGIN);
    }

    @Then("Вводим данные в поле пароль")
    public void inputPassword() {
        loginPage.setPasswordInput(UserConfig.USER_PASSWORD);
    }
}
