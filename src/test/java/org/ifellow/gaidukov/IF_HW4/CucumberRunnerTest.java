package org.ifellow.gaidukov.IF_HW4;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
//@SelectClasspathResource("src/main/java/org/ifellow/gaidukov/IF_HW4/steps/jiraSteps")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "srс/test/resources/feature")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "src/main/java/org/ifellow/gaidukov/IF_HW4/steps/jiraSteps, src/test/java/org/ifellow/gaidukov/IF_HW4/hook/CucumberRunnerTest")

public class CucumberRunnerTest {
}
