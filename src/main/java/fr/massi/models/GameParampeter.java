package fr.massi.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameParampeter {
    PlayerType player1, player2;
    Symbol player1Symbol;

    private GameParampeter(){}

    public static GameParampeter initGame() {
        GameParampeter gameParampeter = new GameParampeter();
        gameParampeter.setPlayer1(PlayerType.PERSON);
        gameParampeter.setPlayer2(PlayerType.COMPUTER);
        gameParampeter.setPlayer1Symbol(Symbol.X);
        return gameParampeter;
    }

    public Symbol getPlayer2Symbol() {
        return player1Symbol == Symbol.X ? Symbol.O : Symbol.X;
    }
}
