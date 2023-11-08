package org.example;

import java.io.Serializable;

public class Pracownik implements Serializable {

    private Integer idPracownika;
    private String imie;
    private String nazwisko;

    private String email;

    public Pracownik(Integer idPracownika, String imie, String nazwisko, String email) {
        this.idPracownika = idPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    public void rezerwujMiejsce(Seans seans, int numerMiejsca,Klient klient, Integer idBiletu){
        seans.rezerwacja(numerMiejsca,klient,idBiletu);
    }

    public void anulujMiejsce(Seans seans,Bilet bilet,Klient klient){
        seans.anulowanie(bilet,klient);

    }

}
