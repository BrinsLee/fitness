package com.brins.fitness.database;

import org.litepal.crud.DataSupport;

public class Step extends DataSupport {

    private int id;
    private int Step;
    private String Date;
    private float Calori;
    private float km;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStep() {
        return Step;
    }

    public void setStep(int step) {
        Step = step;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public float getCalori() {
        return Calori;
    }

    public void setCalori(float calori) {
        Calori = calori;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }
}
