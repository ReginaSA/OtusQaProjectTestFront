package service;

import entities.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserApi {
    private static final String BASE_URI = "http://localhost:8080/";
    private static final String USER = "/users/get";
    private final RequestSpecification spec;

    public UserApi() {
        spec = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON);
    }

    public Response getUserById(User user) {
        return
                given(spec)
                        .log().all()
                        .when()
                        .get(USER + "/" + user.getId());
    }
}
