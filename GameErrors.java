package ticTacToeGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GameErrors {

    private ArrayList<String> errorList = new ArrayList<String>(Arrays.asList(
            "You should enter numbers!",
            "This cell is occupied! Choose another one!",
            "Coordinates should be from 1 to 3!"
    ));


    public ArrayList<String> getErrors() {
        return (ArrayList<String>) errorList.clone();
    }



}
