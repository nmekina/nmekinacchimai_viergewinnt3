package at.ac.htlsteyr.View;

import at.ac.htlsteyr.Model.Spiel;
import at.ac.htlsteyr.Model.Spieler;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.util.Optional;
import java.util.Scanner;

public class FeldViewGui implements FeldView{
    Label ueberschrift;

    public FeldViewGui(Label ueberschrift) {
        this.ueberschrift = ueberschrift;
    }

    @Override
    /**
     * Wenn Wincon ausgelöst wird
     * Win alert welcher spieler gewonnen hat
     */
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

    /**
     *Aktiver Spieler wird ausgegeben
     */
    public void spielertausch(Spieler spieler1, Spieler spieler2) {
        if (Spiel.spieler1) {
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
    /**
     * Viergewinnt Nickname auswahl
     * Prüfen ob gültige Nickname auswahl
     * zufälliger Spieler startet
     *
     */
    public void start(Spieler spieler1, Spieler spieler2) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Viergewinnt Login");
        dialog.setHeaderText("Look, Viergewinnt Login Dialog");


        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

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

        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        playername1.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(() -> playername1.requestFocus());

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(playername1.getText(), playername2.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(aktivePlayer -> {
            System.out.println("Playername1=" + aktivePlayer.getKey() + ", Playername2=" + aktivePlayer.getValue());
            spieler1.setNickname(aktivePlayer.getKey());
            spieler2.setNickname(aktivePlayer.getValue());
            if (spieler1.getNickname().equals(spieler2.getNickname())) {
                start(spieler1, spieler2);
            }
        });

        Spiel s = new Spiel();
        s.zufallsgenerator();

        spielertausch(spieler1, spieler2);
    }
}
