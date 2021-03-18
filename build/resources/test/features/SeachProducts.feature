Feature: I want to search products in Glamira

  @test01
  Scenario: Search successfully
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/' url
    When Insert key to block Search : 'Ring'
    When click search button
    Then Successfully into 'https://test.glamira2.just4demo.biz/glgb/catalogsearch/result/?q=Ring' front site
  @test02
  Scenario: check the link to the result
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/' url
    When Insert key to block Search : 'desktop'
    When click search button
    Then Go to link: HOME /'SEARCH RESULTS FOR: 'DESKTOP''
  @test03
  Scenario: Search key with length < 3
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/' url
    When Insert key to block Search : 'rg'
    When click search button
    Then Show messages for search: 'Minimum Search query length is 3'
  @test04
  Scenario: Search for products not in the database
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/' url
    When Insert key to block Search : 'desktop'
    When click search button
    Then Show messages for search: 'Your search returned no results.'
  @test05
  Scenario: Search successfully
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/' url
    When Insert key to block Search and press down 4 time : 'Ring'
    When click search button
    Then Successfully into 'https://test.glamira2.just4demo.biz/glgb/silverrings/' front site
