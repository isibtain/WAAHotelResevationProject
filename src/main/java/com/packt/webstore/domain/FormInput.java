package com.packt.webstore.domain;

public class FormInput {

    private String checkInDate;
    private String checkOutDate;
    private String type;
    private String view;
    private String gym;
    private String parking;

    public FormInput(String checkInDate, String checkOutDate, String type, String view, String gym, String parking) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.type = type;
        this.view = view;
        this.gym = gym;
        this.parking = parking;
    }

    public FormInput(String checkInDate, String checkOutDate, String type, String view, String gym) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.type = type;
        this.view = view;
        this.gym = gym;
    }

    public FormInput() { }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }
}
