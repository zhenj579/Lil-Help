package com.example.lilhelp;

public abstract class Question {

    protected String question;
    protected String answer;

    protected Question(String q) {
        question = q;
    }

    public String getQuestionAsText() {
        return question;
    }

    public void setAnswer(String a) {
        answer = a;
    }

}
