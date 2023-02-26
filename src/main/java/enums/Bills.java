package enums;

public enum Bills  {
    BILL_100(100),
    BILL_200(200);

    private int value;

    private Bills(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}