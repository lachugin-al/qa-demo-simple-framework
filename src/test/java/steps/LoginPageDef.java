package steps;

import config.UserConfig;
import impl.AuthServiceImpl;
import io.cucumber.java.en.Then;
import models.api.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import pages.LoginPage;
import services.IAuthService;

import static app_context.RunContext.*;

public class LoginPageDef {
    LoginPage loginPage = new LoginPage();
    IAuthService authService = new AuthServiceImpl();
    String randomData;

    public void randomData() {
        randomData = RandomStringUtils.randomAlphabetic(5);
    }

    @Then("Вводим данные пользователя {string} в поле логин")
    public void inputLogin(String text) {
        if (text.equals("Test")) {
            loginPage.setLoginInput(UserConfig.USER_LOGIN);
        }
    }

    @Then("Вводим данные пользователя {string} в поле пароль")
    public void inputPassword(String text) {
         if (text.equals("Test")) {
            loginPage.setPasswordInput(UserConfig.USER_PASSWORD);
        }
    }

    @Then("Вводим данные нового пользователя")
    public void вводимДанныеНовогоПользователя() {
        randomData();
        String username = "User" + randomData;
        loginPage.setLoginInput(username);
        put("username", username);
    }

    @Then("Вводим email нового пользователя")
    public void вводимEmailНовогоПользователя() {
        String email = "User" + randomData + "@localhost.localhost";
        loginPage.setEmailInput(email);
        put("email", email);
    }

    @Then("Вводим пароль нового пользователя")
    public void вводимПарольНовогоПользователя() {
        String pass = "User" + randomData;
        loginPage.setPasswordInput(pass);
        put("password", pass);
    }

    @Then("Нажимаем на чекбокс {string}")
    public void нажимаемНаЧекбокс(String arg0) {
        loginPage.setClickCheckbox(arg0);
    }

    @Then("Проверяем поле Имя")
    public void проверяемПолеИмя() {
        String expectValue = "test";
//        String expectValue = get("username", String.class);
        String actualValue = loginPage.getName();
        Assert.assertEquals(expectValue, actualValue);
    }

    @Then("Проверяем поле Email")
    public void проверяемПолеEmail() {
        String expectValue = "test@localhost.localhost";
//        String expectValue = get("email", String.class);
        String actualValue = loginPage.getEmail();
        Assert.assertEquals(expectValue, actualValue);
    }

    @Then("create user by API")
    public void createUserByAPI() {
        User newUser = User.builder()
                .email("auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com")
                .firstName("test")
                .lastName("test")
                .password("test")
                .rememberMe(true)
                .build();

        put("newUser", newUser);

        User createUser = authService.createUser(newUser);
        Assert.assertNotNull(createUser);
        Assert.assertEquals(newUser.getEmail().toLowerCase(), createUser.getEmail().toLowerCase());
        Assert.assertNotNull(createUser.getId());
    }

    @Then("login user by API")
    public void loginUserByAPI() {
        User user = get("newUser", User.class);
        User userLogged = authService.login(user);
        Assert.assertNotNull(userLogged);
        Assert.assertEquals(user.getEmail().toLowerCase(), userLogged.getEmail().toLowerCase());

        // to console
        String a = user.getEmail().toLowerCase();
        String b = userLogged.getEmail().toLowerCase();
        System.out.printf("%s, %s",a ,b);
    }
}
