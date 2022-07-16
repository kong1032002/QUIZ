package com.quiz.Model;

public abstract class Question {
    protected int id;
    protected String subject;
    protected int chapter;
    protected int difficult;
    protected String question;
    protected int userId;

    public Question() {

    }

    public Question(int id, String subject, int chapter, int difficult, String question ,int userId) {
        this.id = id;
        this.subject = subject;
        this.chapter = chapter;
        this.difficult = difficult;
        this.question = question;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}