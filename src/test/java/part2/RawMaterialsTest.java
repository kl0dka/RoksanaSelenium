package part2;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.ApiConverter;

import static org.testng.AssertJUnit.assertEquals;

public class RawMaterialsTest extends BaseTest {

    @Test
    public void shouldDisplayCorrectValueOfGold() {
        homePage.acceptCookiesButton();
        homePage.goToRawMaterials();
        double goldValueFromSite = rawMaterialsPage.getGoldValue();
        double actual = ApiConverter.usdToPlnRate(goldValueFromSite);
        double expected = ApiConverter.convertGramToOuncePrice();
        double tolerance = expected * 0.10;
        assertEquals(actual, expected, tolerance);
    }
}
