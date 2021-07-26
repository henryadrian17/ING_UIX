package com.example.ing2.ui.game.entities;

import java.util.List;

public class Question {
    private int id;
    private String question;
    private Answer correctAnswer;
    private Answer userAnswer;
    private List <Answer> options;
    private float points;

    public Question(int id, String question, Answer correctAnswer, List<Answer> options, float points) {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.options = options;
        this.points = points;
    }

    public void setUserAnswer(Answer userAnswer) {
        this.userAnswer = userAnswer;
    }

    public Answer getUserAnswer() {
        return userAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getOptions() {
        return options;
    }

    public float getPoints(){
        if(userAnswer.getId() == correctAnswer.getId())
            return points;
        else
            return 0;
    }

}
