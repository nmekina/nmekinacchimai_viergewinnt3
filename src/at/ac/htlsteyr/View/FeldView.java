package at.ac.htlsteyr.View;


import at.ac.htlsteyr.Model.Spieler;

public interface FeldView {
    void display(Spieler spieler1, Spieler spieler2);

    void spielertausch(Spieler spieler1, Spieler spieler2);

    void alert(String s);
}
