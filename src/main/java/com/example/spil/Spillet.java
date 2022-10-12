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



    public void spilFeltInput(ActionEvent event) {
        bestemSymbol(event);
    }



}
