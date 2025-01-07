package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends LoadableComponent {
    private final int durationToWait = 5;
    public WebDriver webDriver;
    private String pageUrl;
    public BasePage(WebDriver webDriver, String pageUrl) {
        this.webDriver = webDriver;
        this.pageUrl = pageUrl;
    }

    @Override
    protected void load() {
        webDriver.get(pageUrl);
    }

    @Override
    protected void isLoaded() {
        String realUrl = webDriver.getCurrentUrl().trim();
        if(realUrl.equalsIgnoreCase(pageUrl)) {
            throw new Error("The page was not loaded correctly!");
        }
    }

    public boolean isBrowserOpen() {
        boolean browserIsOpen;
        try {
            webDriver.getWindowHandles();
            browserIsOpen = true;
        } catch (NullPointerException e) {
            browserIsOpen = false;
        }
        return  browserIsOpen;
    }

    public void consent() {
        final String optionsFormClassName = "fc-consent-root";
        final String consentButtonClassName = "fc-primary-button";
        WebElement formClass = webDriver.findElement(By.className(optionsFormClassName));
        WebElement consentFormClassButton = formClass.findElement(By.className(consentButtonClassName));
        consentFormClassButton.click();
    }
    public void doNotConsent() {
        final String optionsFormClassName = "fc-consent-root";
        final String doNotConsentButtonClassName = "fc-secondary-button";
        WebElement formClass = webDriver.findElement(By.className(optionsFormClassName));
        WebElement consentFormClassButton = formClass.findElement(By.className(doNotConsentButtonClassName));
        consentFormClassButton.click();
    }
}
