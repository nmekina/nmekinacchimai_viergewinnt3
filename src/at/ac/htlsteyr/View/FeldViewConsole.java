package at.ac.htlsteyr.View;

import at.ac.htlsteyr.Model.*;

import java.util.Scanner;


public class FeldViewConsole implements FeldView {


    /**
     * Feld wird angezeigt mit den jeweiligen Spielsteinen der 2 Spieler
     */
    public void display(Spieler spieler1, Spieler spieler2) {
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        System.out.println("|___|___|___|___|___|___|___|");


        for (int zcounter = 0; zcounter < 6; zcounter++) {
            System.out.println("|   |   |   |   |   |   |   |");

            for (int scounter = 0; scounter < 7; scounter++) {

                if (Feld.spielfeld[zcounter][scounter] == 1) {
                    System.out.print("| " + spieler1.getSpielstein() + " ");
                } else if (Feld.spielfeld[zcounter][scounter] == 2) {
                    System.out.print("| " + spieler2.getSpielstein() + " ");
                } else if (Feld.spielfeld[zcounter][scounter] == 0) {
                    System.out.print("|   ");
                }
            }


            System.out.print("|  ");
            System.out.println();
            System.out.println("|___|___|___|___|___|___|___|");
        }

        System.out.println();
    }

    /**
     * Ausgabe des Spielers der an der Reihe ist
     */
    @Override
    public void spielertausch(Spieler spieler1, Spieler spieler2) {
        if (Spiel.spieler1) {
            System.out.println(spieler1.getNickname() + " ist an der Reihe:");
        } else if (Spiel.spieler2) {
            System.out.println(spieler2.getNickname() + " ist an der Reihe:");
        }
    }

    /**
     * Ausgabe eines Fehler
     */
    @Override
    public void alert(String s) {
        System.out.println(s);
    }

    /**
     * Ausgabe des start des Spieles und setzen des Spielsteins
     */
    @Override
    public void start(Spieler spieler1, Spieler spieler2) {
        System.out.println("Name: Spieler1: ");
        Scanner scannerspieler1 = new Scanner(System.in);
        spieler1.setNickname(scannerspieler1.next());

        do {
            System.out.println("Name: Spieler2: ");
            Scanner scannerspieler2 = new Scanner(System.in);
            spieler2.setNickname(scannerspieler2.next());
        } while (spieler1.getNickname().equals(spieler2.getNickname()));
    }
}
