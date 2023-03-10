package br.com.example.designpatterncommandwithcommandlib.domain;

public class BankAccount {

    private Double amount;

    public BankAccount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
