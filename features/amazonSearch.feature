@regression
Feature: Amazon search feature

  @amazon
  Scenario: Amazon apple keyboard verification using search feature
    Given User is on Amazon Homepage
    When User enters "Apple Magic Keyboard with Numeric Keypad(Wireless, Rechargable ) (US English) - Space Gray" in the search box
    And User clicks search button
    And User clicks on item
    And User verifies item in stock
    And User verifies rating of item
    And User clicks on add to cart button
    And User closes pop up
    And User clicks on cart
    Then User verifies subtotal cost of item

    @amazon1
    Scenario: Amazon apple keyboard verification with partial search
      Given User is on Amazon Homepage
      When User enters "US English - Space Gray" in the search box
      And User clicks search button
      And User clicks on item
      And User verifies item in stock
      And User verifies rating of item
      And User clicks on add to cart button
      And User closes pop up
      And User clicks on cart
      Then User verifies subtotal cost of item

      @amazon2
      Scenario: Amazon apple keyboard verification with partial search using different keys
        Given User is on Amazon Homepage
        When User enters "Apple Magic  Numeric - Space Gray" in the search box
        And User clicks search button
        And User clicks on item
        And User verifies item in stock
        And User verifies rating of item
        And User clicks on add to cart button
        And User closes pop up
        And User clicks on cart
        Then User verifies subtotal cost of item

        @amazon3
        Scenario: Amazon apple keyboard verification with partial search and leaving space between keys
          Given User is on Amazon Homepage
          When User enters "Apple Magic  Numeric     US English" in the search box
          And User clicks search button
          And User clicks on item
          And User verifies item in stock
          And User verifies rating of item
          And User clicks on add to cart button
          And User closes pop up
          And User clicks on cart
          Then User verifies subtotal cost of item



