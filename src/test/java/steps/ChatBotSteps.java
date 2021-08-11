package steps;

import api.RestAssuredRequests;
import api.StatusCodeEnum;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import models.User;
import utils.LoggerUtil;

public class ChatBotSteps {

    public static String handleResponseMessageAndChoice(String message, User user, String messageJsonPath, int messageNumber, String messageJsonChoice,
                      int choiceNumber, String responseMessageToCompare) {
        Response response = RestAssuredRequests.sendPost(message, user);
        String jsonResponse = response.asPrettyString();
        String responseMessage = JsonPath.read(jsonResponse, String.format(messageJsonPath, messageNumber));
        LoggerUtil.logger.info(responseMessage);
        String responseChoice = JsonPath.read(jsonResponse, String.format(messageJsonChoice, choiceNumber));
        LoggerUtil.logger.info(responseChoice);
        ChatBotAsserts.assertChatBotResponse(StatusCodeEnum.RESPONSE_OK.getStatusCode(), responseMessageToCompare, responseMessage, response);
        return responseChoice;
    }

    public static void handleResponseMessage(String message, User user, String messageJsonPath, int messageNumber,
                               String responseMessageToCompare) {
        Response response = RestAssuredRequests.sendPost(message, user);
        String responseMessage = JsonPath.read(response.asPrettyString(), String.format(messageJsonPath, messageNumber));
        LoggerUtil.logger.info(responseMessage);
        ChatBotAsserts.assertChatBotResponse(StatusCodeEnum.RESPONSE_OK.getStatusCode(),
                responseMessageToCompare, responseMessage, response);
    }
}
