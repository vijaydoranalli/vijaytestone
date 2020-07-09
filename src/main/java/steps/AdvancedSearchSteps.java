package steps;

import context.WebDriverContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdvancedSearchSteps {
    private WebDriver driver = WebDriverContext.getWebDriver();

    @Given("^I am on the Totaljobs homepage$")
    public void navigateToTheAdvancedSearchPage() throws InterruptedException {
        System.out.println("User is on the Totaljobs homepage");
        driver.get("https://www.totaljobs.com");
        Thread.sleep(5000);


    }



    @When("^I make a search with details$")
    public void i_make_a_search_with_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is entering values and searching");

        WebElement searchQueryTopTxtBox = driver.findElement(By.xpath("//input[@id='keywords']"));
        searchQueryTopTxtBox.sendKeys("Test");

        WebElement searchQueryTopTxtBox2 = driver.findElement(By.xpath("//input[@id='location']"));
        searchQueryTopTxtBox2.sendKeys("London");

        WebElement searchQueryTopTxtBox3 = driver.findElement(By.xpath("//input[@id='search-button']"));
        searchQueryTopTxtBox3.click();

    }

    @Then("^I am shown job results$")
    public void i_am_shown_job_results() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is on the Job results Page");
     //   throw new PendingException();

            WebElement results = driver.findElement(By.id("location"));
            System.out.println( "Location value present ="+results.getAttribute("Value"));

           assertTrue(results.getAttribute("Value").contains("London"));
    }


}
