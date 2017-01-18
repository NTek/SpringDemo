package com.xix.model;

public class Activity {
    Long id;
    String name;

    public Activity() {
    }

    public Activity(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Activity(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
