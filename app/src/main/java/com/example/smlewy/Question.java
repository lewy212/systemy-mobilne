package com.example.smlewy;


public class Question {
    private int questionId;
    private boolean trueAnswer;

    public Question(int questionId, boolean trueAnswer) {
        this.questionId = questionId;
        this.trueAnswer = trueAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public boolean isTrue() {
        return trueAnswer;
    }
}
