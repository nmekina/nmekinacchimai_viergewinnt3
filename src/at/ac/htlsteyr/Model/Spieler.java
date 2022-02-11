package at.ac.htlsteyr.Model;

public class Spieler {

    /**
     * Name des Spielers
     */
    public String nickname;
    /**
     * Spielstein des Spielers
     */
    public char spielstein;

    /**
     * getter für Name
     */
    public String getNickname() {
        return this.nickname;
    }
    /**
     * getter für Spielstein
     */
    public char getSpielstein() {
        return this.spielstein;
    }

    /**
     * setter für Spielstein
     */
    public void setSpielstein(char s) {
        this.spielstein = s;
    }

    /**
     * setter für Name
     */
    public void setNickname(String n) {
        this.nickname = n;
    }
}
