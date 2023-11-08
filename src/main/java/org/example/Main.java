package org.example;

import java.awt.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        // Tworzenie pracowników / klientów / filmów
        System.out.println("Tworzenie pracownika....");
        Pracownik agata = new Pracownik(0,"Agata","Szycha", "szycha@gmail.com");
        System.out.println("Tworzenie konta klienta");
        Klient papryk = new Klient(0, "Patryk", "Cygi",333333333);
        System.out.println("Tworzenie Seansu1...");
        Seans film = new Seans("Szybcy i wściekli","20:30:00","środa", 18,20);
        System.out.println("Tworzenie Seansu2...");
        Seans film2 = new Seans("Noc w muzeum","20:30:00","środa", 18,20);
        System.out.println("Tworzenie Seansu3...");
        Seans film3 = new Seans("Matrix","20:30:00","środa", 18,20);
        System.out.println("--------------------------------------------------------");

        // Rezerwacja miejsc
        System.out.println("Klient "+ papryk.getImieInazwisko() + " Kupuje bilet na " + film.getNazwa());
        agata.rezerwujMiejsce(film, 2, papryk, 0);

        System.out.println("Klient "+ papryk.getImieInazwisko() + " Kupuje bilet na " + film.getNazwa());
        agata.rezerwujMiejsce(film, 4, papryk, 1);

        System.out.println("Klient "+ papryk.getImieInazwisko() + " Kupuje bilet na " + film.getNazwa());
        agata.rezerwujMiejsce(film, 10, papryk, 2);

        System.out.println("--------------------------------------------------------");
        System.out.println("Aktualny stan miejsc");
        film.pokazHashMape();
        System.out.println("--------------------------------------------------------");

        System.out.println(papryk.getBilety());
        System.out.println("--------------------------------------------------------");
        System.out.println("Sprawdzanie czy wystąpi błąd gdy chcemy zarezerwować to samo miejsce");
        agata.rezerwujMiejsce(film, 2, papryk, 0);

        System.out.println("--------------------------------------------------------");
        System.out.println("Sprawdzanie czy wystąpi błąd gdy chemy dodać bilet spoza zakresu miejsc");
        agata.rezerwujMiejsce(film, 22, papryk, 0);
        System.out.println("--------------------------------------------------------");


        // Usuwanie biletu
        System.out.println("Sprawdzanie czy poprawne usuwanie biletu");
        agata.anulujMiejsce(film,papryk.zwrocBiletPoId(0),papryk);

        System.out.println(papryk.getBilety());
        System.out.println("--------------------------------------------------------");

        /*
        System.out.println("Sprawdzanie czy poprawne usuwanie biletu");
        agata.anulujMiejsce(film,papryk.zwrocBiletPoId(1),papryk);
        System.out.println(papryk.getBilety());
        System.out.println("--------------------------------------------------------");

        System.out.println("Sprawdzanie czy poprawne usuwanie biletu");
        agata.anulujMiejsce(film,papryk.zwrocBiletPoId(2),papryk);
        System.out.println(papryk.getBilety());
        System.out.println("--------------------------------------------------------");
        System.out.println("Aktualny stan miejsc");
        film.pokazHashMape();
        */

        // Serializacja
        try {
            ObjectOutputStream seanseWy = new ObjectOutputStream(new FileOutputStream(".\\seanse.ser"));
            ObjectOutputStream klienciWy = new ObjectOutputStream(new FileOutputStream(".\\klienci.ser"));
            seanseWy.writeObject(film);
            klienciWy.writeObject(papryk);
        } catch (IOException e){
            e.printStackTrace();
        }

        // Deserializacja
        try {
            ObjectInputStream seanseWe = new ObjectInputStream(new FileInputStream(".\\seanse.ser"));
            ObjectInputStream klienciWe = new ObjectInputStream(new FileInputStream(".\\klienci.ser"));
            Seans seans = (Seans) seanseWe.readObject();
            Klient klient = (Klient) klienciWe.readObject();
            System.out.println(klient.toString());
            seans.pokazHashMape();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to deserial");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            throw new RuntimeException(e);
        }

    }

}