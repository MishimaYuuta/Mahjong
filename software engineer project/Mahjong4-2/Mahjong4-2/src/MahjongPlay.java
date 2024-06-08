import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MahjongPlay  extends JFrame{

    public Card lastDiscard;
    public List<JButton> buttonList=new ArrayList<>();
    JPanel playerPanel ;
    List<Player> players=new ArrayList<>();
    public Player currentPlayer;
    private JLabel infoLabel;
    HandCard handcard = new HandCard();
    public JLabel iLable=new JLabel("");
    int currentPlayerIndex=0;
    public  JButton discardButton=new JButton();


    public MahjongPlay() {

        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.add(new Player("Player 3"));
        players.add(new Player("Player 4"));
        setTitle("Mahjong Game");

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.GREEN);

        // Initialization panel
        playerPanel = new JPanel();
        playerPanel.setLayout(new FlowLayout());
        MahjongGame game = new MahjongGame(players);
        Player currentPlayer = players.get(game.getCurrentPlayer());
        JLabel infoLabel = new JLabel(" ");
        infoLabel.setBounds(0, 350, 200, 25); // Adjust the position and size
        add(infoLabel);
        game.dealCards();
        this.setLayout(null); // Set the layout to absolute

        currentPlayer.sortHand();
        showcards(currentPlayer);

        // Create the Out card button
        JButton discardButton = new JButton("play a hand");
        discardButton.setBounds(140, 30, 200, 25);
        discardButton.addActionListener(new DiscardActionListener());
        discardButton.setBackground(Color.YELLOW);
        add(discardButton);
        this.setVisible(true);
    }




    // Play button event listener
    public class DiscardActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentPlayer= players.get(currentPlayerIndex);
            JLabel iLable=new JLabel("Player:"+currentPlayer.getName().toString());
            iLable.setBounds(0, 30, 200, 25);
            add(iLable);
            boolean win = currentPlayer.canWin();
            boolean peng = PengChecker.canPeng(currentPlayer.getHand(), lastDiscard);
            boolean gang = GangChecker.canMingGang(currentPlayer.getHand(), lastDiscard);
            currentPlayer = players.get(currentPlayerIndex);
            removeAllHandCards();
            currentPlayer.sortHand();
            buttonList=showcards(currentPlayer);
            if (lastDiscard==null){
                for (JButton buttons : buttonList) {
                    Card card = (Card) buttons.getClientProperty("card");
                    buttons.addActionListener(new HandCardActionListener(card));
                    buttonList.remove(buttons);
                    buttons.addActionListener(new DiscardActionListener());
                }
            }else {
                if (win) {
                    JLabel Label1 = new JLabel("");
                    Label1.setBounds(250, 250, 100, 12); // Adjust position and size as needed
                    playerPanel.add(Label1);
                    Label1.setText(currentPlayer.getName() + " wins!");
                    playerPanel.setVisible(true);
                } else {
                    for (int i = 0; i < players.size(); i++) {
                        if (i!=currentPlayerIndex) {
                            final int  index=i;
                            if (peng) {
                                String message = "you can Mingpeng！"; // Set the messages to display
                                infoLabel.setText(message);
                                JButton pengButton=new JButton("peng");
                                pengButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // If the player chooses to eat a card, the card is eaten
                                        PengChecker.peng(currentPlayer.getHand(), lastDiscard);// Perform the peng operation
                                        currentPlayerIndex = (index + 3) % players.size();
                                        lastDiscard = null;
                                        infoLabel.setText("Successful bar. You opened four" );
                                    }
                                });
                                JButton notpengButton =new JButton("notpeng");
                                notpengButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        currentPlayerIndex ++;
                                        discardButton.addActionListener(new DiscardActionListener());
                                    }
                                });
                            } else if (gang) {
                                String message = "you can Minggang！"; // Set the messages to display
                                infoLabel.setText(message);
                                JButton gangButton=new JButton("gang");
                                gangButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // If the player chooses to eat a card, the card is eaten
                                        GangChecker.canMingGang(currentPlayer.getHand(), lastDiscard);// Perform the open bar operation
                                        currentPlayerIndex = (index + 3) % players.size();
                                        lastDiscard = null;
                                        infoLabel.setText("Successful bar. You opened four" );
                                    }
                                });
                                JButton notgangButton =new JButton("notgang");
                                notgangButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        currentPlayerIndex ++;
                                        discardButton.addActionListener(new DiscardActionListener());
                                    }
                                });


                            } else if (ChiChecker.canChi(currentPlayer.getHand(), lastDiscard)) {
                                infoLabel.setText("You can eat the card now! Whether to take the card or not：");
                                // The monitor for the eat card button
                                JButton chiButton = new JButton("chi");

                                chiButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // If the player chooses to eat a card, the card is eaten
                                        ChiChecker.chi(currentPlayer.getHand(), lastDiscard);
                                        currentPlayerIndex = (index + 3) % players.size();
                                        lastDiscard = null;
                                    }
                                });

                                // Listen to the don't eat button
                                JButton passButton = new JButton("nochi");
                                passButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        currentPlayerIndex ++;
                                        discardButton.addActionListener(new DiscardActionListener());
                                    }
                                });
                            }
                        } else {
                            // Add event listeners for each hand button
                            for (JButton button : buttonList) {
                                Card card = (Card) button.getClientProperty("card");
                                lastDiscard = card;
                                currentPlayer.getHand().remove(card);
                                button.addActionListener(new HandCardActionListener(card));
                            }
                        }
                    }
                }
            }
        }
    }public List<JButton> showcards(Player currentPlayer) {

        for (int i = 0; i < currentPlayer.getHand().size(); i++) {
            JButton button = handcard.CardImage(currentPlayer.getHand().get(i));
            button.setBounds(60 * i, 480, 60, 80); // 设置按钮的位置和大小
            add(button);
            buttonList.add(button);
        }

        return buttonList;
    }public void removeAllHandCards() {
        for (JButton button : buttonList) {
            remove(button); // Remove the button
        }
        buttonList.clear(); // Clear the button list

        revalidate(); // Revalidate the layout
        repaint(); // Repaint the panel
    }

    // Hand button event listener
    public class HandCardActionListener implements ActionListener {
        private Card card;

        public HandCardActionListener(Card card) {
            this.card = card;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                lastDiscard=card;
                currentPlayer.getHand().remove(card);
                currentPlayerIndex++;
                iLable.setText("Player:"+currentPlayer.getName().toString());
                discardButton.addActionListener(new DiscardActionListener());
                currentPlayer.play(card);

        }
    }



    public static void main(String[] args) {
        // This is where the state of the game is initialized, including the players, the deck, and so on
        List<Player> players = new ArrayList<>();
        new MahjongEntry(players);
    }
}


