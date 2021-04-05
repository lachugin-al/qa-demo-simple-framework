package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginInput = $(By.cssSelector("#user_login"));
    private final SelenideElement passwordInput = $(By.cssSelector("#user_pass"));
    private final SelenideElement passwordInputNew = $(By.cssSelector("#pass1"));
    private final SelenideElement emailInput = $(By.xpath("//*[@id=\"email\"]"));
//    private final SelenideElement emailCheckbox = $(By.xpath("//*[text()='Отправить пользователю письмо об учётной записи.']/preceding-sibling::input[@type='checkbox']"));
    private final String clickCheckbox = ("/preceding-sibling::input[@type='checkbox']");
    private SelenideElement findSomeTextOnPage;

    public void setLoginInput(String text) {
        this.loginInput.val(text);
    }

    public void setPasswordInput(String text) {
        if((this.passwordInput).exists()) {
            passwordInput.val(text);
        } else {
            this.passwordInputNew.val(text);
        }
    }

    public void setEmailInput(String text) {
        this.emailInput.val(text);
    }

    public void setClickCheckbox(String text) {
        this.findSomeTextOnPage = $(By.xpath("//*[text()='" + text + "']" + clickCheckbox + ""));
    }

    public String getName() {
        return loginInput.getValue();
    }

    public String getEmail() {
        return emailInput.getValue();
    }
}
