package steps;

import beans.People;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Config;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class postBlobSteps {

    RequestSpecification request;
    Response response;
    String url = Config.getProperty("blobAPI");

    @Given("Content type and Accept type is application\\/json")
    public void content_type_and_Accept_type_is_application_json() {
        request = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON);
    }

    @When("User hits the end point")
    public void user_hits_the_end_point() {
        List<String> names = new ArrayList<>();
        names.add("bill");
        names.add("steve");
        names.add("bob");

        People people = new People();
        people.setName(names);

        response = request.and().body(names).when().post(url);
    }

    @Then("Status code should be {int}")
    public void status_code_should_be(int int1) {
        assertEquals(response.getStatusCode(), int1);
        System.out.println(response.getBody());
    }
}
