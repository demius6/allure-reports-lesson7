package allure_simple_examples;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class SelenideTest {

    @Test
    public void searchForIssue() {
//        Configuration.remote = "http://localhost:4444/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".search-input-container").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example ");
        $("#query-builder-test").submit();
        $(By.linkText("Repositories")).click();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#87")).should(Condition.exist);
    }
}
