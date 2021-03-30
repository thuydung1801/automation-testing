Feature: As a user, I write a demo script

  @test01
  Scenario: go to sign in/ sign up page
    Given Go to "glgbHomePage" url
    When Click Sign In/ Sign Up button
    And  Wait about 1 seconds
    Then Successfully into signInPage front site

