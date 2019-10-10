package br.com.crosoften.parkokcliente.commom;

import java.util.Date;

public class Time {

    private String day;
    private Date input;
    private Date exit;

    public Time(String day, Date input, Date exit) {
        this.day = day;
        this.input = input;
        this.exit = exit;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getInput() {
        return input;
    }

    public void setInput(Date input) {
        this.input = input;
    }

    public Date getExit() {
        return exit;
    }

    public void setExit(Date exit) {
        this.exit = exit;
    }
}
