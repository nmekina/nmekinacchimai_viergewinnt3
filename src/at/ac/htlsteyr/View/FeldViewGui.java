package at.ac.htlsteyr.View;

import at.ac.htlsteyr.Model.Spiel;
import at.ac.htlsteyr.Model.Spieler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class FeldViewGui implements FeldView{
    Label l;

    public FeldViewGui(Label l) {
        this.l = l;
    }

    @Override
    public void display(Spieler spieler1, Spieler spieler2) {
        if (Spiel.spieler1) {
            Alert aler = new Alert(Alert.AlertType.NONE);
            aler.setAlertType(Alert.AlertType.INFORMATION);
            aler.setTitle("Winner");
            aler.setHeaderText(spieler1.getNickname() + " hat gewonnen!");
            aler.show();
        } else {
            Alert aler = new Alert(Alert.AlertType.NONE);
            aler.setAlertType(Alert.AlertType.INFORMATION);
            aler.setTitle("Winner");
            aler.setHeaderText(spieler2.getNickname() + " hat gewonnen!");
            aler.show();
        }
    }

    public void spielertausch(Spieler spieler1, Spieler spieler2) {
        if (Spiel.spieler1) {
            l.setText(spieler1.getNickname() + " ist an der Reihe:");
        } else if (Spiel.spieler2) {
            l.setText(spieler2.getNickname() + " ist an der Reihe:");
        }
    }

    @Override
    public void alert(String s) {

    }
}
