Feature: User Rest API requests

  @get
  Scenario: Get user info
    Given Accept type is Json
    When I send a Get request with id number 2
    Then Status code should be  200
    And User JSON Response data should match the posted data