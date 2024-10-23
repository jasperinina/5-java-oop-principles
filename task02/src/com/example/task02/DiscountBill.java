package com.example.task02;

public class DiscountBill extends Bill{
    private double Discount;

    @Override
    public long getPrice(){
        return (long)(super.getPrice() * (1 - Discount));
    }

    public long getAbsDiscount(){
        return super.getPrice() - this.getPrice();
    }

    public DiscountBill(double discount){
        this.Discount = discount;
    }

    public DiscountBill(){

    }

    public void setDiscount(double discount){
        this.Discount = discount;
    }

    public String  getDiscount(){
        return this.Discount * 100 + "%";
    }

}