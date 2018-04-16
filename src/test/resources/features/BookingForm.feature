Feature: Booking form

  Scenario: User can access the booking form
    Given I am a user
    When I navigate to the homepage
    Then I see the booking homepage

  Scenario: User can add a booking
    Given I am on the booking form home page
    When I enter a new booking
    Then I should see the booking added to the list of bookings

  Scenario: User can delete a booking
    Given I am on the booking form home page
    When I delete the booking
    Then I should see the booking removed from the list of bookings

  Scenario Outline: User can't add a booking if there is missing information
    Given I am on the booking form home page
    When I enter a new booking with missing data in the <field> field
    Then I should not see the booking added to the booking form

    Examples:
      | field      |
      | first name |
      | surname    |
      | price      |