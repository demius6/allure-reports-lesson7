package allure_simple_examples;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;


    @Test
    public void testLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу гитхаб", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").sendKeys("eroshenkoam/allure-example ");
            $("#query-builder-test").submit();
        });
        step("Открываем репозиторий " + REPOSITORY, () -> {
            $(By.linkText("Repositories")).click();
            $(By.linkText("eroshenkoam/allure-example")).click();
        });
        step("Переходим в таб Issue ", () -> {
            $("#issues-tab").click();
            Allure.addAttachment("Page Sourse", "text/html", WebDriverRunner.source(), "html");
        });
        step("Проверяем, что существует Issue  с номером " + ISSUE_NUMBER, () -> {
            $(withText("#87")).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositiry(REPOSITORY);
        steps.openIssueTab();
        steps.shoulSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
