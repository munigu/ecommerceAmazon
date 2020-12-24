package steps;

import beans.Data;
import beans.GetUserResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;
import utilities.Config;
import static io.restassured.RestAssured.*;

public class getAPISteps {
    RequestSpecification request;
    Response response;
    String url = Config.getProperty("apiURL");

    @Given("Accept type is Json")
    public void accept_type_is_Json() {
        request = given().accept(ContentType.JSON);
    }

    @When("I send a Get request with id number {int}")
    public void i_send_a_Get_request_with_id_number(int id) {
        response = request.and().when().get(url+"/"+id);
    }

    @Then("Status code should be  {int}")
    public void status_code_should_be(int statusCode) {
        assertEquals(response.getStatusCode(),statusCode);
        System.out.println(response.getStatusCode());
    }

    @Then("User JSON Response data should match the posted data")
    public void user_JSON_Response_data_should_match_the_posted_data() {
        Data data = new Data();
        data.setId(2);
        data.setFirst_name("Janet");
        data.setLast_name("Weaver");
        data.setEmail("janet.weaver@reqres.in");
        data.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");

        GetUserResponse getResponse = response.body().as(GetUserResponse.class);

        assertEquals(data.getId(),getResponse.getData().getId());
        assertEquals(data.getEmail(),getResponse.getData().getEmail());
        assertEquals(data.getAvatar(),getResponse.getData().getAvatar());
        assertEquals(data.getFirst_name(),getResponse.getData().getFirst_name());
        assertEquals(data.getLast_name(),getResponse.getData().getLast_name());
    }
}
