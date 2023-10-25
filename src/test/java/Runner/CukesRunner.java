package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(

        plugin = {"html:target/cucumber-report.html"},
        features = "src/test/java/Features",
        glue = "StepDef",
        tags = "@saving or @login",
        dryRun = false
)



public class CukesRunner {

}
