package ticTacToeGame;

class PlaceTemplate {

    int errorCode = 0;
    char[] field;

    public PlaceTemplate(int errorCode) {
        this.errorCode = errorCode;
    }

    public PlaceTemplate(char[] field) {
        errorCode = 0;
        this.field = field;
    }

}