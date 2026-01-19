package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--load-extension=src/test/extensions/AdBl");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.bankier.pl/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldDisplayTheValueOfGold() {
        WebElement cookiesAcceptButton = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.id("didomi-notice-agree-button")));
        cookiesAcceptButton.click();

        WebElement navElementRynki = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//span[text()='Rynki']")));
        actions.moveToElement(navElementRynki).build().perform();

        WebElement listElementSurowce = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[text() = 'Surowce']/parent::li//a[contains(@class, 'm-menu-list__anchor')]")));
        listElementSurowce.click();

        WebElement goldElement = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Złoto')]//div//span[contains(@class, 'a-quote-item -value')]")));
        String goldElementValue = goldElement.getText();

        System.out.println(goldElementValue);
    }
}