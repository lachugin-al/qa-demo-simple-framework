package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage {
    public SelenideElement avatar = $(byXpath("//li[contains(@class, 'menupop with-avatar')]/.."));
}
