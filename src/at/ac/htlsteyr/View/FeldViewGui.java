package at.ac.htlsteyr.View;

import at.ac.htlsteyr.Model.Spiel;
import at.ac.htlsteyr.Model.Spieler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Scanner;

public class FeldViewGui implements FeldView{
    Label ueberschrift;
    TextField name1;
    TextField name2;

    public FeldViewGui(Label ueberschrift, TextField name1, TextField name2) {
        this.ueberschrift = ueberschrift;
        this.name1 = name1;
        this.name2 = name2;
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
        if (Spiel.spieler1 == true) {
            ueberschrift.setText(spieler1.getNickname() + " ist an der Reihe");
        } else {
            ueberschrift.setText(spieler2.getNickname() + " ist an der Reihe");
        }
    }

    @Override
    public void alert(String s) {
        Alert aler = new Alert(Alert.AlertType.NONE);
        aler.setAlertType(Alert.AlertType.ERROR);
        aler.setTitle("Error");
        aler.setHeaderText(s);
        aler.show();
    }

    @Override
    public void start(Spieler spieler1, Spieler spieler2) {
        Spiel s = new Spiel();
        spieler1.setNickname(name1.getText());
        spieler2.setNickname(name2.getText());
        s.zufallsgenerator();
        name1.setText("");
        name2.setText("");
    }
}
