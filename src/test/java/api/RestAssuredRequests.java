package api;

import configuration.LoadFromProperty;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import models.User;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.util.HashMap;
import java.util.Map;

public class RestAssuredRequests {
    private static final String END_POINT = LoadFromProperty.getProperty("endPoint");
    private static final String URL = LoadFromProperty.getProperty("url");
    private static final String INVALID_END_POINT = LoadFromProperty.getProperty("invalidEndPoint");
    private static final String API_KEY = LoadFromProperty.getXml("apiKey", "testData.xml");

    public static Map<String, String> getRequestBody(String message, User user) {
        Map<String, String> requestBody = new HashMap<String, String>();
        requestBody.put("message", message);
        requestBody.put("user_name", user.getUserName());
        requestBody.put("user_id", user.getUserId());
        return requestBody;
    }
    public static Response sendPost(String message, User user) {
        return getRequest(message, user, END_POINT);
    }

    public static Response sendInvalidRequest(String message, User user) {
        return getRequest(message, user, INVALID_END_POINT);
    }

    private static Response getRequest(String message, User user, String endPoint) {
        RestAssured.baseURI = URL;
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header(Headers.X_API_KEY, API_KEY)
                .body(getRequestBody(message, user))
                .when()
                .post(endPoint);
    }
}
