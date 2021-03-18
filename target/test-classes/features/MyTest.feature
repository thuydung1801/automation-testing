Feature: As a user, i want to login into the Mektoube

  @test01
  Scenario: login successfully
    Given Go to 'https://mektoube.fr/login' url
    When Insert 'yassine_yes' into the Email field
    When Insert 'Mektoubi2017' into the Password field
    When Click login button
    Then User login successfully into 'https://mektoube.fr/main/discoveries' front site

  @test02
  Scenario: login fail with incorrect email
    Given Go to 'https://mektoube.fr/login' url
    When Insert 'yassine_yes3' into the Email field
    When Insert 'Mektoubi2017' into the Password field
    When Click login button
    Then Show error-box

  @test03
  Scenario: login fail with incorrect email
    Given Go to 'https://mektoube.fr/login' url
    When Insert 'yassine_yes' into the Email field
    When Insert 'Mektoubi2018' into the Password field
    When Click login button
    Then Show error-box


