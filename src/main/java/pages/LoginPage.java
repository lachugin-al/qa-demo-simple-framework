package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginInput = $(By.cssSelector("#user_login"));
    private final SelenideElement passwordInput = $(By.cssSelector("#user_pass"));

    public void setLoginInput(String text) {
        this.loginInput.val(text);
    }

    public void setPasswordInput(String text) {
        this.passwordInput.val(text);
    }

}
