Feature: news details

  Scenario: printing the news
    Given the news block is displayed
    When print count of total no of news
    And print the headers of all news displayed

  Scenario: checking for each news and there content
    Given all the news is displayed and there related info
    When clicking the news one by one
    Then validating the data is relevent to the link clicked

  Scenario: checking the news headline with it's tooltip
    Given all the news are displayed
    When on mouse hover the tooltip appears
    Then validate each tooltip with it's headline
