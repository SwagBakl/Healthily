package enums;

public enum WhoCheckSymptomsEnum {
    ME(0),
    SOMEONE_ELSE(1);

    private final int goalNumber;
    WhoCheckSymptomsEnum(int goalNumber) {
        this.goalNumber = goalNumber;
    }

    public int getOptionNumber() {
        return goalNumber;
    }
}
