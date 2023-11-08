package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Klient implements Serializable {

    private Integer idKlienta;
    private String imie;
    private String nazwisko;
    private Integer telefon;
    private List<Bilet> bilety = new ArrayList<Bilet>();

    public Klient(Integer idKlienta, String imie, String nazwisko, Integer telefon) {
        this.idKlienta = idKlienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
    }

    public void dodajBilet(Bilet bilet){
        bilety.add(bilet);
    }

    public void usunBilet(Bilet bilet){
        System.out.println("Usuwanie biletu Klienta "+ getImieInazwisko() + " Bilet na" + bilet.getIdBiletu());
        usunPozycjePoId(bilet.getIdBiletu());
    }

    public List<Bilet> getBilety() {
        return bilety;
    }

    public Bilet zwrocBiletPoId(Integer id){
        for(int i=0; i<bilety.size(); i++){
            if(bilety.get(i).getIdBiletu() == id){
                return bilety.get(i);
            }
        }
        return null;
    }

    public void usunPozycjePoId(Integer id){
        for(int i=0; i<bilety.size(); i++){
            if(bilety.get(i).getIdBiletu() == id){
                System.out.println("Usunieto bilet");
                bilety.remove(i);
            }
        }

    }
    public String getImieInazwisko(){
        return imie+ " "+nazwisko;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "idKlienta=" + idKlienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon=" + telefon +
                ", bilety=" + bilety +
                '}';
    }
}
