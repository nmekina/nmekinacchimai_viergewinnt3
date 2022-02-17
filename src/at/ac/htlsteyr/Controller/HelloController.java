package at.ac.htlsteyr.Controller;

import at.ac.htlsteyr.HelloApplicationGUI;
import at.ac.htlsteyr.Model.Feld;
import at.ac.htlsteyr.Model.Spiel;
import at.ac.htlsteyr.Model.Spieler;
import at.ac.htlsteyr.View.FeldView;
import at.ac.htlsteyr.View.FeldViewGui;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;


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
    public TextField nauswahl1;
    public Label ueberschrift;
    public Button restart;
    public Button start;
    public Button restart1;
    public Button choosecolour;
    Spieler spieler1 = new Spieler();
    Spieler spieler2 = new Spieler();
    Spiel s = new Spiel();
    FeldView fv = new FeldViewGui(ueberschrift, nauswahl, nauswahl1);
    Circle[][] a = new Circle[10][10];



    public void ueberschrift(MouseEvent mouseEvent) {
    }


    public void buttonclick(ActionEvent actionEvent) {
        if (spieler1.getNickname() != null && spieler2.getNickname() != null && spieler1.getSpielstein() != 0 && spieler1.getSpielstein() != 0 && !s.checkwin()) {

            Feld.spalten = Integer.parseInt(((Button) actionEvent.getSource()).getId().substring(6));

            if (Spiel.füllungspalten[Feld.spalten - 1] <= 5) {
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

    }

    public void restart(ActionEvent actionEvent) throws IOException {
        Feld.spalten = 0;
        Feld.spielfeld = new int[6][7];
        Spiel.füllungspalten = new int[7];

        Stage stage = new Stage();

        Stage stageclose = (Stage) restart.getScene().getWindow();
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

    public void initialize() {
        fv = new FeldViewGui(ueberschrift, nauswahl, nauswahl1);
    }

    public void start(ActionEvent actionEvent) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Look, a Custom Login Dialog");

// Set the icon (must be included in the project).


// Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);


        TextField playername1 = new TextField();
        playername1.setPromptText("Playername1");
        TextField playername2 = new TextField();
        playername2.setPromptText("Playername2");

        grid.add(new Label("Playername1:"), 0, 0);
        grid.add(playername1, 1, 0);
        grid.add(new Label("Playername2:"), 0, 1);
        grid.add(playername2, 1, 1);
        spieler1.setNickname(playername1.getText());
        spieler2.setNickname(playername2.getText());

// Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        playername1.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> playername1.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(playername1.getText(), playername2.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword -> {
            System.out.println("Playername1=" + usernamePassword.getKey() + ", Playername2=" + usernamePassword.getValue());
        });



        fv.spielertausch(spieler1, spieler2);

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

    public void choosecolour(ActionEvent actionEvent) {
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Red");
        choices.add("Blue");


        ChoiceDialog<String> dialog = new ChoiceDialog<>("b", choices);
        dialog.setTitle("Choose");
        dialog.setHeaderText("Choose Dialog");
        dialog.setContentText("Choose your colour:");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Your choice: " + result.get());
        }
        if (result.get().equals("Red")) {
            spieler1.setSpielstein('r');
            spieler2.setSpielstein('b');
        }
        if (result.get().equals("Blue")) {
            spieler1.setSpielstein('r');
            spieler2.setSpielstein('b');
        }

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(letter -> System.out.println("Your choice: " + letter));
    }
}