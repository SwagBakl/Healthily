package enums;

public enum ResponseMessagesEnum {
    WELCOME("Welcome!"),
    ACCEPT_PERSONAL_DATA_MESSAGE("To enable us to personalise our service, we need some of your personal data."),
    TERMS_ACCEPTED_MESSAGE("Remember that Healthily is not a doctor."),
    COACH_OPENED("What would you like to do?"),
    WHO_CHECK_SYMPTOMS_MESSAGE("Who is the symptom check for?"),
    CHECK_SYMPTOMS_MESSAGE("Tell me about the symptoms you have today"),
    GENDER_QUESTION("Are you a male or female?"),
    AGE_QUESTION("What year were you born in?"),
    CHECK_ALL_MENTIONED_SYMPTOMS("So, just to check, are these all the symptoms you mentioned?");

    private final String responseMessage;
    ResponseMessagesEnum(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

}
