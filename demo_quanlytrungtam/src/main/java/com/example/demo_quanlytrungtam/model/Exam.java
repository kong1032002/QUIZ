package com.example.demo_quanlytrungtam.model;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    int idSubject;
    int id;
    String title;
    List<Question> questionList = new ArrayList<>();

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return title + "\n"
                + questionList.toString();
    }
}
