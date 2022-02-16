package at.ac.htlsteyr.Controller;

import at.ac.htlsteyr.Model.Feld;
import at.ac.htlsteyr.Model.Spiel;
import at.ac.htlsteyr.Model.Spieler;
import at.ac.htlsteyr.View.FeldView;
import at.ac.htlsteyr.View.FeldViewGUI;
import com.sun.jdi.IntegerValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.lang.reflect.Array;
import java.util.Scanner;

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


    public void confirm() {
        Spieler spieler1 = new Spieler();
        Spieler spieler2 = new Spieler();
        Spiel s = new Spiel();
        FeldView fw = new FeldViewGUI();

        spieler1.setNickname("Nico");

        do {

            spieler2.setNickname("Chri");

        } while (spieler1.getNickname().equals(spieler2.getNickname()));


        s.zufallsgenerator();

        spieler1.setSpielstein('x');
        spieler2.setSpielstein('o');

/*
        while (s.checkwin() == false) {
            fw.display(spieler1, spieler2);
            spalteneingabe(spieler1, spieler2);
            s.werfen();
            s.spielertausch();
        }


        if (Spiel.spieler1) {
            ueberschrift.setText(spieler1.getNickname() + " hat gewonnen!");
        } else {
            ueberschrift.setText(spieler2.getNickname() + " hat gewonnen!");
        }

 */

        /*
        System.out.println("Wollen Sie erneut spielen? (Ja(j), Nein(nicht j)");
        Scanner scannerneustart = new Scanner(System.in);
        if (scannerneustart.next().charAt(0) == 'j') {
            Feld.spalten = 0;
            Feld.spielfeld = new int[6][7];
            Spiel.füllungspalten = new int [7];
            confirm();
        }
         */
    }

    public void blau(ActionEvent actionEvent) {
    }

    public void rot(ActionEvent actionEvent) {
    }

    public void ueberschrift(MouseEvent mouseEvent) {
    }

    public void nameauswahl(ActionEvent actionEvent) {
    }

    public void buttonclick(ActionEvent actionEvent) {
        Circle[][] a = new Circle[10][10];
        a[0][1]=k01;
        a[0]=k06;
        a[0].setFill(Paint.valueOf("#15ff00"));

        a[0][6].setFill(Paint.valueOf("#15ff00"));
        // setFill(Paint.valueOf("#15ff00"));
        Spiel s = new Spiel();
        Feld.spalten = Integer.parseInt(((Button) actionEvent.getSource()).getId().substring(6));
        Spiel.füllungspalten[Feld.spalten - 1]++;
        s.werfen();
        if (s.checkwin()) {
            ueberschrift.setText(" hat gewonnen!");
        }
        Spiel.spielertausch();

        for (int zcounter = 0; zcounter < 6; zcounter++) {
            for (int scounter = 0; scounter < 7; scounter++) {
                String ktest = "k" + zcounter + scounter;

                for (int i = 0; i <= 6; i++) {
                    for (int j = 1; j <= 6; j++) {
                    if (ktest.equals("k"+i+j)) {

                        //a[0].setFill(Paint.valueOf("#15ff00"));
                    }
                }}

                if (Feld.spielfeld[zcounter][scounter] == 1) {

                } else if (Feld.spielfeld[zcounter][scounter] == 2) {

                }
            }
        }
    }

}

