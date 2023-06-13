Feature: Trip to India booking

  Scenario Outline: Title verification and India trip booking for 2 adults
    Given User goes into the given page
    Then User sees "expectedTitle" on page title
    Then User clicks cookies button
    When User searches for India in search bar
#    When User clicks 1 book online button
#    Then User can not see message to the User "<messageToTheUser>"
    When User selects available date
    When User selects "2" Adults
    Then User sees the total price
    Then User clicks 2 book online button
    When User clicks on section for Date, Departure & Passengers
    Then User sees quantity "<quantity>" for number of Adults
    Then User sees departure airport "<displayedDepartureAirport>"
    Then User sees departure date
    When User clicks on section for Accommodation details
    When User selects twin room
    Then User clicks on "SELECT YOUR ROOMS AND CONTINUE"
    And User selects first "<title>" on Passenger Details field
    And User types First Name on Adult 1
    And User types Last Name on Adult 1
    And User selects DOB on Adult 1
    When User selects second "<title2>" on Passenger Details field
    And User types First Name on Adult 2
    And User types Last Name on Adult 2
    And User selects DOB on Adult 2
    When User types contact name, phone number and email address
    And User types addresses, city and postcode
    And User selects "<country>" on the form
    When User selects the option from the list for "<hear-about>" info
    And User clicks on "Continue" button
    Then User sees confirmation details "<confirmDetails>"
    Then User clicks "Book Now" button


    Examples:
      | messageToTheUser                  | quantity | displayedDepartureAirport | title | title2 | country | hear-about | confirmDetails         |
      | Please select your departure date | 2        | London Heathrow (LHR)     | Mr    | Mrs    | GB      | 2          | Confirm Details + Book |


