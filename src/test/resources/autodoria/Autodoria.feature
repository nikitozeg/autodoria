Feature: Wiki Rest API test

  Background:
    And Web service is disconnected

  Scenario:  Redirecting to WIKI search result page
    When Web service is connected
    And Search request is executed with value hores
    Then Redirecting to search result page

  Scenario:  Redirecting to WIKI page content
    When Web service is connected
    And Search request is executed with value horse
    Then Redirecting to "Horse" page

