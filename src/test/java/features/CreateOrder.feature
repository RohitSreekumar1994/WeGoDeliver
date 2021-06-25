@CreateOrder
@CreateOrderManual
Feature: To test if the user is able to create orders

  Scenario: Create Order Manual Test

    Given the user is navigated to the webpage
    When user enters the depot name as "Pankstrasse, 13357 Berlin, Germany"
    And navigates to Add Orders Page
    Then the Add Orders page is opened

    When user selects "Manual" add orders option
    And adds orders with the below values
      | Name1    | Robert                                  |
      | Address1 | U-Bahn-Naturkundemuseum                 |
      | Phone1   | 123456789                               |
      | Name2    | Thomas                                  |
      | Address2 | Alexanderstrasse, 10178 Berlin, Germany |
      | Phone2   | 123456789                               |
      | Name3    | Daniel                                  |
      | Address3 | Turmstrasse, 10551 Berlin, Germany      |
      | Phone3   | 123456789                               |

    And plans the order
    Then the tour details are available












