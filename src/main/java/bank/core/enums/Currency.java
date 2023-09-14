package bank.core.enums;

public enum Currency {
    RUBLE("рубль"),
    DOLLAR("доллар");

    private String type;

    Currency(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
