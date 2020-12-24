package steps;

import beans.PostUserRequest;
import beans.PostUserResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;
import utilities.Config;
import static io.restassured.RestAssured.*;


public class postAPISteps {
    RequestSpecification request;
    Response response;
    String url = Config.getProperty("apiURL");
    @Given("Content type and Accept type is Json")
    public void content_type_and_Accept_type_is_Json() {
        request = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON);
    }

    @When("I post a new user with {string} name and {string} job")
    public void i_post_a_new_user_with_name_and_job(String name, String job) {
        PostUserRequest postRequest = new PostUserRequest();
        postRequest.setJob(name);
        postRequest.setJob(job);

        response = request.and().body(postRequest).when().post(url);
    }

    @Then("Verify that Status code is {int}")
    public void verify_that_Status_code_is(int statusCode) {
        assertEquals(response.getStatusCode(),statusCode);
    }

    @Then("Verify that the id and created date is not null")
    public void verify_that_the_id_and_created_date_is_not_null() {
        PostUserResponse postResponse = response.body().as(PostUserResponse.class);
        assertNotEquals(postResponse.getId(),null);
        assertNotEquals(postResponse.getCreatedAt(),null);
        System.out.println(response.getStatusCode());
        System.out.println(postResponse.getId());

    }
}
