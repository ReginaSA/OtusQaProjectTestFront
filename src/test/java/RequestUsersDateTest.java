
import entities.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.*;
import service.UserApi;

import static qa.stub.helpers.Helpers.buildRequest;
import static qa.stub.helpers.Helpers.executeGetRequest;

public class RequestUsersDateTest {

    private long userId = 68;

    /**
     * Тест запрашивает массив объектов /users/get/all
     * и проверяет на соответствие данных ответа json схеме
     */
    @Test
    public void getAllUsers(){
        String url = "http://localhost:8080/users/get/all";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);
        response.then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/AllUsers.json"));
    }

    /**
     * Тест получения опльзователя по id
     * и проверка ответа json схеме
     */
    @Test
    public void getUserById() {
        User newUser = User.builder()
                .id(userId)
                .build();

        UserApi userApi = new UserApi();
        userApi.getUser(newUser)
                .then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/User.json"));
    }
}
