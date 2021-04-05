package steps;

import io.cucumber.java.Before;
import pages.BasicPage;

import static com.codeborne.selenide.Selenide.open;

public class Hooks {
    BasicPage basicPage = new BasicPage();

    @Before
    public void openUrl(){
//        open("http://localhost/");
//        checkIsAllreadyLogin();
    }

    public void checkIsAllreadyLogin() {
        if (basicPage.checkIsAllreadyLogin("Выйти")) {
            basicPage.clickLogout();
            open("http://localhost/");
        }
    }
}
