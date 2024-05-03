package fr.massi;

import fr.massi.Exceptions.TikTakToeAddElementException;
import fr.massi.Services.MinMaxService;
import fr.massi.models.GameParampeter;
import fr.massi.models.PlayerType;
import fr.massi.models.Symbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Game starting");
        Game game = new Game();
        GameParampeter gameParampeter = GameParampeter.initGame();

        boolean finish = false;

        System.out.println(game);
        while (!finish) {
            play(game, gameParampeter.getPlayer1(), gameParampeter.getPlayer1Symbol());
            finish = game.isGameComplete();
            System.out.println(game);
            if(!finish) {
                System.out.println("-------------------------------");
                play(game, gameParampeter.getPlayer2(), gameParampeter.getPlayer2Symbol());
                finish = game.isGameComplete();
                System.out.println(game);
            }
        }

        if(game.isWiner(Symbol.O)) System.out.println("O is the winner");
        else if(game.isWiner(Symbol.X)) System.out.println("X is the winner");
        else System.out.println("there is no winner");

    }

    public static void addElement(Game game, Symbol symbol) {
        boolean isValid = false;
        while (!isValid) {
            int i = getValueFromInput("Put valid i value");
            int j = getValueFromInput("Put valid j value");
            try {
                game.addElementToGame(i,j, symbol);
                isValid = true;
            } catch (TikTakToeAddElementException e) {
                System.out.println("This case is already taken");
                System.out.println(game);
            }
        }
    }


    public static int getValueFromInput(String message) {
        Scanner scanner = new Scanner(System.in);
        boolean validIn = false;
        String value = "";
        while (!validIn) {
            System.out.println(message);
            value = scanner.nextLine();
            if("0".equals(value) || "1".equals(value) || "2".equals(value)) {
                validIn = true;
            }
        }
        return Integer.parseInt(value);
    }


    public static void play(Game game, PlayerType playerType, Symbol symbol) {
        if(PlayerType.PERSON == playerType)
            addElement(game, symbol);
        else
            new MinMaxService().autoPlay(game, symbol);
    }
}
