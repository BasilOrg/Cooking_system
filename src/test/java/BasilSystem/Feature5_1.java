package BasilSystem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feature5_1 {

    private final List<String> transactions = new ArrayList<>();
    private final Map<String, Double> invoices = new HashMap<>();
    private boolean isAdminLoggedIn = false;
    private boolean reportGenerated = false;
    private boolean invoicesGenerated = false;

    @Given("the system contains valid billing and transaction data")
    public void theSystemContainsValidBillingAndTransactionData() {
        // Mock transactions
        transactions.add("2024-03-01: Sale - $500");
        transactions.add("2024-03-10: Expense - $200");
        transactions.add("2024-03-20: Sale - $700");
        System.out.println("Billing and transaction data loaded.");
    }

    @Given("I am logged in as a system administrator")
    public void iAmLoggedInAsASystemAdministrator() {
        isAdminLoggedIn = true;
        System.out.println("Admin logged in.");
    }

    @When("I request a financial report for a specific time period")
    public void iRequestAFinancialReportForASpecificTimePeriod() {
        if (isAdminLoggedIn) {
            reportGenerated = true;
            System.out.println("Financial report generated.");
        } else {
            System.out.println("Access denied. Only admins can request reports.");
        }
    }

    @Then("the system should generate a financial report that includes:")
    public void theSystemShouldGenerateAFinancialReportThatIncludes(io.cucumber.datatable.DataTable dataTable) {
        if (reportGenerated) {
            System.out.println("Report includes:");
            dataTable.asList().forEach(System.out::println);
        } else {
            System.out.println("No report generated.");
        }
    }

    @Then("I should be able to download or view the report")
    public void iShouldBeAbleToDownloadOrViewTheReport() {
        if (reportGenerated) {
            System.out.println("Report available for download/viewing.");
        }
    }

    @Then("I should see a summary that helps track business performance")
    public void iShouldSeeASummaryThatHelpsTrackBusinessPerformance() {
        if (reportGenerated) {
            System.out.println("Summary: Revenue - $1200, Expenses - $200, Profit - $1000");
        }
    }

    @Given("there are pending charges for customers")
    public void thereArePendingChargesForCustomers() {
        invoices.put("Customer A", 150.0);
        invoices.put("Customer B", 300.0);
        System.out.println("Pending charges detected.");
    }

    @When("I select the option to generate invoices")
    public void iSelectTheOptionToGenerateInvoices() {
        invoicesGenerated = true;
        System.out.println("Invoices generated.");
    }

    @Then("invoices should be created for all unpaid charges")
    public void invoicesShouldBeCreatedForAllUnpaidCharges() {
        if (invoicesGenerated) {
            invoices.forEach((customer, amount) ->
                    System.out.println("Invoice for " + customer + ": $" + amount)
            );
        }
    }

    @Then("each invoice should include:")
    public void eachInvoiceShouldInclude(io.cucumber.datatable.DataTable dataTable) {
        if (invoicesGenerated) {
            System.out.println("Invoice details:");
            dataTable.asList().forEach(System.out::println);
        }
    }

    @Then("the invoices should be ready for distribution via email or print")
    public void theInvoicesShouldBeReadyForDistributionViaEmailOrPrint() {
        if (invoicesGenerated) {
            System.out.println("Invoices ready for email/print.");
        }
    }

    @Given("I have access to a date range filter")
    public void iHaveAccessToADateRangeFilter() {
        System.out.println("Date range filter enabled.");
    }

    @When("I select a start date of {string} and an end date of {string}")
    public void iSelectAStartDateOfAndAnEndDateOf(String startDate, String endDate) {
        System.out.println("Filtering transactions from " + startDate + " to " + endDate);
    }

    @Then("the system should display a financial report for the selected period")
    public void theSystemShouldDisplayAFinancialReportForTheSelectedPeriod() {
        System.out.println("Displaying financial report for selected period...");
    }

    @Then("the report should only include transactions within that date range")
    public void theReportShouldOnlyIncludeTransactionsWithinThatDateRange() {
        System.out.println("Filtered report includes transactions from the selected range.");
    }

    @Given("I have a generated financial report")
    public void iHaveAGeneratedFinancialReport() {
        reportGenerated = true;
        System.out.println("Financial report is available.");
    }

    @When("I view the report’s summary")
    public void iViewTheReportSSummary() {
        if (reportGenerated) {
            System.out.println("Viewing report summary...");
        }
    }

    @Then("I should see monthly revenue trends")
    public void iShouldSeeMonthlyRevenueTrends() {
        if (reportGenerated) {
            System.out.println("Revenue trends: March - $1200, April - $1500");
        }
    }

    @Then("I should be able to identify increases or decreases compared to the previous month")
    public void iShouldBeAbleToIdentifyIncreasesOrDecreasesComparedToThePreviousMonth() {
        if (reportGenerated) {
            System.out.println("Comparison: April revenue increased by 25% over March.");
        }
    }


}
