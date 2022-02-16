package at.ac.htlsteyr.Controller;

import at.ac.htlsteyr.Model.Feld;
import at.ac.htlsteyr.Model.Spiel;
import at.ac.htlsteyr.Model.Spieler;
import at.ac.htlsteyr.View.FeldView;
import at.ac.htlsteyr.View.FeldViewGUI;
import com.sun.jdi.IntegerValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        a[0][0]=k01;
        a[0][1]=k02;
        a[0][2]=k03;
        a[0][3]=k04;
        a[0][4]=k05;
        a[0][5]=k06;

        a[1][0]=k11;
        a[1][1]=k12;
        a[1][2]=k13;
        a[1][3]=k14;
        a[1][4]=k15;
        a[1][5]=k16;

        a[2][0]=k21;
        a[2][1]=k22;
        a[2][2]=k23;
        a[2][3]=k24;
        a[2][4]=k25;
        a[2][5]=k26;

        a[3][0]=k31;
        a[3][1]=k32;
        a[3][2]=k33;
        a[3][3]=k34;
        a[3][4]=k35;
        a[3][5]=k36;

        a[4][0]=k41;
        a[4][1]=k42;
        a[4][2]=k43;
        a[4][3]=k44;
        a[4][4]=k45;
        a[4][5]=k46;

        a[5][0]=k51;
        a[5][1]=k52;
        a[5][2]=k53;
        a[5][3]=k54;
        a[5][4]=k55;
        a[5][5]=k56;

        a[6][0]=k61;
        a[6][1]=k62;
        a[6][2]=k63;
        a[6][3]=k64;
        a[6][4]=k65;
        a[6][5]=k66;

        Spiel spiel = new Spiel();
        Feld.spalten = Integer.parseInt(((Button) actionEvent.getSource()).getId().substring(6));
        Spiel.füllungspalten[Feld.spalten - 1]++;
        spiel.werfen();


        for (int z = 0; z <= 5; z++) {
            for (int s = 0; s <= 6; s++) {
                if (Feld.spielfeld[z][s] == 1) {
                    a[s][z].setFill(Paint.valueOf("#40E0d0"));
                } else if (Feld.spielfeld[z][s] == 2) {
                    a[s][z].setFill(Paint.valueOf("#F08080"));
                }
            }
        }


        if (spiel.checkwin()) {

            ueberschrift.setText(" hat gewonnen!");
        }
        Spiel.spielertausch();
    }

}

