# language: en
# ------------------------------------------------------------------------------
Feature: The snippets service allows management of code snippets

  As a developer I need to manage code snippets

  Scenario: List a snippet
    When client requests GET /snippets/1
    Then the response is a snippet with id 1

#  Scenario: List all snippets
#    Given the system has snippets
#    When client requests GET /snippets
#    Then I will get back all snippets
