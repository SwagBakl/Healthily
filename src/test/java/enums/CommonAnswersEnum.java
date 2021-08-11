package enums;

public enum CommonAnswersEnum {
    OK(0),
    I_ACCEPT(0);

    private final int answerNumber;
    CommonAnswersEnum(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }
}
