package org.ifellow.gaidukov.IF_HW4;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("JiraTest.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME,
        value = "JiraTest.feature")
public class CucumberRunnerTest {
}
