import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MahjongGame {
    public List<Card> deck;
    public List<Player> players;
    public int currentPlayerIndex = 0;
    public Card lastDiscard; // To keep track of the cards played by the previous house


    public MahjongGame(List<Player> players) {
        this.players = players;
        this.deck = initializeDeck();
    }

    public List<Card> initializeDeck() {
        List<Card> deck = new ArrayList<>();

        // 添加万、条、筒牌（每种1~9各4张）
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new Card(i, "万"));
                deck.add(new Card(i, "条"));
                deck.add(new Card(i, "筒"));
            }
        }

        // 添加风牌（东西南北中发白各4张）
        String[] windTiles = {"东风", "西风", "南风", "北风", "红中", "发财", "白板"};
        for (String wind : windTiles) {
            for (int i = 0; i < 4; i++) {
                deck.add(new Card(null, wind));
            }
        }



        Collections.shuffle(deck);
        return deck;
    }

    public void startGame() {
        dealCards();
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Get current player
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("Current Player：" + currentPlayer.getName());

            // When processing card eating logic in the game loop, we need to check whether lastDiscard is empty
            // Determine whether the current player can eat cards
            if (lastDiscard != null && ChiChecker.canChi(currentPlayer.getHand(), lastDiscard)) {
                // Prompts the player whether to take a card
                // Players sort their hands
                currentPlayer.sortHand();
                //Print the cards in your hand
                System.out.println("hand：" + currentPlayer.getHand());
                System.out.println("You can eat the card now! Whether to eat the card (enter chi to eat the card, other means not to eat)：");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("chi")) {
                    // If the player chooses to eat a card, the card is eaten
                    ChiChecker.chi(currentPlayer.getHand(), lastDiscard);
                } else {
                    lastDiscard = null;
                    // If the player chooses not to take a card, the game continues
                }
            } else {
                // If the card cannot be eaten, the game continues
            }


            // Determine whether the current player's hand can touch cards
            if (currentPlayer.getHand().size() % 3 == 1) {
                Card drawnCard = drawCard(currentPlayer);
                System.out.println("The card that was touched：" + drawnCard);
            }

            // Players sort their hands
            currentPlayer.sortHand();
            System.out.println("hand：" + currentPlayer.getHand());

            // Check if the current player can dark bar
            if (GangChecker.canAnGang(currentPlayer.getHand())) {
                // Prompts the player whether to open a bar
                System.out.println("You can open the bar! Open bar or not (Enter gang to open bar)：");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("gang")) {
                    // Get the card to open
                    Card kongCard = null;
                    for (int i = 0; i < currentPlayer.getHand().size() - 3; i++) {
                        if (currentPlayer.getHand().get(i).equals(currentPlayer.getHand().get(i + 3))) {
                            kongCard = currentPlayer.getHand().get(i);
                            break;
                        }
                    }
                    if (kongCard != null) {
                        GangChecker.kaiAnGang(currentPlayer.getHand(), kongCard);
                        System.out.println("Successful bar. You opened four"+kongCard);
                        //Open the bar to make up the card
                        //Determine whether the current player's hand can touch cards
                        if (currentPlayer.getHand().size() % 3 == 1) {
                            Card drawnCard = drawCard(currentPlayer);
                            System.out.println("The card that was touched：" + drawnCard);
                        }

                        // Players sort their hands
                        currentPlayer.sortHand();
                        System.out.println("hand：" + currentPlayer.getHand());
                    }
                } else {
                    // If the player chooses to leave the bar open, the game continues
                }
            }

            // Determine if the current player can win
            if (currentPlayer.canWin()) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            // Prompts the user to select a card to play
            System.out.println("Please select the card to play (enter the name of the card directly)：");
            String input = scanner.nextLine();

            // Converts the user's input to a card object
            Card discardCard = parseInputToCard(input);

            // If the input is invalid, the user is prompted to re-enter
            if (discardCard == null) {
                System.out.println("Invalid input, please re-select!");
                continue;
            }

            // Check that the player's hand contains the entered cards
            if (isCardInHand(discardCard, currentPlayer)) {
                // If included, the card is played
                currentPlayer.play(discardCard);
                // Update the cards played by the previous player
                lastDiscard = discardCard;
                // Check to see if anyone can handle the card
                for (int i = 0; i < players.size(); i++) {
                    // Except for current players
                    if (i != currentPlayerIndex) {
                        Player otherPlayer = players.get(i);
                        if (GangChecker.canMingGang(otherPlayer.getHand(), lastDiscard)) {
                            // Prompts the player whether to draw a card
                            System.out.println(otherPlayer.getName() + "You can play cards! Current hand：" + otherPlayer.getHand() + "Bar or not (Enter gang for bar, other for no bar)：");
                            String input2 = scanner.nextLine();
                            if (input2.equalsIgnoreCase("gang")) {
                                // If the player chooses a bar, a bar operation is performed
                                GangChecker.kaiMingGang(otherPlayer.getHand(), lastDiscard);
                                System.out.println("Successful bar. You opened four"+lastDiscard);
                                currentPlayerIndex = (i + 3) % players.size();
                                lastDiscard = null; // Prevent touching or eating after the bar

                            } else {
                            // If the player chooses not to draw, the game continues
                           }
                        } else {
                        // If no player can pull a card, the game continues
                        }
                    }
                }
                //Check to see if anyone can touch the card
                for (int i = 0; i < players.size(); i++) {
                    //Except for current players
                    if (i != currentPlayerIndex) {
                        Player otherPlayer = players.get(i);
                        if (PengChecker.canPeng(otherPlayer.getHand(), lastDiscard)) {
                            // Prompts the player whether to touch a card
                            System.out.println(otherPlayer.getName() + "You can touch the card! Current hand：" + otherPlayer.getHand() + "Whether to touch the card (enter peng to touch the card, other means not to touch)：");
                            String input2 = scanner.nextLine();
                            if (input2.equalsIgnoreCase("peng")) {
                                // If the player chooses to touch a card, the card is touched
                                PengChecker.peng(otherPlayer.getHand(), lastDiscard);
                                currentPlayerIndex = (i + 3) % players.size();
                                lastDiscard = null;//Prevent eating after touching
                            } else {
                                // If the player chooses not to touch the card, the game continues
                            }
                        } else {
                            // If no player can touch the card, the game continues
                        }
                    }
                }
                // Update the current player index
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            } else {
                // If no, the user is prompted to re-select
                System.out.println("This card is not in the hand, please select again!");
            }
        }
    }
    public int getCurrentPlayer(){
        return currentPlayerIndex;
    }

    public Card parseInputToCard(String input) {
        // Remove the Spaces on both sides of the input string
        input = input.trim();
        // If the input string is less than 2 in length, null is returned
        if (input.length() < 2) {
            return null;
        }

        // Gets the TYPE in the input string (wind, medium, hair, board, day, flower)
        String type = input.substring(input.length() - 1);
        // 获取输入字符串中VALUE（数值）
        String valueStr = input.substring(0, input.length() - 1);

        // If TYPE is Wind, Medium, wealth, board, Day, or Flower, a new Card object is returned
        if (type.equals("风") || type.equals("中") || type.equals("财") || type.equals("板") ||
                type.equals("天") || type.equals("花") || type.equals("子")) {
            return new Card(null, input);
        }

        // Attempts to convert a VALUE string to an integer
        Integer value;
        try {
            value = Integer.parseInt(valueStr);
        } catch (NumberFormatException e) {
            // If the conversion fails, null is returned
            return null;
        }

        // Return null if TYPE is not a million, bar, or cylinder
        if (!type.equals("万") && !type.equals("条") && !type.equals("筒")) {
            return null;
        }

        // Returns a new Card object
        return new Card(value, type);
    }
    public void dealCards() {
        // Go through 13 times
        for (int i = 0; i < 13; i++) {
            // Traversal player
            for (Player player : players) {
                // Player touch
                player.dealcard(deck.remove(0));
            }
        }
    }

    public Card drawCard(Player player) {
        // Move cards from the deck
        Card card = deck.remove(0);
        // Play cards
        player.draw(card);
        // Return card
        return card;
    }

    public boolean isCardInHand(Card card, Player player) {
        // Traverse the player's hand
        for (Card handCard : player.getHand()) {
            // Compare hands and cards to see if they are the same
            if (handCard.equals(card)) {
                // Return true if the same
                return true;
            }
        }
        // After traversing the player's hand, if there are no identical cards, false is returned
        return false;
    }
}
