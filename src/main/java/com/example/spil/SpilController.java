package com.example.spil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SpilController {

    private Spillet hent_fra_spil = new Spillet();

    @FXML
    private Button gui_felt_1;

    @FXML
    private Button gui_felt_2;

    @FXML
    private Button gui_felt_3;

    @FXML
    private Button gui_felt_4;

    @FXML
    private Button gui_felt_5;

    @FXML
    private Button gui_felt_6;

    @FXML
    private Button gui_felt_7;

    @FXML
    private Button gui_felt_8;

    @FXML
    private Button gui_felt_9;

    @FXML
    private Button gui_nyt_spil;


    @FXML
    private Label gui_info_label;

    @FXML
    private Label gui_vinder_label;


    /*
    Vi laver funktionen TjekStrings, for at kunne se hvad texten er i vores gui_felter i vores spil, så vi ikke laver spil logikken i controlleren.
     */
    public void TjekStrings(){
        hent_fra_spil.tjekVinder (gui_felt_1.getText(), gui_felt_2.getText() , gui_felt_3.getText() , gui_felt_4.getText() , gui_felt_5.getText() , gui_felt_6.getText() , gui_felt_7.getText() , gui_felt_8.getText() , gui_felt_9.getText());
    }


    /*
    Dette er det der sker hver gang vi trykker på et af felterne. Vi vi har altså sat denne handling ind i alle felterne.
     */
    @FXML
    void feltTrykket(ActionEvent event) {

        if (!hent_fra_spil.enDerHarVundet){
        hent_fra_spil.spilFeltInput(event);
        TjekStrings();
        opdaterGuiInfoLabelTur();
        opdaterGuiVinderLabel();
        }

    }


    /*
    Her nulstiller vi alle de værdier der skal nulstilles, når vi skal starte et nyt spil.
    Eksempelvis skal alle brikkerne fjernes/felterne skal være tomme.
    samt vi har nogen atributter, som bliver brugt i vores spil logik, som også skal nulstilles, da spillet ellers køre videre.
    Vi skal opdatere vores gui her, da hvis vi ikke gør dette, så ville der eksempelvis stadig stå at spiller x eller o har vundet i det næste spil.
     */
    @FXML
    void nytSpilKnapTrykket(ActionEvent event) {

        gui_felt_1.setText("");
        gui_felt_2.setText("");
        gui_felt_3.setText("");
        gui_felt_4.setText("");
        gui_felt_5.setText("");
        gui_felt_6.setText("");
        gui_felt_7.setText("");
        gui_felt_8.setText("");
        gui_felt_9.setText("");
        hent_fra_spil.NæsteSpiller = "X";
        hent_fra_spil.BrikkerTilbage = 6;
        hent_fra_spil.nuværendeSpiller = 0;
        hent_fra_spil.enDerHarVundet = false;
        opdaterGuiVinderLabel();
        opdaterGuiInfoLabelTur();

    }
/*
Her opdatere vi GuiVinderlabel, som er en label som er aktiv hele tiden, men der bliver kun vidst tekst,
når der er en spiller der har vundet. Derfor skal denne heller ikke køres i initialize,
da vi jo ikke har en vinder i starten
af spillet.
 */
    public void opdaterGuiVinderLabel(){

        if (hent_fra_spil.enDerHarVundet) {
            gui_vinder_label.setText("Spiller " + hent_fra_spil.guiVinder + " vandt!");
        }
        else gui_vinder_label.setText("");

    }


    /*
    Her opdatere vi vores GuiInfoLabel, som er en label, hvor man kan se hvilken spilleres tur det er.
    Her henter vi Næstespiller fra spillet.
     */
    public void opdaterGuiInfoLabelTur(){

        gui_info_label.setText("Spiller " + hent_fra_spil.NæsteSpiller + "'s tur");

    }

/*
Her er alt det der skal ske, når spillet starter.
 */
   public void initialize() {
       opdaterGuiInfoLabelTur();


    }


}
