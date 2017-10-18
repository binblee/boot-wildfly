package com.example.demo;

public class DemoContent {
    private int id;
    private int content;

    public DemoContent(int id, int content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DemoContent{" +
                "id=" + id +
                ", content=" + content +
                '}';
    }
}
