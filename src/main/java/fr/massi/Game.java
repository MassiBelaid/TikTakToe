package fr.massi;

import fr.massi.Exceptions.TikTakToeAddElementException;
import fr.massi.models.Symbol;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
public class Game {
    public static final String STRING_GAME_SEPARATOR = " | ";


    private Symbol[][] gameValues = new Symbol[3][3];

    public Game() {

    }

    public Game(Symbol[][] gv) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) this.gameValues[i][j] = gv[i][j];
        }
    }


    @Override
    public String toString() {
        return
                getCaseFromGame(0, 0) + STRING_GAME_SEPARATOR + getCaseFromGame(0, 1) + STRING_GAME_SEPARATOR + getCaseFromGame(0, 2) + "\n" +
                getCaseFromGame(1, 0) + STRING_GAME_SEPARATOR + getCaseFromGame(1, 1) + STRING_GAME_SEPARATOR + getCaseFromGame(1, 2) + "\n" +
                getCaseFromGame(2, 0) + STRING_GAME_SEPARATOR + getCaseFromGame(2, 1) + STRING_GAME_SEPARATOR + getCaseFromGame(2, 2);
    }


    public String getCaseFromGame(int i, int j){
        return gameValues[i][j] == null ? " " : gameValues[i][j].stringValue;
    }

    public void addElementToGame(int i, int j, Symbol value) throws TikTakToeAddElementException{
        if(gameValues[i][j] == null) {
            gameValues[i][j] = value;
        } else {
            throw new TikTakToeAddElementException(i,j);
        }
    }

    public boolean isGameComplete() {
        if(isWiner(Symbol.X)) return true;
        if(isWiner(Symbol.O)) return true;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(gameValues[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWiner(Symbol player) {
        boolean win = false;
        for(int i = 0; i<3; i++) {
            if(gameValues[i][0] == gameValues[i][1] && gameValues[i][0] == gameValues[i][2] && gameValues[i][0] == player) win = true;
            if(gameValues[0][i] == gameValues[1][i] && gameValues[0][i] == gameValues[2][i] && gameValues[0][i] == player) win = true;
        }
        if(gameValues[0][0] == gameValues[1][1] && gameValues[0][0] == gameValues[2][2] && gameValues[0][0] == player) win = true;
        if(gameValues[0][2] == gameValues[1][1] && gameValues[0][2] == gameValues[2][0] && gameValues[0][2] == player) win = true;
        //if (win) System.out.println(player + " WIN");
        return win;
    }
}
