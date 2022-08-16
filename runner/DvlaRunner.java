package api.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/api/cucumber/feature/dvla.feature"},glue ={"api/cucumber/steps"},
        plugin ={"pretty","junit:target/report.xml"} )

public class DvlaRunner {
}
