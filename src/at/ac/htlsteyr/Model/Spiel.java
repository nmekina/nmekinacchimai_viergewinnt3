package at.ac.htlsteyr.Model;

public class Spiel {
    public static boolean spieler1 = false;
    public static boolean spieler2 = false;
    public static int[] füllungspalten = new int[7]; // Speichert die anzahl der spielsteine in der jeweiligen Spalten

    /**
     * Durch Math.random wird eine zufällige zahl zwischen 1 und 2 gewählt
     * So wird der Spieler anfangen ausgewählt
     */
    public void zufallsgenerator() {

        int zufall = (int) ((Math.random()) * 2 + 1);

        if (zufall == 1) {
            spieler1 = true;
        } else if (zufall == 2) {
            spieler2 = true;
        }

    }

    /**
     * Aktiver Spieler wird ausgewählt/geändert
     */
    public static void spielertausch() {
        spieler1 = !spieler1;
        spieler2 = !spieler2;
    }

    /**
     *
     */
    public void werfen() {
        if (spieler1 == true) {
            Feld.spielfeld[6 - füllungspalten[Feld.spalten - 1]][Feld.spalten - 1] = 1;
        } else {
            Feld.spielfeld[6 - füllungspalten[Feld.spalten - 1]][Feld.spalten - 1] = 2;
        }
    }

    /**
     * win condition wird überprüft/ausgelöst
     *
     * @return ob es schon einen Gewinner
     */
    public boolean checkwin() {
        int spieler;
        boolean a = false;


        if (spieler1 == true) {
            spieler = 1;
        } else {
            spieler = 2;
        }

        // wincon für vertikal
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 6; j++) {
                if (Feld.spielfeld[i][j] == spieler && Feld.spielfeld[i + 1][j] == spieler && Feld.spielfeld[i + 2][j] == spieler && Feld.spielfeld[i + 3][j] == spieler) {
                    a = true;
                }
            }
        }

        // wincon für horizontal
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 3; j++) {
                if (Feld.spielfeld[i][j] == spieler && Feld.spielfeld[i][j + 1] == spieler && Feld.spielfeld[i][j + 2] == spieler && Feld.spielfeld[i][j + 3] == spieler) {
                    a = true;
                }
            }
        }

        // wincon für diagonalen
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (Feld.spielfeld[i][j] == spieler && Feld.spielfeld[i + 1][j + 1] == spieler && Feld.spielfeld[i + 2][j + 2] == spieler && Feld.spielfeld[i + 3][j + 3] == spieler) {
                    a = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 6; j > 2; j--) {
                if (Feld.spielfeld[i][j] == spieler && Feld.spielfeld[i + 1][j - 1] == spieler && Feld.spielfeld[i + 2][j - 2] == spieler && Feld.spielfeld[i + 3][j - 3] == spieler) {
                    a = true;
                }
            }
        }

        return a;
    }
}