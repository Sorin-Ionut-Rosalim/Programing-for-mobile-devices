package com.example.MoneyProblemSolver;

import androidx.annotation.NonNull;

public class PaymentModel {

    private final String ID;
    private final String PAYMENT_NAME;
    private final String PAYMENT_DATE;
    private final String CATEGORY;
    private final String PAYMENT_TIME;
    private final String PAYMENT_LOCATION;
    private final String OBSERVATIONS;

    public PaymentModel(String id, String paymentName, String paymentDate, String category, String paymentTime, String paymentLocation,String observations){
        this.ID = id;
        this.PAYMENT_NAME = paymentName;
        this.PAYMENT_DATE = paymentDate;
        this.CATEGORY = category;
        this.PAYMENT_TIME = paymentTime;
        this.PAYMENT_LOCATION = paymentLocation;
        this.OBSERVATIONS = observations;
    }

    @NonNull
    @Override
    public String toString() {
        return  "Payment ID: " + this.ID + "\n" +
                "Payment Mame: " + this.PAYMENT_NAME + "\n" +
                "Payment Date: " + this.PAYMENT_DATE + "\n" +
                "Category: " + this.CATEGORY + "\n" +
                "Payment Time: " + this.PAYMENT_TIME + "\n" +
                "Payment Location: " + this.PAYMENT_LOCATION + "\n" +
                "Observations: " + this.OBSERVATIONS;
    }

    public String getCourseName(){
        return this.PAYMENT_NAME;
    }
}
