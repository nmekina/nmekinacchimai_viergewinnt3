package at.ac.htlsteyr.View;

import at.ac.htlsteyr.Model.*;



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


}
