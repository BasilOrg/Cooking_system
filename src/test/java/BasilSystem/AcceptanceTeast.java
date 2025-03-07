package BasilSystem;
import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith (Cucumber. class)
@CucumberOptions(features = "use_cases",

        plugin = { "summary", "html: target/cucumber/wikipedia.html"},
        monochrome=true,
        snippets =CucumberOptions.SnippetType.CAMELCASE,
        glue = { "BasilSystem" }

)

public class AcceptanceTeast {
}
