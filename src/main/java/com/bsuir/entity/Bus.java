package com.bsuir.entity;

/**
 * Created by Егор on 10.04.17.
 */
public class Bus {
    private int number;
    private String depDate;
    private String depTime;
    private String depStation;
    private int depPlatform;
    private String arrStation;
    private double cost;
    private String mark;
    private String time;

    public Bus(int number, String depDate, String depTime, String depStation, int depPlatform, String arrStation, double cost, String mark, String time) {
        this.number = number;
        this.depDate = depDate;
        this.depTime = depTime;
        this.depStation = depStation;
        this.depPlatform = depPlatform;
        this.arrStation = arrStation;
        this.cost = cost;
        this.mark = mark;
        this.time = time;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bus{");
        sb.append("number=").append(number);
        sb.append(", depDate='").append(depDate).append('\'');
        sb.append(", depTime='").append(depTime).append('\'');
        sb.append(", depStation='").append(depStation).append('\'');
        sb.append(", depPlatform=").append(depPlatform);
        sb.append(", arrStation='").append(arrStation).append('\'');
        sb.append(", cost=").append(cost);
        sb.append(", mark='").append(mark).append('\'');
        sb.append(", time='").append(time).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
