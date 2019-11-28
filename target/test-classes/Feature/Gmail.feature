Feature: Sending Message to 10 users

  Scenario:Gmail Mail sending
    Given User is in Gmail
    When User enters mail and click next
    And User enters password and click next
    
    When User eneters Recepient address
      | gurava.tumu@gmail.com | guravareddy786@gmail.com |gurava.tumu@gmail.com|
      
   
