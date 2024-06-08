import java.util.ArrayList;
import java.util.List;

public class Mahjong {
    public Mahjong() {
    }

    public static void main(String[] args) {
        List<Player> players = new ArrayList();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.add(new Player("Player 3"));
        players.add(new Player("Player 4"));
        MahjongGame game = new MahjongGame(players);
        game.startGame();
    }
}