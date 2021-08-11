package tests;

import api.RestAssuredRequests;
import api.StatusCodeEnum;
import configuration.AllureUtils;
import enums.*;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.ChatBotSteps;
import utils.CsvReaderUtil;
import utils.LoggerUtil;

import java.util.List;

public class ChatBotTest {

    private User user;

    @BeforeTest
    public void setUp() {
        LoggerUtil.logger.info("Preparing test data...");
        user = new User(TestData.USER_ID, TestData.USER_NAME);
    }

    @Test
    @Description("Chat bot dialogue test")
    public void chatBotDialogTest() {
        System.out.println(CsvReaderUtil.getRowValue("userId"));
        System.out.println(CsvReaderUtil.getRowValue("userName"));
        LoggerUtil.logger.info("Conversation starting...");
        LoggerUtil.step(1);
        String firstResponseChoice = ChatBotSteps.handleResponseMessageAndChoice(TestData.GREETING_MESSAGE, user,
                TestData.MESSAGE_JSON_PATH, 0, TestData.CHOICE_JSON_PATH, CommonAnswersEnum.OK.getAnswerNumber(),
                ResponseMessagesEnum.WELCOME.getResponseMessage());

        LoggerUtil.step(2);
        String secondResponseChoice = ChatBotSteps.handleResponseMessageAndChoice(firstResponseChoice, user,
                TestData.MESSAGE_JSON_PATH, 0, TestData.CHOICE_JSON_PATH, CommonAnswersEnum.I_ACCEPT.getAnswerNumber(),
                ResponseMessagesEnum.ACCEPT_PERSONAL_DATA_MESSAGE.getResponseMessage());

        LoggerUtil.step(3);
        String thirdResponseChoice = ChatBotSteps.handleResponseMessageAndChoice(secondResponseChoice, user,
                TestData.MESSAGE_JSON_PATH, 0, TestData.CHOICE_JSON_PATH, CommonAnswersEnum.OK.getAnswerNumber(),
                ResponseMessagesEnum.TERMS_ACCEPTED_MESSAGE.getResponseMessage());

        LoggerUtil.step(4);
        String fourthResponseChoice = ChatBotSteps.handleResponseMessageAndChoice(thirdResponseChoice, user,
                TestData.MESSAGE_JSON_PATH, 1, TestData.CHOICE_JSON_PATH, UserGoalsInAppEnum.CHECK_SYMPTOMS.getGoalNumber(),
                ResponseMessagesEnum.COACH_OPENED.getResponseMessage());

        LoggerUtil.step(5);
        String fifthResponseChoice = ChatBotSteps.handleResponseMessageAndChoice(fourthResponseChoice, user,
                TestData.MESSAGE_JSON_PATH, 0, TestData.CHOICE_JSON_PATH, WhoCheckSymptomsEnum.ME.getOptionNumber(),
                ResponseMessagesEnum.WHO_CHECK_SYMPTOMS_MESSAGE.getResponseMessage());

        LoggerUtil.step(6);
        ChatBotSteps.handleResponseMessage(fifthResponseChoice, user, TestData.MESSAGE_JSON_PATH, 0,
                ResponseMessagesEnum.CHECK_SYMPTOMS_MESSAGE.getResponseMessage());
        LoggerUtil.logger.info(TestData.SYMPTOMS_MESSAGE);

        LoggerUtil.step(7);
        ChatBotSteps.handleResponseMessage(TestData.SYMPTOMS_MESSAGE, user, TestData.MESSAGE_JSON_PATH, 1,
                ResponseMessagesEnum.GENDER_QUESTION.getResponseMessage());
        LoggerUtil.logger.info(GenderEnum.MALE.toString());

        LoggerUtil.step(8);
        ChatBotSteps.handleResponseMessage(GenderEnum.MALE.toString(), user, TestData.MESSAGE_JSON_PATH, 0,
                ResponseMessagesEnum.AGE_QUESTION.getResponseMessage());
        LoggerUtil.logger.info(TestData.AGE_MESSAGE);

        LoggerUtil.step(9);
        ChatBotSteps.handleResponseMessageAndChoice(TestData.AGE_MESSAGE, user, TestData.MESSAGE_JSON_PATH, 1,
                TestData.CHOICE_JSON_PATH, CheckSymptomsEnum.CONTINUE_ASSESSMENT.getAnswerNumber(),
                ResponseMessagesEnum.CHECK_ALL_MENTIONED_SYMPTOMS.getResponseMessage());

        AllureUtils.addAllureAttachment("log4j.log", "Log file attached Whick");
    }

    @Test
    @Description("Test with invalid end point")
    public void invalidApiRequestTest() {
        Response response = RestAssuredRequests.sendInvalidRequest("Message", user);
        Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.RESPONSE_OK.getStatusCode());
    }
}
