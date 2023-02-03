package ticTacToeGame;

import java.util.*;

class TicTacToeGame{
    private static ProcessPanel process;

    public static void main(String[] args) {
        process = new ProcessPanel();
        Scanner scanner = new Scanner(System.in);
        char[] field = new char[9];

        for (int i = 0; i < field.length; i++) {
            field[i] = '_';
        }

        System.out.println(process.writeField(field));
        int axisY = 0, axisX = 0, error = 0, fullField = 0;

        while (fullField != 9) {
            System.out.print("> ");
            String scannerY = scanner.next();
            String scannerX = scanner.next();
            if (scannerX.matches("\\d+") && scannerY.matches("\\d+")) {
                axisY = Integer.parseInt(scannerY) - 1;
                axisX = Integer.parseInt(scannerX) - 1;
            } else {
                error = 1;
            }

            if (axisX > 2 || axisX < 0 || axisY > 2 || axisY < 0) {
                error = error == 0 ? 3 : error;
            }

            if (error == 0) {
                PlaceTemplate placeTemp =
                        process.placeChar(field.clone(), axisY, axisX, fullField % 2 == 0 ? 'X' : 'O');
                if (placeTemp.errorCode == 0) {
                    field = placeTemp.field;
                    System.out.println(process.writeField(field));
                    fullField++;
                } else {
                    error = 2;
                }

                String whoWin = process.whoWin(field);
                if (!whoWin.equals("null")) {
                    System.out.println(whoWin);
                    break;
                }

            }

            if (error != 0) {
                System.out.println(process.getErrorByIndex(error - 1));
            }
            error = 0;

        }


    }
}