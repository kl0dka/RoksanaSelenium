package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SurowcePage extends BasePage {
    By goldElement = By.xpath("//div[contains(@title, 'Złoto')]//div//span[contains(@class, 'a-quote-item -value')]");
    By goldElementCard = By.xpath("//div[contains(@title, 'Złoto')]");
    By surowceTab = By.xpath("//li[text() = 'Surowce']");

    public SurowcePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public boolean isPageVisible() {
        return find(surowceTab).isDisplayed();
    }

    public boolean isGoldElementVisible() {
        return find(goldElementCard).isDisplayed();
    }

    public double getGoldValue() {
        String goldValue = find(goldElement).getText();
        String cleanTextValue = goldValue.replace(" ", "").replace(",", ".");
        return Double.parseDouble(cleanTextValue);
    }
}
