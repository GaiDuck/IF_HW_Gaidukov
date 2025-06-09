import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Откуда сами фичи брать
        features = "src/test/resources/feature",
        //Указание как мы собираем отчёты: значение-pretty говорит от том что этот тип отчета будет подробный.
        //Далее можем просто добавить ещё тип отчета. https://www.toolsqa.com/selenium-cucumber-framework/cucumber-reports/
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "json:target/cucumber.json"},
        //Откуда тесты и настройки берутся
        glue = {"hooks", "steps"},
        //Главный тэг всех тестов
        tags = "@TEST"
)

public class RunnerTest {

}
