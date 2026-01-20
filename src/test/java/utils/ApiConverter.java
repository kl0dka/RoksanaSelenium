package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiConverter {

    public static final double OUNCE_IN_GRAMS = 31.1034768;

    public static double usdToPlnRate(double usdValue) {
        Response response = RestAssured.given()
                .baseUri("https://api.nbp.pl/api")
                .header("Accept", "application/json")
                .relaxedHTTPSValidation()
                .get("/exchangerates/rates/a/usd/today/");
        double rate = response.jsonPath().getDouble("rates.mid[0]");
        return usdValue * rate;
    }

    public static double convertGramToOuncePrice() {
        Response response = RestAssured.given()
                .baseUri("https://api.nbp.pl/api")
                .header("Accept", "application/json")
                .relaxedHTTPSValidation()
                .get("/cenyzlota");
        double price = response.jsonPath().getDouble("cena[0]");

        return price * OUNCE_IN_GRAMS;
    }
}
