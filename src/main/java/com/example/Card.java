package com.example;

import java.io.Serializable;

/**
 * Created by mac on 5/7/16.
 */
public class Card {

    private String pan;
    private String psn;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    @Override
    public String toString() {
        return "Card{" +
                "pan='" + pan + '\'' +
                ", psn='" + psn + '\'' +
                '}';
    }
}
