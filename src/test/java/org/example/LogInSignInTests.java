package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LogInSignInTests {
    public static WebDriver webDriver;
    final static String logInSignInUrl = "https://practice.automationtesting.in/my-account/";
    public static LogInAndSignInPage logInAndSignInPage;

    @Before
    public static void initSetup() {
        ChromeOptions options = new ChromeOptions().addArguments("Start-Maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logInAndSignInPage = new LogInAndSignInPage(webDriver, logInSignInUrl);
    }

    @After
    public static void closeAndQuit() {
        webDriver.quit();
        //webDriver.quit();
    }

    @Given("the browser is open on the login page")
    public void the_browser_is_open_on_the_login_page() {
        Assertions.assertTrue(logInAndSignInPage.isBrowserOpen(), "The browser is not open!");
    }
    @When("user email {string} with password {string} is used")
    public void user_email_with_password_is_used(String email, String password) {
        logInAndSignInPage.consent();
        logInAndSignInPage.fillLogInForm(email, password);
    }
    @Then("the log in fails")
    public void the_log_in_fails() {
        Assertions.assertTrue(logInAndSignInPage.isErrorRegistered(), "No error was registered after the login attempt.");
    }

    @Then("the log in is successful")
    public void the_log_in_is_successful() {
        Assertions.assertTrue(!logInAndSignInPage.isErrorRegistered(), "Error was registered and the login failed.");
    }
}
