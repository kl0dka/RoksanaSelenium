package part3StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.pages.BasePage;
import org.example.pages.HomePage;
import org.example.pages.SurowcePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static Actions actions;
    public static WebDriverWait wait;
    public static BasePage basePage;
    public static HomePage homePage;
    public static SurowcePage surowcePage;
    private String url = "https://www.bankier.pl/";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        basePage = new BasePage(driver, wait, actions);
        homePage = new HomePage(driver, wait, actions);
        surowcePage = new SurowcePage(driver, wait, actions);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
