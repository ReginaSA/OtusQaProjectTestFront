
import entities.User;
import io.qameta.allure.Description;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.*;
import service.UserApi;

import static com.codeborne.selenide.Configuration.baseUrl;
import static helpers.Helpers.buildRequest;
import static helpers.Helpers.executeGetRequest;

public class RequestUsersDateTest {

    private long userId = 68;

    /**
     * Тест запрашивает массив объектов /users/get/all
     * и проверяет на соответствие данных ответа json схеме
     */
    @Test
    @Description("Запрашиваем массив объектов /users/get/all и проверяеем на соответствие данных ответа json схеме")
    public void getAllUsersCheckJsonSchema(){
        String url = baseUrl + "/users/get/all";
        RequestSpecification request = buildRequest();
        Response response =
                executeGetRequest(request, url);
        response.then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/AllUsers.json"));
    }

    @Test
    @Description("Получаем пользователя по id и проверяеем на соответствие данных ответа json схеме")
    public void getUserById() {
        User newUser = User.builder()
                .id(userId)
                .build();

        UserApi userApi = new UserApi();
        userApi.getUserById(newUser)
                .then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/User.json"));
    }
}
