package autodoria

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = ["classpath:autodoria/"],
        features = ["classpath:autodoria/"],
        format = ["pretty", "html:target/site/cucumber-pretty", "json:target/cucumber-json/cucumber.json"]
)
class WikiSuite {
}
