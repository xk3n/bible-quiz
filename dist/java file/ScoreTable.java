/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblequiz;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author Kim
 */
public class ScoreTable implements Runnable{
    ImageIcon bgImage = new ImageIcon("image\\bgQuestion.jpg");
    int width = 500 + 17;
    int height = bgImage.getIconHeight() + 39;
    JTable scoreView;
    JScrollPane scrollPane;
    JFrame f;
    JLabel bg;
    String[][] scoresData = new String[100][100];
    String[] column = {"Player Name", "Final Score", "Lives Left", "Last Stage"};
    @Override
    public void run() {
        f = new JFrame("The Bible Quiz");
        f.setVisible(false);
        f.setSize(width, height);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setLocationRelativeTo(null);
        
        
        scoreView = new JTable(scoresData, column);
        scoreView.setBounds(0, 0, width+20, height);
        scrollPane = new JScrollPane(scoreView);
        scrollPane.setBounds(0, 0, width, height);
        f.add(scrollPane);
        
        bg = new JLabel(bgImage);
        bg.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());
        f.add(bg);
    }
}
