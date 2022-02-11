package at.ac.htlsteyr.Controller;

import at.ac.htlsteyr.Model.*;
import at.ac.htlsteyr.View.*;

import java.util.Scanner;

public class HelloApplicationConsole {


    public static void main(String[] args) {
        play();
    }

    /**
     * nickname vergabe
     * zufälliger spieler wird aufgerufen
     * spielstein wahl
     * methoden Aufrufen für Spielablauf
     */
    public static void play() {
        Spieler spieler1 = new Spieler();
        Spieler spieler2 = new Spieler();
        Spiel s = new Spiel();
        FeldView fw = (FeldView) new FeldViewConsole();

        System.out.println("Name: Spieler1: ");
        Scanner scannerspieler1 = new Scanner(System.in);
        spieler1.setNickname(scannerspieler1.next());

        do {
            System.out.println("Name: Spieler2: ");
            Scanner scannerspieler2 = new Scanner(System.in);
            spieler2.setNickname(scannerspieler2.next());
        } while (spieler1.getNickname().equals(spieler2.getNickname()));

        s.zufallsgenerator();

        if (Spiel.spieler1 == true) {
            System.out.println(spieler1.getNickname() + " beginnt: Spielstein(x/o) wählen: ");
            Scanner scannerspielstein = new Scanner(System.in);
            if (scannerspielstein.next().charAt(0) == 'x') {
                spieler1.setSpielstein('x');
                spieler2.setSpielstein('o');
            } else {
                spieler1.setSpielstein('o');
                spieler2.setSpielstein('x');
            }
        } else if (Spiel.spieler2 == true) {
            System.out.println(spieler2.getNickname() + " beginnt: Spielstein(x/o) wählen: ");
            Scanner scannerspielstein = new Scanner(System.in);
            if (scannerspielstein.next().charAt(0) == 'x') {
                spieler2.setSpielstein('x');
                spieler1.setSpielstein('o');
            } else {
                spieler2.setSpielstein('o');
                spieler1.setSpielstein('x');
            }
        }

        while (s.checkwin() == false) {
           // fw.display(spieler1, spieler2);
            spalteneingabe(spieler1, spieler2);
            s.werfen();
            s.spielertausch();
        }

        if (Spiel.spieler2 == true) {
            System.out.println(spieler2.getNickname() + " hat gewonnen!");
        } else {
            System.out.println(spieler1.getNickname() + " hat gewonnen!");
        }

    }


    public static void spalteneingabe(Spieler spieler1, Spieler spieler2) {
        Feld.spalten = 0;
        String EingabeA;

        if (Spiel.spieler1 == true) {

            System.out.println(spieler1.getNickname() + " bitte Spaltennummer angeben: ");
            Scanner sc = new Scanner(System.in);
            EingabeA = sc.next();
        } else {
            System.out.println(spieler2.getNickname() + " bitte Spaltennummer angeben: ");
            Scanner sc = new Scanner(System.in);
            EingabeA = sc.next();
        }

        Feld.spalten = Integer.parseInt(EingabeA);

        if (Feld.spalten < 1 || Feld.spalten > 7) {
            System.out.println();
            System.out.println("Achtung! Die eingegebene Spaltennummer muss zwischen 1 und 7 liegen!");
            spalteneingabe(spieler1, spieler2);
        } else if (Spiel.füllungspalten[Feld.spalten - 1] > 5) {
            System.out.println("Spalte voll!!!!");
            spalteneingabe(spieler1, spieler2);
        } else {
            Spiel.füllungspalten[Feld.spalten - 1]++;
        }
    }
}