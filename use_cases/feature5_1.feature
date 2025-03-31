Feature: Billing System
  In order to analyze revenue and track business performance
  As a system administrator
  I want to generate invoices and financial reports

  Background:
    Given the system contains valid billing and transaction data

  @generateReports
  Scenario: Generate financial reports
    Given I am logged in as a system administrator
    When I request a financial report for a specific time period
    Then the system should generate a financial report that includes:
      | data point           |
      | total revenue        |
      | total expenses       |
      | net profit           |
      | outstanding invoices |
    And I should be able to download or view the report
    And I should see a summary that helps track business performance

  @generateInvoices
  Scenario: Generate invoices
    Given I am logged in as a system administrator
    And there are pending charges for customers
    When I select the option to generate invoices
    Then invoices should be created for all unpaid charges
    And each invoice should include:
      | invoice number |
      | customer name  |
      | amount due     |
      | due date       |
    And the invoices should be ready for distribution via email or print

  @reportFiltering
  Scenario: Filter financial reports by date range
    Given I am logged in as a system administrator
    And I have access to a date range filter
    When I select a start date of "2025-01-01" and an end date of "2025-01-31"
    Then the system should display a financial report for the selected period
    And the report should only include transactions within that date range

  @reportAnalysis
  Scenario: Analyze revenue trends
    Given I have a generated financial report
    When I view the report’s summary
    Then I should see monthly revenue trends
    And I should be able to identify increases or decreases compared to the previous month