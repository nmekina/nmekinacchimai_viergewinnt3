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
        FeldView fw = new FeldViewConsole();

        fw.start(spieler1, spieler2);

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
            fw.display(spieler1, spieler2);
            spalteneingabe(spieler1, spieler2);
            s.werfen();
            s.spielertausch();
        }


        if (Spiel.spieler1) {
            String swin = spieler1.getNickname() + " hat gewonnen!";
            fw.alert(swin);
        } else {
            String swin = spieler2.getNickname() + " hat gewonnen!";
            fw.alert(swin);
        }

        System.out.println("Wollen Sie erneut spielen? (Ja(j), Nein(nicht j)");
        Scanner scannerneustart = new Scanner(System.in);
        if (scannerneustart.next().charAt(0) == 'j') {
            Feld.spalten = 0;
            Feld.spielfeld = new int[6][7];
            Spiel.füllungspalten = new int [7];
            play();
        }
    }

    /**
     * Sobald R eingelesen wird, startet das Spiel neu
     *Es wird geprüft ob eine Gültige Spaltennummer ausgwaehlt wurde
     *In füllungsspalten werden für die Spalte gültigen einwurf möglichkeiten verringert
     */
    public static void spalteneingabe(Spieler spieler1, Spieler spieler2) {
        Feld.spalten = 0;
        String EingabeA;
        FeldView fw = new FeldViewConsole();

        fw.spielertausch(spieler1, spieler2);
        Scanner sc = new Scanner(System.in);
        EingabeA = sc.next();

        if (EingabeA.charAt(0) == 'R') {
            Feld.spalten = 0;
            Feld.spielfeld = new int[6][7];
            Spiel.füllungspalten = new int [7];
            play();
        }

        if (!(EingabeA.charAt(0) > '0' && EingabeA.charAt(0) < '8')) {
            fw.alert("Achtung! Zahlen eingeben");
            spalteneingabe(spieler1, spieler2);
        } else {
            Feld.spalten = Integer.parseInt(EingabeA);

            if (Feld.spalten < 1 || Feld.spalten > 7) {
                fw.alert("Achtung! Die eingegebene Spaltennummer muss zwischen 1 und 7 liegen!");
                System.out.println();
                spalteneingabe(spieler1, spieler2);
            } else if (Spiel.füllungspalten[Feld.spalten - 1] > 5) {
                fw.alert("Spalte voll!!!!");
                spalteneingabe(spieler1, spieler2);
            } else {
                Spiel.füllungspalten[Feld.spalten - 1]++;
            }
        }
    }
}