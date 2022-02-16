package at.ac.htlsteyr;

import at.ac.htlsteyr.Model.Feld;
import at.ac.htlsteyr.Model.Spiel;
import at.ac.htlsteyr.Model.Spieler;
import at.ac.htlsteyr.View.FeldView;
import at.ac.htlsteyr.View.FeldViewConsole;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class
HelloApplicationGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader() //getClass().getResource("hello-view.fxml"));
        final FXMLLoader fxmlLoader = new FXMLLoader();
        URL u = HelloApplicationGUI.class.getResource("hello-view.fxml");
        System.out.println(new File("").getAbsolutePath());
        System.out.println(u);
        fxmlLoader.setLocation(u);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("VierGewinnt");
        stage.setScene(scene);
        stage.show();


        Spieler spieler1 = new Spieler();
        Spieler spieler2 = new Spieler();
        Spiel s = new Spiel();
        FeldView fw = new FeldViewConsole();


        System.out.println("Name: Spieler1: ");
        Scanner scannerspieler1 = new Scanner(System.in);
        spieler1.setNickname(scannerspieler1.next());



        do {

            System.out.println("Name: Spieler2: ");
            Scanner scannerspieler2 = new Scanner(System.in);
            spieler2.setNickname(scannerspieler2.next());

        } while (spieler1.getNickname().equals(spieler2.getNickname()));


        s.zufallsgenerator();


        if (Spiel.spieler1 == true) {
            System.out.println(spieler1.getNickname() + " beginnt: Spielstein(x/o) wählen: ");
            Scanner scannerspielstein = new Scanner(System.in);

            if (scannerspielstein.next().charAt(0) == 'x') {
                spieler1.setSpielstein('x');
                spieler2.setSpielstein('o');
            } else {
                spieler1.setSpielstein('o');
                spieler2.setSpielstein('x');
            }
        } else if (Spiel.spieler2 == true) {
            System.out.println(spieler2.getNickname() + " beginnt: Spielstein(x/o) wählen: ");
            Scanner scannerspielstein = new Scanner(System.in);
            if (scannerspielstein.next().charAt(0) == 'x') {
                spieler2.setSpielstein('x');
                spieler1.setSpielstein('o');
            } else {
                spieler2.setSpielstein('o');
                spieler1.setSpielstein('x');
            }
        }

        while (s.checkwin() == false) {
            fw.display(spieler1, spieler2);
            spalteneingabe(spieler1, spieler2);
            s.werfen();
            s.spielertausch();
        }


        if (Spiel.spieler1) {
            System.out.println(spieler1.getNickname() + " hat gewonnen!");
        } else {
            System.out.println(spieler2.getNickname() + " hat gewonnen!");
        }

        System.out.println("Wollen Sie erneut spielen? (Ja(j), Nein(nicht j)");
        Scanner scannerneustart = new Scanner(System.in);
        if (scannerneustart.next().charAt(0) == 'j') {
            Feld.spalten = 0;
            Feld.spielfeld = new int[6][7];
            Spiel.füllungspalten = new int [7];
            launch();
        }

    }

    public static void main(String[] args) {
        launch();
    }


    public static void spalteneingabe(Spieler spieler1, Spieler spieler2) {
        Feld.spalten = 0;
        String EingabeA;

        if (Spiel.spieler1 == true) {

            System.out.println(spieler1.getNickname() + " bitte Spaltennummer angeben: ");
            Scanner sc = new Scanner(System.in);
            EingabeA = sc.next();
        } else {
            System.out.println(spieler2.getNickname() + " bitte Spaltennummer angeben: ");
            Scanner sc = new Scanner(System.in);
            EingabeA = sc.next();
        }

        if (EingabeA.charAt(0) == 'R') {
            Feld.spalten = 0;
            Feld.spielfeld = new int[6][7];
            Spiel.füllungspalten = new int [7];
            launch();
        }

        if (!(EingabeA.charAt(0) > '0' && EingabeA.charAt(0) < '8')) {
            System.out.println("Achtung! Zahlen eingeben");
            spalteneingabe(spieler1, spieler2);
        } else {
            Feld.spalten = Integer.parseInt(EingabeA);

            if (Feld.spalten < 1 || Feld.spalten > 7) {
                System.out.println("Achtung! Die eingegebene Spaltennummer muss zwischen 1 und 7 liegen!");
                spalteneingabe(spieler1, spieler2);
            } else if (Spiel.füllungspalten[Feld.spalten - 1] > 5) {
                System.out.println("Spalte voll!!!!");
                spalteneingabe(spieler1, spieler2);
            } else {
                Spiel.füllungspalten[Feld.spalten - 1]++;
            }
        }
    }
}