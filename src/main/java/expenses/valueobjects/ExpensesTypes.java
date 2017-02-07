package expenses.valueobjects;

public enum ExpensesTypes {
    FOOD("FOOD"),
    ALCOHOL("ALCOHOL"),
    HOOKERS("HOOKERS"),
    GAMBLING("GAMBLING"),
    BETS("BETS"),
    OTHERS("OTHERS");

    private final String expenseType;

    private ExpensesTypes(final String type){
        this.expenseType = type;
    }

    public String getExpenseType() {
        return expenseType;
    }

}
