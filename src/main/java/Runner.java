import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the game!");

        Game game = new Game();
        game.createPlayers();

        game.setInitialChips();

        game.play();

    }

}
