package com.example.MinhTu300322371;

public class Savings {

    private String customerNumber;
    private String customerName;
    private double customerDeposit;
    private Integer year;
    private String savingType;

    public Savings(String customerNumber, String customerName, double customerDeposit, Integer year, String savingType) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.customerDeposit = customerDeposit;
        this.year = year;
        this.savingType = savingType;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getCustomerDeposit() {
        return customerDeposit;
    }

    public void setCustomerDeposit(double customerDeposit) {
        this.customerDeposit = customerDeposit;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSavingType() {
        return savingType;
    }

    public void setSavingType(String savingType) {
        this.savingType = savingType;
    }
}
