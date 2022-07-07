package main.com.hk.VendingMachine.dto;

public class Cash {

    private double cashAmount = 0;

    public double getCashAmount() {
        return cashAmount;
    }

    public Cash setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
        return null;
    }
}
