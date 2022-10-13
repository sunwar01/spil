package com.example.spil;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.LinkedList;
import java.util.Objects;

public class Spillet {

    public int BrikkerTilbage = 6;
    public String NæsteSpiller = "X";
    public int nuværendeSpiller = 0;
    public String guiVinder = "";
    public boolean enDerHarVundet = false;



    /*
    Her har vi tjekvinder funktionen, hvor vi bruger de har strings fra spilController, så vi kan aflæse felterne i vores spil,
    uden at lave det i controlleren.

    Vi laver her nogle kombinationer man kan vinde på, og dem laver vi ud fra vores felter, hvor vi får en tekst fra.

    Bagefter sætter vi disse kombinationer ind i en liste. Derefter checker vi om der er nogen af de her kombinationer der er lig med
    X,X,X eller O,O,O. Hvis der er en der er lig med det, opdatere vi vores guivinder med hvem der har vundet x eller o, og så sætter vi enDerHarVundet til true.

    Dette gør vi, så vores guilabelvinder, bliver opdateret i vores gui.

    Grunden til vi har enDerHarVundet, er fordi vi ikke vil have at vores guilabelvinder bliver opdateret hele tiden, og også fordi at så har vi en måde at
    fjerne det igen, når man starter et nyt spil.


     */
    public void tjekVinder(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9) {

        String winCombo1 = s1 + s2 + s3;
        String winCombo2 = s4 + s5 + s6;
        String winCombo3 = s7 + s8 + s9;
        String winCombo4 = s1 + s4 + s7;
        String winCombo5 = s2 + s5 + s8;
        String winCombo6 = s3 + s6 + s9;
        String winCombo7 = s1 + s5 + s9;
        String winCombo8 = s3 + s5 + s7;



        LinkedList<String>  winCombos = new LinkedList<String>();

        winCombos.add(winCombo1);
        winCombos.add(winCombo2);
        winCombos.add(winCombo3);
        winCombos.add(winCombo4);
        winCombos.add(winCombo5);
        winCombos.add(winCombo6);
        winCombos.add(winCombo7);
        winCombos.add(winCombo8);


        for(String w : winCombos){
            if (w.equals("XXX")){

                guiVinder = "X";
                enDerHarVundet = true;


            }else if (w.equals("OOO")){

                guiVinder = "O";
                enDerHarVundet = true;


            }


        }


    }


    /*
    Her har vi alt det der sker, når vi trykker på et af felterne, altså selve spil logikken.
    Her bruger vi eksempelvis nuværende spiller, til at skifte mellem hvem der skal sætte en brik.
    Brikkertilbage, bruger til at holde styr på at der kun er 6 brikker i spillet ad gangen.
    Næstespiller bruger vi til at opdatere vores guiInfoLabel, så vi kan holde styr på hvems tur det er.
    Vi bruger her også ((Button)event.getSource()).getText() til at vide om den knap vi trykker på er lige med noget.
    Dette gør vi for at X ikke kan fjerne o's brikker og omvendt. Det gør vi også for at man ikke man kan fjerne et tomt felt,
    og så have mere end 6 brikker i spil.


     */
    public void bestemSymbol(ActionEvent event) {

        String pressedButtonText = ((Button)event.getSource()).getText();




     if(nuværendeSpiller % 2 == 0 && BrikkerTilbage > 0 && BrikkerTilbage <= 6 && pressedButtonText.equals("")){
         ((Button)event.getSource()).setText("X");
         NæsteSpiller = "O";
         nuværendeSpiller = 1;
         BrikkerTilbage = BrikkerTilbage -1;


     } else if(nuværendeSpiller % 2 == 0 && BrikkerTilbage == 0 && !pressedButtonText.equals("O") && !pressedButtonText.equals("")){
         ((Button)event.getSource()).setText("");
         BrikkerTilbage = BrikkerTilbage +1;

     } else if (nuværendeSpiller % 2 == 1 && BrikkerTilbage > 0 && BrikkerTilbage <= 6 &&  pressedButtonText.equals("")){
         ((Button)event.getSource()).setText("O");
         NæsteSpiller = "X";
         nuværendeSpiller = 0;
         BrikkerTilbage = BrikkerTilbage -1;

     }else if(nuværendeSpiller % 2 == 1 && BrikkerTilbage == 0 && !pressedButtonText.equals("X") &&  !pressedButtonText.equals("")){
         ((Button)event.getSource()).setText("");
         BrikkerTilbage = BrikkerTilbage +1;

     }
    }


/*
Her har vi nogen vi kalder spilFeltInput.
Denne er egentlig ikke nødvendig, vi kunne lige så godt bare køre BestemSymbol i stedet for spilFeltInput, men den er god at have,
hvis man nu skulle have flere ting med i fremtiden.
 */
    public void spilFeltInput(ActionEvent event) {
        bestemSymbol(event);
    }



}
