package fr.massi.Exceptions;

public class TikTakToeAddElementException extends Exception {

    int i;
    int j;

    public TikTakToeAddElementException(int i, int j) {
        super();
        this.i = i;
        this.j = j;
    }

    public String getMessage(){
        return "Case " + i + "  " + j + " is Not Empty";
    }
}
