Feature: Orbitz Search

  @asad @orbitz-ui
  Scenario: Orbitz Search Results
    Given I go to Orbitz
    When I select flight tab and multi city option
    When I Search for 2 adults and 2 children with ages
    When I select route using three flight destinations
    When I select travel dates for each flight
    When I search with the selected criteria
    Then I verify results select flights and validate itinerary