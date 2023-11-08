package org.example;

import java.io.Serializable;

public class Bilet implements Serializable {

    Integer idBiletu;
    private Seans seans;
    private Integer numerMiejsca;

    public Bilet(Integer idBiletu, Seans seans, Integer numerMiejsca) {
        this.idBiletu = idBiletu;
        this.seans = seans;
        this.numerMiejsca = numerMiejsca;
    }

    public Integer getNumerMiejsca() {
        return numerMiejsca;
    }

    public Integer getIdBiletu() {
        return idBiletu;
    }

    public Seans getSeans() {
        return seans;
    }

    @Override
    public String toString() {
        return seans.toString() + ", numerMiejsca=" + numerMiejsca+ ", id: " + idBiletu;
    }
}
