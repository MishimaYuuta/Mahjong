import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
public class MahjongEntry extends MahjongGame {

    public MahjongEntry(List<Player> players) {
        super(players);
        JFrame frame = new JFrame("Mahjong Game");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Welcome to Mahjong Game");
        titleLabel.setBounds(140, 30, 200, 25);
        panel.add(titleLabel);

        JButton startButton = new JButton("Start Game");
        startButton.setBounds(150, 80, 100, 25);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Game Started！");
                // Game Start
                openGameWindow(frame);
            }
        });
        panel.add(startButton);
    }

    private void openGameWindow(JFrame entryFrame) {
        entryFrame.dispose();
        JFrame gameFrame = new JFrame("Mahjong - Game");
        gameFrame.setSize(800, 600);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.getContentPane().setBackground(Color.GREEN);
        gameFrame.setVisible(true);
        new MahjongPlay();
    }





}
