package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInAndSignInPage extends BasePage {
    @FindBy(id = "username")
    private WebElement loginUsername;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")
    private WebElement loginButton;

    @FindBy(id = "reg_email")
    private WebElement registrationEmail;

    @FindBy(id = "reg_password")
    private WebElement registrationPassword;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")
    private WebElement registrationButton;

    private WebDriver webDriver;

    public LogInAndSignInPage(WebDriver webDriver, String pageUrl) {
        super(webDriver, pageUrl);
        super.load();
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void fillLogInForm(String email, String password) {
        loginUsername.sendKeys(email);
        loginPassword.sendKeys(password);
        loginButton.click();
    }

    public void fillSignInForm(String email, String password) {
        registrationEmail.sendKeys(email);
        registrationPassword.sendKeys(password);
        registrationButton.click();
    }

    public boolean isErrorRegistered() {
        return webDriver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/ul/li/strong")).size() > 0;
    }
}
