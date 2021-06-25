@CreateOrder
@CreateOrderImport
Feature: To test if the user is able to create orders by Importing the CSV file

  Scenario: Create Order - Import CSV

    Given the user is navigated to the webpage
    When user enters the depot name as "Pankstrasse, 13357 Berlin, Germany"
    And navigates to Add Orders Page
    Then the Add Orders page is opened

    When user selects "Import" add orders option
    Then user uploads the file "Tour_WeGo Deliver_test.csv"
    And plans the order
    Then the tour details are available