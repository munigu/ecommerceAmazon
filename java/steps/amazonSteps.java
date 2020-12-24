package steps;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.AmazonHomePage;
import utilities.Config;
import utilities.Driver;

public class amazonSteps {

    AmazonHomePage amazonHomePage = new AmazonHomePage();

    @Given("User is on Amazon Homepage")
    public void user_is_on_Amazon_Homepage() {
        Driver.getDriver().get(Config.getProperty("amazonURL"));
    }

    @When("User enters {string} in the search box")
    public void user_enters_in_the_search_box(String string) {
            amazonHomePage.searchBox.sendKeys(string);
    }

    @When("User clicks search button")
    public void user_clicks_search_button() {
        amazonHomePage.searchButton.click();
    }

    @When("User clicks on item")
    public void user_clicks_on_item() {
        if (amazonHomePage.allItems.size() > 0) {
            for (int i = 0 ; i < amazonHomePage.allItems.size(); i++){
                if (amazonHomePage.allItems.get(i).getText().contains("Space Gray") && amazonHomePage.allItems.get(i).getText().contains("US English")){
                    amazonHomePage.allItems.get(i).click();
                } else {
                    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                    js.executeScript("window.scrollBy(0,100)");
                }
            }
        } else {
            for (int i = 0 ; i < amazonHomePage.allItems1.size(); i++){
                if (amazonHomePage.allItems1.get(i).getText().contains("Space Gray") && amazonHomePage.allItems1.get(i).getText().contains("US English")){
                    amazonHomePage.allItems1.get(i).click();
                } else {
                    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                    js.executeScript("window.scrollBy(0,100)");
                }
            }
        }

    }

    @When("User verifies item in stock")
    public void user_verifies_item_in_stock() {
        String text = amazonHomePage.inStock.getText();
        Assert.assertEquals(text,"In Stock.");
    }

    @When("User verifies rating of item")
    public void user_verifies_rating_of_item() {
        String ratingText = amazonHomePage.rating.getText();
        System.out.println(ratingText);
    }

    @When("User clicks on add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        amazonHomePage.addToCartButton.click();
    }

    @When("User closes pop up")
    public void user_closes_pop_up() {
        amazonHomePage.popUpClose.click();
    }

    @When("User clicks on cart")
    public void user_clicks_on_cart() {
        amazonHomePage.cart.click();
    }

    @Then("User verifies subtotal cost of item")
    public void user_verifies_subtotal_cost_of_item() {
        String subtotal_cost = amazonHomePage.subtotalCost.getText();
        System.out.println(subtotal_cost);
    }

    @After()
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
        Driver.getDriver().close();
    }
}
