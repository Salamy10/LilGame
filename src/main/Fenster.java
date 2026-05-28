package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Fenster {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame fenster = new JFrame("Mein erstes Fenster");
            fenster.setSize(400, 300);
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel text = new JLabel("Hallo Welt!", JLabel.CENTER);
            fenster.add(text);

            fenster.setVisible(true);
        });
    }
}