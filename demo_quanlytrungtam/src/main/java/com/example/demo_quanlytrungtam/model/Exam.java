package com.example.demo_quanlytrungtam.model;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    int idSubject;
    String subject;
    int id;
    String title;
    List<MultiChoiceQuest> questionList = new ArrayList<>();

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

    public List<MultiChoiceQuest> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<MultiChoiceQuest> questionList) {
        this.questionList = questionList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return title + "\n"
                + questionList.toString();
    }
}
