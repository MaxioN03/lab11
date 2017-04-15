package com.bsuir.entity;

/**
 * Created by Егор on 10.04.17.
 */
public class Train extends Vehicle{
    private int number;
    private String depDate;
    private String depTime;
    private String depStation;
    private int depPlatform;
    private String arrStation;
    private String arrDate;
    private String arrTime;
    private double cost;
    private String typeTicket;

    public Train(int number, String depDate, String depTime, String depStation, int depPlatform, String arrStation, String arrDate, String arrTime, double cost, String typeTicket) {
        this.number = number;
        this.depDate = depDate;
        this.depTime = depTime;
        this.depStation = depStation;
        this.depPlatform = depPlatform;
        this.arrStation = arrStation;
        this.arrDate = arrDate;
        this.arrTime = arrTime;
        this.cost = cost;
        this.typeTicket = typeTicket;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getDepStation() {
        return depStation;
    }

    public void setDepStation(String depStation) {
        this.depStation = depStation;
    }

    public int getDepPlatform() {
        return depPlatform;
    }

    public void setDepPlatform(int depPlatform) {
        this.depPlatform = depPlatform;
    }

    public String getArrStation() {
        return arrStation;
    }

    public void setArrStation(String arrStation) {
        this.arrStation = arrStation;
    }

    public String getArrDate() {
        return arrDate;
    }

    public void setArrDate(String arrDate) {
        this.arrDate = arrDate;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(String typeTicket) {
        this.typeTicket = typeTicket;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Train{");
        sb.append("number=").append(number);
        sb.append(", depDate='").append(depDate).append('\'');
        sb.append(", depTime='").append(depTime).append('\'');
        sb.append(", depStation='").append(depStation).append('\'');
        sb.append(", depPlatform=").append(depPlatform);
        sb.append(", arrStation='").append(arrStation).append('\'');
        sb.append(", arrDate='").append(arrDate).append('\'');
        sb.append(", arrTime='").append(arrTime).append('\'');
        sb.append(", cost=").append(cost);
        sb.append(", typeTicket='").append(typeTicket).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
