
  Feature: Opening New Saving Account Feature

    @saving
    Scenario: Opening New Saving Account
      Given User is on TNB Home Page
      When User hovers over Open New Account
      And User clicks The New Saving Account
      Then User should be redirected to New Business Account page in new window
      When User enters Firstname and Lastname
      And User enters Email and Business Name
      And User enters Business Type and Business Address
      And User enters Tax ID and Selected Business State
      When User clicks Submit Button
      Then User should see success message on alert and accepts
      Then User should be redirected to Home Page