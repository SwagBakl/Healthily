package tests;

import configuration.LoadFromProperty;
import utils.RandomGeneratorUtils;

public class TestData {

    public static final String TEST_FILE = "testData.xml";

    public static final String USER_NAME = LoadFromProperty.getXml("userName", TEST_FILE);
    public static final String USER_ID = USER_NAME + RandomGeneratorUtils.generateRandomNumber();
    public static final String GREETING_MESSAGE = LoadFromProperty.getXml("greetingMessage", TEST_FILE);
    public static final String ACCEPT_PERSONAL_DATA = LoadFromProperty.getXml("acceptPersonalData", TEST_FILE);
    public static final String SYMPTOMS_MESSAGE = LoadFromProperty.getXml("symptoms", TEST_FILE);
    public static final String AGE_MESSAGE = LoadFromProperty.getXml("age", TEST_FILE);
    public static final String CHOICE_JSON_PATH = "$.question.choices[%s].label";
    public static final String MESSAGE_JSON_PATH = "$.messages[%s].value";
    //параметр через команднуб строку
    //отдельный класс либо использовать поле тут
    //singleResponcibility princ
}
