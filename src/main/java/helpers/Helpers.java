package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Класс с вспомогательными методами
 */
public class Helpers {

    /**
     * Метод для формирования заголовка и тела запроса
     *
     * @param msgBody тело сообщения в виде строки
     * @return получившийся запрос
     */
    public static RequestSpecification buildRequest(String msgBody) {
        RequestSpecification request = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(msgBody);
        return request;
    }

    /**
     * Метод для формирования заголовка и тела запроса
     *
     * @return получившийся запрос
     */
    public static RequestSpecification buildRequest() {
        RequestSpecification request = RestAssured
                .given();
        request.header("Content-Type", "application/json");
        return request;
    }

    /**
     * Метод для выполнения GET запроса
     *
     * @param request  объект типа RequestSpecification с сформированным запросом
     * @param resource ресурс API, к которому выполняем запрос
     * @return ответ типа Response от сервера
     */
    public static Response executeGetRequest(RequestSpecification request, String resource) {
        return request
                .when().log().all()
                .get(resource)
                .then().log().all().extract().response();
    }


}
