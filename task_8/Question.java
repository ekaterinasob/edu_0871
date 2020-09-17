package com.example.myapplication;

public class Question {
    private int questionTextId;
    private boolean answerTrue;

    public Question(int questionTextId, boolean answerTrue) {
        this.questionTextId = questionTextId;
        this.answerTrue = answerTrue;
    }

    public int getQuestionTextId() {
        return questionTextId;
    }

    public void setQuestionTextId(int questionTextId) {
        this.questionTextId = questionTextId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
