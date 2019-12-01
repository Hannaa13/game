import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  {
        Game game = new Game();
        try {
            game.choice();
        } catch (ArrayIndexOutOfBoundsException | IOException a) {
            System.out.println("Не корректное введение данных");
        }

    }
}
