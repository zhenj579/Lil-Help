package com.example.lilhelp;

import java.io.Serializable;

public class JournalEntry implements Serializable {

    private AccomplishQuestion aq;
    private ForwardQuestion fq;
    private GratefulQuestion gq;
    private String text;

    public void setAq(AccomplishQuestion aq) {
        this.aq = aq;
    }

    public void setFq(ForwardQuestion fq) {
        this.fq = fq;
    }

    public void setGq(GratefulQuestion gq) {
        this.gq = gq;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AccomplishQuestion getAq() {
        return aq;
    }

    public ForwardQuestion getFq() {
        return fq;
    }

    public GratefulQuestion getGq() {
        return gq;
    }

    public String getText() {
        return text;
    }
}
