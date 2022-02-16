package at.ac.htlsteyr.Controller;

import at.ac.htlsteyr.HelloApplicationGUI;
import at.ac.htlsteyr.Model.Feld;
import at.ac.htlsteyr.Model.Spiel;
import at.ac.htlsteyr.Model.Spieler;
import at.ac.htlsteyr.View.FeldView;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class HelloController {
    public Button werfen1;
    public Button werfen2;
    public Button werfen3;
    public Button werfen4;
    public Button werfen5;
    public Button werfen6;
    public Button werfen7;
    public Circle k01;
    public Circle k02;
    public Circle k03;
    public Circle k04;
    public Circle k05;
    public Circle k06;
    public Circle k11;
    public Circle k12;
    public Circle k13;
    public Circle k14;
    public Circle k15;
    public Circle k16;
    public Circle k21;
    public Circle k22;
    public Circle k23;
    public Circle k24;
    public Circle k25;
    public Circle k26;
    public Circle k31;
    public Circle k32;
    public Circle k33;
    public Circle k34;
    public Circle k35;
    public Circle k36;
    public Circle k41;
    public Circle k42;
    public Circle k43;
    public Circle k44;
    public Circle k45;
    public Circle k46;
    public Circle k51;
    public Circle k52;
    public Circle k53;
    public Circle k54;
    public Circle k55;
    public Circle k56;
    public Circle k61;
    public Circle k62;
    public Circle k63;
    public Circle k64;
    public Circle k65;
    public Circle k66;
    public TextField nauswahl;
    public Button confirmbutton;
    public Button blau;
    public Button rot;
    public TextField nauswahl1;
    public Button confirmbutton3;
    public Label ueberschrift;
    public Button restart;
    Spieler spieler1 = new Spieler();
    Spieler spieler2 = new Spieler();
    Spiel s = new Spiel();
    Circle[][] a = new Circle[10][10];

    public void confirm() {
        spieler1.setNickname(nauswahl.getText());
        spieler2.setNickname(nauswahl1.getText());
        s.zufallsgenerator();
        nauswahl.setText("");
        nauswahl1.setText("");
        if (Spiel.spieler1) {
            ueberschrift.setText(spieler1.getNickname() + " ist an der Reihe:");
        } else if (Spiel.spieler2) {
            ueberschrift.setText(spieler2.getNickname() + " ist an der Reihe:");
        }


        a[0][0] = k01;
        a[0][1] = k02;
        a[0][2] = k03;
        a[0][3] = k04;
        a[0][4] = k05;
        a[0][5] = k06;

        a[1][0] = k11;
        a[1][1] = k12;
        a[1][2] = k13;
        a[1][3] = k14;
        a[1][4] = k15;
        a[1][5] = k16;

        a[2][0] = k21;
        a[2][1] = k22;
        a[2][2] = k23;
        a[2][3] = k24;
        a[2][4] = k25;
        a[2][5] = k26;

        a[3][0] = k31;
        a[3][1] = k32;
        a[3][2] = k33;
        a[3][3] = k34;
        a[3][4] = k35;
        a[3][5] = k36;

        a[4][0] = k41;
        a[4][1] = k42;
        a[4][2] = k43;
        a[4][3] = k44;
        a[4][4] = k45;
        a[4][5] = k46;

        a[5][0] = k51;
        a[5][1] = k52;
        a[5][2] = k53;
        a[5][3] = k54;
        a[5][4] = k55;
        a[5][5] = k56;

        a[6][0] = k61;
        a[6][1] = k62;
        a[6][2] = k63;
        a[6][3] = k64;
        a[6][4] = k65;
        a[6][5] = k66;
    }

    public void blau(ActionEvent actionEvent) {
        spieler1.setSpielstein('b');
        spieler2.setSpielstein('r');
    }

    public void rot(ActionEvent actionEvent) {
        spieler1.setSpielstein('r');
        spieler2.setSpielstein('b');
    }

    public void nameauswahl(ActionEvent actionEvent) {

    }

    public void ueberschrift(MouseEvent mouseEvent) {
    }


    public void buttonclick(ActionEvent actionEvent) {
        if (Spiel.spieler1) {
            ueberschrift.setText(spieler1.getNickname() + " ist an der Reihe:");
        } else if (Spiel.spieler2) {
            ueberschrift.setText(spieler2.getNickname() + " ist an der Reihe:");
        }

        if (spieler1.getSpielstein() == 'r' || spieler1.getSpielstein() == 'b')
        Feld.spalten = Integer.parseInt(((Button) actionEvent.getSource()).getId().substring(6));
        Spiel.füllungspalten[Feld.spalten - 1]++;
        s.werfen();

        for (int z = 0; z <= 5; z++) {
            for (int s = 0; s <= 6; s++) {
                if (Feld.spielfeld[z][s] == 1) {
                    if (spieler1.getSpielstein() == 'r') {
                        a[s][z].setFill(Paint.valueOf("#40E0d0"));
                    } else if (spieler1.getSpielstein() == 'b') {
                        a[s][z].setFill(Paint.valueOf("#F08080"));
                    }
                } else if (Feld.spielfeld[z][s] == 2) {
                    if (spieler2.getSpielstein() == 'r') {
                        a[s][z].setFill(Paint.valueOf("#40E0d0"));
                    } else if (spieler2.getSpielstein() == 'b') {
                        a[s][z].setFill(Paint.valueOf("#F08080"));
                    }
                }
            }
        }

        if (s.checkwin()) {
            if (Spiel.spieler1) {
                Alert aler = new Alert(Alert.AlertType.NONE);
                aler.setAlertType(Alert.AlertType.INFORMATION);
                aler.setTitle("Winner");
                aler.setContentText(spieler1.getNickname() + " hat gewonnen!");
                aler.show();
            } else {
                Alert aler = new Alert(Alert.AlertType.NONE);
                aler.setAlertType(Alert.AlertType.INFORMATION);
                aler.setTitle("Winner");
                aler.setContentText(spieler2.getNickname() + " hat gewonnen!");
                aler.show();
            }
        }
        Spiel.spielertausch();
    }

}

