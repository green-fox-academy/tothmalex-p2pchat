package com.greenfox.chat.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Random;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String userName;
    String text;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    int specialid = (int )(Math.random() * 9999999 + 1000000);

    public Message() {
    }

    public Message( String text) {
        this.text = text;
    }

    public Message(int id, String userName, String text, Timestamp timestamp) {
        this.userName = userName;
        this.text = text;
        this.timestamp = timestamp;
        this.id = id;
    }
    public Message( String userName, String text, Timestamp timestamp, int specialid ) {
        this.userName = userName;
        this.text = text;
        this.timestamp = timestamp;
        this.specialid = specialid;
    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public int getSpecialid() {
        return specialid;
    }

    public void setSpecialid( int specialid ) {
        this.specialid = specialid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp( Timestamp timestamp ) {
        this.timestamp = timestamp;
    }
}
