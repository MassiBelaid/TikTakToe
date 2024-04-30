import fr.massi.Exceptions.TikTakToeAddElementException;
import fr.massi.Game;
import fr.massi.models.Symbol;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class GameTest {

    @Test
    void testToString() throws Exception {
        Game game = getGameWithValues(Symbol.O, Symbol.X, Symbol.O, Symbol.X,Symbol.O, Symbol.X, Symbol.O, Symbol.X, Symbol.O);

        String valueExpected = """
                O | X | O
                X | O | X
                O | X | O""";
        assertEquals(valueExpected, game.toString());
    }


    @Test
    void testAddingError() throws Exception {
        Game game = getGameWithValues(Symbol.X, Symbol.X, Symbol.X, Symbol.X,Symbol.O, Symbol.X, Symbol.O, Symbol.X, Symbol.O);

        assertThrows(TikTakToeAddElementException.class, () -> game.addElementToGame(0,0, Symbol.X));
    }
    @Test
    void testIsCompleteTrueWinner() throws Exception {
        Game game = getGameWithValues(Symbol.X, null, Symbol.O, Symbol.X,Symbol.X, Symbol.O, Symbol.O, Symbol.X, Symbol.X);

        assertTrue(game.isGameComplete());
    }

    @Test
    void testIsCompleteTrue() throws Exception {
        Game game = getGameWithValues(Symbol.O, Symbol.X, Symbol.O, Symbol.O,Symbol.X, Symbol.X, Symbol.X, Symbol.O, Symbol.X);

        assertTrue(game.isGameComplete());
    }

    @Test
    void testIsCompleteFalse() throws Exception {
        Game game = getGameWithValues(Symbol.X, Symbol.O, Symbol.X, null,Symbol.O, Symbol.X, Symbol.O, Symbol.X, Symbol.O);

        assertFalse(game.isGameComplete());
    }

    @Test
    void testIsWinnerOne() throws Exception {
        Game game = getGameWithValues(Symbol.O, Symbol.X, Symbol.X, Symbol.X,Symbol.O, Symbol.X, Symbol.O, Symbol.X, Symbol.O);
        assertTrue(game.isWiner(Symbol.O));
        assertFalse(game.isWiner(Symbol.X));
    }

    @Test
    void testIsWinnerTwo() throws Exception {
        Game game = getGameWithValues(Symbol.X, Symbol.X, Symbol.X, Symbol.X,Symbol.O, Symbol.X, Symbol.O, Symbol.X, Symbol.O);

        assertFalse(game.isWiner(Symbol.O));
        assertTrue(game.isWiner(Symbol.X));
    }


    private Game getGameWithValues(Symbol one, Symbol two, Symbol three, Symbol four, Symbol five, Symbol six, Symbol seven, Symbol eight, Symbol nine) throws Exception{
        Game game = new Game();
        game.addElementToGame(0,0, one);
        game.addElementToGame(0,1, two);
        game.addElementToGame(0,2, three);
        game.addElementToGame(1,0, four);
        game.addElementToGame(1,1, five);
        game.addElementToGame(1,2, six);
        game.addElementToGame(2,0, seven);
        game.addElementToGame(2,1, eight);
        game.addElementToGame(2,2, nine);

        return game;
    }
}
