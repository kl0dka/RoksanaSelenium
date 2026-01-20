package base;

import org.example.pages.BasePage;
import org.example.pages.HomePage;
import org.example.pages.RawMaterialsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected BasePage basePage;
    protected HomePage homePage;
    protected RawMaterialsPage rawMaterialsPage;
    private String url = "https://www.bankier.pl/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        basePage = new BasePage(driver, wait, actions);
        homePage = new HomePage(driver, wait, actions);
        rawMaterialsPage = new RawMaterialsPage(driver, wait, actions);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
