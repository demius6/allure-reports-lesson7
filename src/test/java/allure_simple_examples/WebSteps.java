package allure_simple_examples;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу гитхаб")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository( String repo) {
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Открываем репозиторий {repo}")
    public void openRepositiry( String repo) {
        $(By.linkText("Repositories")).click();
        $(By.linkText(repo)).click();
    }

    @Step("Переходим в таб Issue")
    public void openIssueTab() {
        $("#issues-tab").click();
    }
    @Step("Проверяем, что существует Issue с номером {num}")
    public void shoulSeeIssueWithNumber( int num) {
        $(withText("#68")).should(Condition.exist);
    }

}
