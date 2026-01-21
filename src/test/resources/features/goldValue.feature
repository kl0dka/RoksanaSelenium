Feature: Comparing the gold value with the Nbp API

  The user should be able to open the "Rynki" list  on the homepage, select the "Surowce" link and
  navigate to the selected page.
  On the /surowce page, under the Gold tab, the user should see current gold value, matching current
  gold value per ounce provided by the Nbp API.

  Background:
    Given I have accepted the cookies on homepage

  Scenario: Successful matching the gold values from site and from Nbp API
    When I have entered the Surowce page
    And I read the gold value on the page and converted it from USD to PLN
    And I convert the price of gram from NBP API to ounce price

    Then The converted values should match within a 10% tolerance