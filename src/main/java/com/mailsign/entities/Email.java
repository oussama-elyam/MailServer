package com.mailsign.entities;

import java.util.Date;

public class Email {
    private String uuid;
    private int id;
    private String from;
    private String to;
    private String message;
    private String subject;
    private Date createdAt;
    public Email(){

    }
    public Email(String from, String to, String message, String subject, Date createdAt) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.subject = subject;
        this.createdAt = createdAt;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
