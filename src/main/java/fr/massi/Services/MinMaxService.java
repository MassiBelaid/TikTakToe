package fr.massi.Services;

import fr.massi.Game;
import fr.massi.models.MinMaxNode;
import fr.massi.models.Symbol;

public class MinMaxService {

    public void autoPlay(Game game, Symbol symbol) {
        try {
            MinMaxNode score = maxIteration(game, symbol);
            game.addElementToGame(score.getI(), score.getJ(), Symbol.O);
        } catch (Exception e) {
            System.out.println("unexpected error " + e.getMessage());
        }
    }

    private MinMaxNode maxIteration(Game game, Symbol symbol) throws Exception{
        if(game.isWiner(Symbol.O)) return new MinMaxNode(null, null, 1);
        if(game.isWiner(Symbol.X)) return new MinMaxNode(null, null, -1);
        if(game.isGameComplete()) return new MinMaxNode(null, null, 0);
        MinMaxNode minMaxNode = new MinMaxNode(null, null, -100000000);
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(game.getGameValues()[i][j]  == null) {
                    Game gameCopy = new Game(game.getGameValues());
                    gameCopy.addElementToGame(i, j , symbol);
                    MinMaxNode score = minIteration(gameCopy, symbol);
                    if(minMaxNode.getValue() < score.getValue()) {
                        minMaxNode.setValue(score.getValue());
                        minMaxNode.setI(i);
                        minMaxNode.setJ(j);
                    }
                }
            }
        }
        return minMaxNode;
    }


    private MinMaxNode minIteration(Game game, Symbol symbol) throws Exception{
        if(game.isWiner(Symbol.O)) return new MinMaxNode(null, null, 1);
        if(game.isWiner(Symbol.X)) return new MinMaxNode(null, null, -1);
        if(game.isGameComplete()) return new MinMaxNode(null, null, 0);
        MinMaxNode minMaxNode = new MinMaxNode(null, null, 100000000);
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(game.getGameValues()[i][j]  == null) {
                    Game gameCopy = new Game(game.getGameValues());
                    gameCopy.addElementToGame(i, j , getNextSymbol(symbol));
                    MinMaxNode score = maxIteration(gameCopy, symbol);
                    if(minMaxNode.getValue() > score.getValue()) {
                        minMaxNode.setValue(score.getValue());
                        minMaxNode.setI(i);
                        minMaxNode.setJ(j);
                    }
                }
            }
        }
        return minMaxNode;
    }

    public Symbol getNextSymbol(Symbol symbol) {
        return symbol == Symbol.X ? Symbol.O : Symbol.X;
    }
}
