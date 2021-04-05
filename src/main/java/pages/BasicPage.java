package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

// общие методы для страниц
public class BasicPage {

    public void clickMenu(String text) {
        $(By.xpath("//a[text()='" + text + "']")).click();
    }

    public void clickButton(String text) {
        $(By.xpath("//input[@value='" + text + "']")).click();
    }

    public void contentIsVisible(String text) {
        $(By.xpath("//*[text()[contains(.,'" + text + "')]]")).shouldBe(Condition.visible);
    }

    public Boolean checkContentExist(String text) {
        if ($(By.xpath("//*[text()[contains(.,'" + text + "')]]")).exists()) {
            return true;
        } else return false;
    }

    public Boolean checkIsAllreadyLogin(String text) {
        if ($(By.xpath("//*//descendant::a[text()='" + text + "']")).exists()) {
            return true;
        } else return false;
    }

    public void clickLogout() {
        $(By.xpath("//*//descendant::a[text()='Выйти'][3]")).click();
    }

    public void clickArrowDown() {
        $(By.xpath("//header[@id='masthead']//descendant::*[@role='img']")).click();
    }

}
