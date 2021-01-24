package com.example.lilhelp;

import java.io.Serializable;

public abstract class Question implements Serializable {

    private String question;
    private String answer;

    protected Question(String q) {
        question = q;
    }

    public String getQuestionAsText() {
        return question;
    }

    public void setAnswer(String a) {
        answer = a;
    }

    public String getAnswer() { return answer; }

}
