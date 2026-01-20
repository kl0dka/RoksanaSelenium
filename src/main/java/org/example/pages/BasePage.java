package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.wait = wait;
        this.driver = driver;
        this.actions = actions;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.
                visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        find(locator).click();
    }

    public void hoverElement(By locator) {
        WebElement element = find(locator);
        actions.moveToElement(element).build().perform();
    }
}
