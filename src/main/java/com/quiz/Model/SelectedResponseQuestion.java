package com.quiz.Model;

import java.util.ArrayList;
import java.util.List;

public class SelectedResponseQuestion extends Question {
    private List<String> choices = new ArrayList<>();
    private String answer;

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public void addChoice(String choice) {
        choices.add(choice);
    }

    public String getChoice(int index) {
        return choices.get(index);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
