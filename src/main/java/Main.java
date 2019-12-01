import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        try {
            game.choice();
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Не корректное число");
        }

    }
}
