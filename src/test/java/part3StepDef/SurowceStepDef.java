package part3StepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ApiConverter;

import static org.testng.AssertJUnit.assertEquals;

public class SurowceStepDef {
    private double actualGoldValueFromSite;
    private double expectedGoldValue;

    @Given("I have accepted the cookies on homepage")
    public void accept_the_cookies() {
        BaseTest.homePage.acceptCookiesButton();
    }

    @When("I have entered the Surowce page")
    public void enter_the_surowce_page() {
        BaseTest.homePage.goToSurowce();
    }

    @And("I read the gold value on the page and converted it from USD to PLN")
    public void read_the_gold_value_and_convert_from_Usd_to_Pln() {
        double goldValueFromSite = BaseTest.surowcePage.getGoldValue();
        actualGoldValueFromSite = ApiConverter.usdToPlnRate(goldValueFromSite);
    }

    @And("I convert the price of gram from NBP API to ounce price")
    public void convert_gram_price_to_ounce_price() {
        expectedGoldValue = ApiConverter.convertGramToOuncePrice();
    }

    @Then("The converted values should match within a 10% tolerance")
    public void values_should_match_within_a_tolerance() {
        double tolerance = expectedGoldValue * 0.10;
        assertEquals(actualGoldValueFromSite, expectedGoldValue, tolerance);
    }
}