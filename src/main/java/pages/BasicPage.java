package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

// общие методы для страниц
public class BasicPage {

    public void clickMenu(String text) {
        $(By.xpath("//a[text()='" + text + "']")).click();
//        $(By.xpath("//*[text()[contains(.,'" + text + "')]]")).click();
    }

    public void clickButton(String text) {
        $(By.xpath("//input[@value='" + text + "']")).click();
    }

    public void contentIsVisible(String text) {
        $(By.xpath("//*[text()[contains(.,'" + text + "')]]")).shouldBe(Condition.visible);
    }
}
