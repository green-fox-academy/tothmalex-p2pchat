package com.greenfox.chat.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    int score;
    String title;

    @DateTimeFormat(pattern = "mm/dd/yyyy")
    LocalDate created;

    public Post() {
        this.created = LocalDate.now();
    }

    public Post( String title ) {
        this.score = 0;
        this.title = title;
        this.created = LocalDate.now();
    }

    public int getScore() {
        return score;
    }


    public LocalDate getCreated() {
        return created;
    }

    public void setCreated( LocalDate created ) {
        this.created = created;
    }


    public void setScore( int score ) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }
}