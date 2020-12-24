Feature: User Rest API requests

  @post
  Scenario: Create user
    Given Content type and Accept type is Json
    When I post a new user with "ibrahim" name and "java" job
    Then Verify that Status code is 201
    And Verify that the id and created date is not null
