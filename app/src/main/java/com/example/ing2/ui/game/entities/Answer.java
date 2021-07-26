package com.example.ing2.ui.game.entities;

public class Answer {
    private int id;
    private String answer;
    private String remember;

    public Answer(int id, String answer, String remember) {
        this.id = id;
        this.answer = answer;
        this.remember = remember;
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public String getRemember() {
        return remember;
    }

}
