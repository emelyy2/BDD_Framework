
  Feature: Login Test Feature

    @login
     Scenario:  Login Test 01
       Given User navigates to TNB login page
       When User enters username as "admin"
       And User enters password as "password"
       And User clicks Login Button
       Then User should successfully login