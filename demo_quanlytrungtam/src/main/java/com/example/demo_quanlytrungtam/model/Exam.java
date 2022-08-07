package com.example.demo_quanlytrungtam.model;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    List<Question> questionList;

    public Exam() {
        questionList = new ArrayList<>();
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void addQuestion(Question question) {
        questionList.add(question);
    }

    public void removeQuestion(Question question) {
        questionList.remove(question);
    }
}
