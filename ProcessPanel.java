package ticTacToeGame;

public class ProcessPanel {
    GameErrors gameErrors;

    public ProcessPanel() {
        gameErrors = new GameErrors();
    }

    public PlaceTemplate placeChar(char[] field, int axisY, int axisX, char ch) {

        char previousCh = field[axisY * 3 + axisX];
        if (previousCh != 'X' && previousCh != 'O') {
            field[axisY * 3 + axisX] = ch;
            return new PlaceTemplate(field);
        } else {
            return new PlaceTemplate(999);
        }

    }

    public String whoWin(char[] field) {
        String whoWon = "null";

        char[][] charsDimension = new char[3][3];
        int xCount = 0, oCount = 0;

        for (int i = 0; i < 9; i++) {
            charsDimension[i / 3][i % 3] = field[i];
            if (field[i] == 'X') xCount++;
            else if (field[i] == 'O') oCount++;
        }

        int lCross = 0, rCross = 0;

        final int ASCIIX = 88*3, ASCIIO = 79 * 3;

        for (int i = 0; i < 3; i++) {

            int horizontal = 0, vertical = 0;

            lCross += charsDimension[i][i];
            rCross += charsDimension[i][2 - i];

            for (int j = 0; j < 3; j++) {
                horizontal += charsDimension[i][j];
                vertical += charsDimension[j][i];
            }
            whoWon = horizontal == ASCIIX | vertical == ASCIIX |
                    lCross == ASCIIX | rCross == ASCIIX ? "X" : whoWon;

            whoWon = horizontal == ASCIIO | vertical == ASCIIO |
                    lCross == ASCIIO | rCross == ASCIIO ?
                    (whoWon.equals("X") ? "XO" : "O") : whoWon;

        }



        whoWon = whoWon.equals("X") ? "X wins" : whoWon.equals("O") ? "O wins" :
                        xCount + oCount == 9 ? "Draw" : "null";

        return whoWon;
    }

    public String writeField(char[] field){

        StringBuilder printField = new StringBuilder();
        if (
                String.valueOf(field).replace("O", "")
                .replace("X", "")
                .replace("_", "").equals("")
        ) {
            printField.append("---------\n");

            for (int i = 0; i < 9;) {
                printField.append("| %s %s %s |\n".
                        formatted(field[i],field[i+1],field[i+2]));
                i+=3;
            }
            printField.append("---------\n");
        }
        return printField.toString();
    }

    public String getErrorByIndex(int index) {
        return gameErrors.getErrors().get(index);
    }
}



