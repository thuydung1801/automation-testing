Feature: As a user, i forgot my passwword, i want to reset my password

  @test01
  Scenario: forgot the password
    Given Go to 'https://mektoube.fr/login' url
    When Click forgot password button
    Then User go to successfully into 'https://mektoube.fr/forgot-password' front site