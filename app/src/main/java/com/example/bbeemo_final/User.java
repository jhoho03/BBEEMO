package com.example.bbeemo_final;

public class User {

    String from, msg, date;

    public User() {}

    public User(String from, String msg, String date) {
        this.from = from;
        this.msg = msg;
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
