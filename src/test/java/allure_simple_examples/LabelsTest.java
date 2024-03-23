package allure_simple_examples;

import io.qameta.allure.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Owner("demius6")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Создание новой задачи")
    @DisplayName("Проверка создания Issue для...")
    @Description("Здесь можно подробно описать суть теста")
    @Link(value = "Testing", url = "https://github.com" )
    public void testAnnotatedLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.label("owner", "demius6");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("Задачи в репозитории");
        Allure.story("Удаление новой задачи");
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setName("Проверка удаления Issue  авторизованного пользователя");
        });
        Allure.description("Здесь можо подробно описать суть теста");
        Allure.link("Testing", "https://github.com");
    }

    @Test
    public void testParameters() {
        Allure.parameter("Регион", "Минская область");
        Allure.parameter("Город", "Минск");
    }
}
