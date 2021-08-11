package enums;

public enum UserGoalsInAppEnum {
    CHECK_SYMPTOMS(0),
    CORONA_RISK_ASSESSMENT(1),
    HEALTH_TEST(2),
    ASK_QUESTION(3);

    private final int goalNumber;
    UserGoalsInAppEnum(int goalNumber) {
        this.goalNumber = goalNumber;
    }

    public int getGoalNumber() {
        return goalNumber;
    }
    }
