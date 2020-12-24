Feature: Blob Rest API Post request

  @postBlob
  Scenario: Create Blob
    Given Content type and Accept type is application/json
    When User hits the end point
    Then Status code should be 201