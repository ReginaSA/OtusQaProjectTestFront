
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.*;
import static qa.stub.helpers.Helpers.buildRequest;
import static qa.stub.helpers.Helpers.executeGetRequest;

public class TestUser {

    @Test
    public void GetAllCoursesSchemaTest(){

        String url = "http://localhost:3000/users/get/all";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);
        response.then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Users.json"));
    }

}
