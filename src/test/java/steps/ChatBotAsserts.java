package steps;

import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import org.testng.Assert;

public class ChatBotAsserts {

    public static void assertChatBotResponse(int expectedResponseStatusCode, String expectedResponseMessage,
                                              String actualResponseMessage, Response response) {
        Assert.assertEquals(expectedResponseStatusCode, response.getStatusCode(), "Status code are not equal");
        Assert.assertTrue(actualResponseMessage.contains(expectedResponseMessage), "Response messages are not equal");
        response.then().assertThat().body(matchesJsonSchema(response.asPrettyString()));
    }
}
