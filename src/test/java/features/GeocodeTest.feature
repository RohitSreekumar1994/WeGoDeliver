@Geocode
@GeocodeCoordinatesTest
Feature: To test if the user is returned with the right coordinates when an address is sent

  Scenario: Geocode Test - Validate Coordinates

    Given user sends a request with the below details
      | endPoint    | https://geocode.search.hereapi.com/v1/geocode |
      | city        | Berlin                                        |
      | country     | Germany                                       |
      | street      | Genterstr                                     |
      | houseNumber | 53                                            |

    Then the response code returned is "200"
    And the position coordinates returned are
      | lat | 52.54755 |
      | lng | 13.35286 |

