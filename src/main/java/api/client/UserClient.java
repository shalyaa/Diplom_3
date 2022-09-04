package api.client;

import api.model.User;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_ACCEPTED;

public class UserClient {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api";

    public static RequestSpecification getRecSpec() {
        return new RequestSpecBuilder().log(LogDetail.ALL)
                .setContentType(ContentType.JSON).setBaseUri(BASE_URL).build();
    }

    @Step("Создание пользователя")
    public static Response createUser(User user) {
        return given()
                .spec(getRecSpec())
                .body(user)
                .when()
                .post(BASE_URL + "/auth/register");
    }

    @Step("Авторизация пользователя")
    public static Response authUser(User user) {
        return given()
                .spec(getRecSpec())
                .body(user)
                .when()
                .post(BASE_URL + "/auth/login");
    }

    @Step("Удаление пользователя")
    public static void deleteUser(String accessToken) {
        given()
                .spec(getRecSpec())
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/auth/user")
                .then()
                .assertThat()
                .statusCode(SC_ACCEPTED);
    }

    @Step("Получение токена пользователя")
    public static String getAccessToken(Response response) {
        return response
                .body()
                .jsonPath()
                .getString("accessToken");
    }
}
