package fr.massi.Services;

import fr.massi.Game;
import fr.massi.models.Symbol;

public class AIService {

    public void autoPlay(Game game) {
        try {
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    if(game.getGameValues()[i][j] == null) {
                        Game gameCopy = new Game(game.getGameValues());
                        gameCopy.addElementToGame(i, j , Symbol.O);
                        if(rescurse(gameCopy, Symbol.O, Symbol.X)) {
                            game.addElementToGame(i, j , Symbol.O);
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("unexpected error " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean rescurse(Game game, Symbol lastPlayed, Symbol toPlay) throws Exception{
        if(game.isWiner(Symbol.O)) return true;
        if(game.isWiner(Symbol.X)) return false;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(game.getGameValues()[i][j]  == null) {
                    Game gameCopy = new Game(game.getGameValues());
                    gameCopy.addElementToGame(i, j , toPlay);
                    if(rescurse(gameCopy, toPlay, lastPlayed)) {
                        game.addElementToGame(i, j , lastPlayed);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
