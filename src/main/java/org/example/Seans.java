package org.example;

import java.io.Serializable;
import java.util.HashMap;

public class Seans implements Serializable {
    private String nazwa;
    private String godzina;

    private String dzien;

    private Integer ograniczenieWiekowe;

    private int ilosc_miejsc;
    private HashMap<Integer, Boolean> miejsca = new HashMap<Integer, Boolean>();

    public Seans(String nazwa, String godzina, String dzien, Integer ograniczenieWiekowe, int ilosc_miejsc) {
        this.nazwa = nazwa;
        this.godzina = godzina;
        this.dzien = dzien;
        this.ograniczenieWiekowe = ograniczenieWiekowe;
        this.ilosc_miejsc = ilosc_miejsc;

        initializeHashMap(ilosc_miejsc);
    }

    public void initializeHashMap(int ilosc_miejsc){
        for (int i = 0; i <= ilosc_miejsc ; i++) {
            miejsca.put(i, false);
        }
    }

    public void rezerwacja(int numerMiejsca, Klient klient, Integer idBiletu){
        if(numerMiejsca>ilosc_miejsc || numerMiejsca<1){
            System.out.println("Zle wprowadzone miejsce");
        }
        else if(!miejsca.get(numerMiejsca)){
                miejsca.put(numerMiejsca,true); //zaznaczenie zajećia miejca
                Bilet bilet = new Bilet(idBiletu,this,numerMiejsca);
                klient.dodajBilet(bilet);
                System.out.println(numerMiejsca + " miejsce zarezerwowane");
        }
        else{
            System.out.println("Miejsce niedostępne");
        }
    }

    public void anulowanie(Bilet bilet,Klient klient){
        System.out.println(bilet.getNumerMiejsca() + " anulowane");
        klient.usunBilet(bilet);
        miejsca.put(bilet.getNumerMiejsca(),false);

    }

    public void pokazHashMape() {
        Integer iloscRzedow = ilosc_miejsc / 5;
        System.out.println(iloscRzedow + " " + ilosc_miejsc);
        System.out.println("+-----+-----+-----+-----+-----+");
        for (int i = 0; i < iloscRzedow; i++) {
            for (int j = 0; j <= 4; j++) {
                if (!miejsca.get(i * 5 + j)) {
                    int x = i * 5 + j;
                    System.out.printf("| \u001B[32m%3d\u001B[0m ", x); // Green color for numbers
                } else {
                    System.out.print("| \u001B[31m  X \u001B[0m"); // Red color for "x"
                }
            }
            System.out.println("|");
            System.out.println("+-----+-----+-----+-----+-----+");
        }
    }


    public String getNazwa() {
        return nazwa;
    }

    @Override
    public String toString() {
        return "Seans: " + nazwa + ", godzina: " + godzina;
    }
}
