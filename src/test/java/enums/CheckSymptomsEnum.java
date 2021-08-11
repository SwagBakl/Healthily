package enums;

public enum CheckSymptomsEnum {
    CONTINUE_ASSESSMENT(0),
    CONTINUE_ANYWAY(1),
    REPHRASE(2);

    private final int answerNumber;
    CheckSymptomsEnum(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }
}
