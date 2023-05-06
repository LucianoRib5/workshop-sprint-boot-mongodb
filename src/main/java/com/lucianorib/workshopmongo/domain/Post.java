package com.lucianorib.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document
public class Post {
    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private User user;

    public Post() {

    }

    public Post(String id, Date date, String title, String body, User user) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return getId().equals(post.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
