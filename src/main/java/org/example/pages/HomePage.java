package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {
    By navBarElementRynki = By.xpath("//span[text()='Rynki']");
    By listElementSurowce = By.xpath("//a[text() = 'Surowce']/parent::li//a[contains(@class, 'm-menu-list__anchor')]");
    By cookiesAcceptButton = By.id("didomi-notice-agree-button");

    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void acceptCookiesButton() {
        click(cookiesAcceptButton);
    }

    public void goToRawMaterials() {
        hoverElement(navBarElementRynki);
        click(listElementSurowce);
    }
}
