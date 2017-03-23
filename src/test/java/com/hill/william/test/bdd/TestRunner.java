package com.hill.william.test.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "json:target/Ok.json", "html:target/html_report" },
		features="src/test/resources/features",
		glue={"classpath:com.hill.william.test.bdd.steps"},tags = {"~@ignore"})
public class TestRunner {

}