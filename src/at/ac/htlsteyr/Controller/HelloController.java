package at.ac.htlsteyr.Controller;

import at.ac.htlsteyr.HelloApplicationGUI;
import at.ac.htlsteyr.Model.Feld;
import at.ac.htlsteyr.Model.Spiel;
import at.ac.htlsteyr.Model.Spieler;
import at.ac.htlsteyr.View.FeldView;
import at.ac.htlsteyr.View.FeldViewGui;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;


public class HelloController {
    public Button Menue;
    @FXML
    private javafx.scene.layout.VBox VBox;
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
    public Label ueberschrift;
    public Button start;
    public Button restart1;
    public Button choosecolour;
    Spieler spieler1 = new Spieler();
    Spieler spieler2 = new Spieler();
    Spiel s = new Spiel();
    FeldView fv = new FeldViewGui(ueberschrift);
    Circle[][] a = new Circle[10][10];


    /**
     * reagiert auf klicken eines buttons und wirft entsprechend den Spielstein in das Spielfeld
     * prüft ob:
     * die spalte voll ist
     * jemand gewonnen hat
     * name farbe eingegeben wurde
     * unentschieden gespielt wurde
     */
    public void buttonclick(ActionEvent actionEvent) {
        if (!(Spiel.füllungspalten[0] == 6 && Spiel.füllungspalten[1] == 6 && Spiel.füllungspalten[2] == 6 && Spiel.füllungspalten[3] == 6
                && Spiel.füllungspalten[4] == 6 && Spiel.füllungspalten[5] == 6 && Spiel.füllungspalten[6] == 6)) {

            if (spieler1.getNickname() != null && spieler2.getNickname() != null && spieler1.getSpielstein() != 0 && spieler1.getSpielstein() != 0 && !s.checkwin()) {

                Feld.spalten = Integer.parseInt(((Button) actionEvent.getSource()).getId().substring(6));

                if (Spiel.füllungspalten[Feld.spalten - 1] < 6) {
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
                        fv.display(spieler1, spieler2);
                    }

                    Spiel.spielertausch();
                    fv.spielertausch(spieler1, spieler2);

                } else {
                    fv.alert("Spalte voll!");
                }
            } else {
                fv.alert("Name/Farbe eingeben");
            }
        } else {
            fv.alert("Unentschieden");
        }

    }

    /**
     * startet das Spiel neu
     */
    public void restart(ActionEvent actionEvent) throws IOException {
        Feld.spalten = 0;
        Feld.spielfeld = new int[6][7];
        Spiel.füllungspalten = new int[7];

        Stage stage = new Stage();

        Stage stageclose = (Stage) restart1.getScene().getWindow();
        stageclose.close();

        final FXMLLoader fxmlLoader = new FXMLLoader();
        URL u = HelloApplicationGUI.class.getResource("hello-view.fxml");
        System.out.println(new File("").getAbsolutePath());
        System.out.println(u);
        fxmlLoader.setLocation(u);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("VierGewinnt");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initialisiert handle und prüfft ob in das Spielfeld gedrückt wurde und nicht außerhalb
     * Initialisiert die Kreise
     */
    public void initialize() {
        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int x2 = 64;
                int x = 36;

                if (mouseEvent.getY() > 113 && mouseEvent.getY() < 147) {
                    if ((mouseEvent.getX() > x && mouseEvent.getX() < x2) || (mouseEvent.getX() > x + 100 && mouseEvent.getX() < x2 + 100)
                            || (mouseEvent.getX() > x + 200 && mouseEvent.getX() < x2 + 200) || (mouseEvent.getX() > x + 300 && mouseEvent.getX() < x2 + 300)
                            || (mouseEvent.getX() > x + 400 && mouseEvent.getX() < x2 + 400) || (mouseEvent.getX() > x + 500 && mouseEvent.getX() < x2 + 500)
                            || (mouseEvent.getX() > x + 600 && mouseEvent.getX() < x2 + 600)) {
                        //im Spielfeld!
                    } else {
                        fv.alert("Nicht im Spielfeld");
                    }
                } else {
                    fv.alert("Nicht im Spielfeld");
                }
            }

        };
        VBox.addEventFilter(MouseEvent.MOUSE_CLICKED, eh);
        fv = new FeldViewGui(ueberschrift);
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

    /**
     * startet das Spiel
     */
    public void start(ActionEvent actionEvent) {
        fv.start(spieler1, spieler2);
    }

    /**
     * setzt die farbe des Spielers der an der Reihe ist
     */
    public void choosecolour(ActionEvent actionEvent) {
        ArrayList<String> choices = new ArrayList<>();

        choices.add("Red");
        choices.add("Blue");


        ChoiceDialog<String> dialog = new ChoiceDialog<>("Colour", choices);
        dialog.setTitle("Choose");
        dialog.setHeaderText("Choose Dialog");
        dialog.setContentText("Choose your colour:");

        Optional<String> result = dialog.showAndWait();

        if (result.get().equals("Red")) {
            if (!Spiel.spieler1) {
                System.out.println("Spieler 1 Rot");
                spieler1.setSpielstein('r');
                spieler2.setSpielstein('b');
            } else {
                spieler2.setSpielstein('r');
                spieler1.setSpielstein('b');
            }
        } else if (result.get().equals("Blue")) {
            if (!Spiel.spieler1) {
                System.out.println("Spieler 1 Blau");
                spieler1.setSpielstein('b');
                spieler2.setSpielstein('r');
            } else {
                spieler2.setSpielstein('b');
                spieler1.setSpielstein('r');
            }
        }
    }

    /**
     * zeigt das Menü mit Spielanleitung an
     */
    public void Menue(ActionEvent actionEvent) {
        Alert aler = new Alert(Alert.AlertType.NONE);
        aler.setAlertType(Alert.AlertType.INFORMATION);
        aler.setTitle("Info");
        aler.setHeaderText("1) Klicken sie StartGame und geben sie ihren Spielnamen an \n" +
                "2) Klicken sie ChooseColour um ihre Speilsteinfarbe zu wählen \n" +
                "3) Klicken sie Restart um das Spiel neu zu Starten \n" +
                "4) Der aktive Spieler wird oben links angezeigt \n" +
                "5) Um einen Stein zu werfen müssen sie die Pfeiltaste drücken, die sich über ihrer gewüschten Spalte befindet \n" +
                "6) Um während des Spiels den Spielnamen zu ändern klicken Sie StartGame\n" +
                "6) Um während des Spiels die Farbe zu ändern klicken Sie ChooseColour"
        );
        aler.show();
    }
}