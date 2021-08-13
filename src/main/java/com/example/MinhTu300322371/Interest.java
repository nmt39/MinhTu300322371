package com.example.MinhTu300322371;

public class Interest {
    private Integer yr;
    private double startAmount;
    private double interest;
    private double balance;

    public Interest(Integer yr, double startAmount, double interest, double balance) {
        this.yr = yr;
        this.startAmount = startAmount;
        this.interest = interest;
        this.balance = balance;
    }

    public Integer getYr() {
        return yr;
    }

    public void setYr(Integer yr) {
        this.yr = yr;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
