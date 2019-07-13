/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblequiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Kim
 */
public class PickQuestion implements Runnable {
    ImageIcon bgImage = new ImageIcon("image\\bgQuestion.jpg");
    ImageIcon levelImage = new ImageIcon("image\\levelContainer.png");
    ImageIcon questionImage = new ImageIcon("image\\questionContainer.png");
    int width = bgImage.getIconWidth() + 17;
    int height = bgImage.getIconHeight() + 39;
    JFrame f;
    JLabel bg;
    JLabel levelValue, levelBg;
    JLabel qABg, qBBg, qCBg, qDBg;
    JLabel qAValue, qBValue, qCValue, qDValue;
    JButton qABtn, qBBtn, qCBtn, qDBtn;
    Font font;
    PickQuestion(){
        
    }
    
    @Override
    public void run() {
        font = new Font("Helvetica", Font.BOLD, 30);
        f = new JFrame("The Bible Quiz");
        f.setVisible(false);
        f.setSize(width, height);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setLocationRelativeTo(null);
        
        qABtn = new JButton();
        qABtn.setOpaque(false);
        qABtn.setBackground(Color.red);
        qABtn.setBorder(null);
        f.add(qABtn);
        
        qBBtn = new JButton();
        qBBtn.setOpaque(false);
        qBBtn.setBackground(Color.red);
        qBBtn.setBorder(null);
        f.add(qBBtn);
        
        qCBtn = new JButton();
        qCBtn.setOpaque(false);
        qCBtn.setBackground(Color.red);
        qCBtn.setBorder(null);
        f.add(qCBtn);
        
        qDBtn = new JButton();
        qDBtn.setOpaque(false);
        qDBtn.setBackground(Color.red);
        qDBtn.setBorder(null);
        f.add(qDBtn);
        
        setImages();
        
        qABtn.setBounds(qABg.getBounds().x, qABg.getBounds().y, qABg.getBounds().width, qABg.getBounds().height);
        qBBtn.setBounds(qBBg.getBounds().x, qBBg.getBounds().y, qBBg.getBounds().width, qBBg.getBounds().height);
        qCBtn.setBounds(qCBg.getBounds().x, qCBg.getBounds().y, qCBg.getBounds().width, qCBg.getBounds().height);
        qDBtn.setBounds(qDBg.getBounds().x, qDBg.getBounds().y, qDBg.getBounds().width, qDBg.getBounds().height);
    }
    
    void setImages(){
        levelBg = new JLabel(levelImage);
        levelBg.setBounds(width/2 - levelImage.getIconWidth()/2, 20, levelImage.getIconWidth(), levelImage.getIconHeight());
        f.add(levelBg);
        
        levelValue = new JLabel("error");
        levelValue.setFont(font);
        levelValue.setHorizontalAlignment(SwingConstants.CENTER);
        levelValue.setBounds(levelBg.getBounds().x, levelBg.getBounds().y, levelBg.getBounds().width, levelBg.getBounds().height);
        f.add(levelValue);
        

        qABg = new JLabel(questionImage);
        qABg.setBounds(width/4 - questionImage.getIconWidth()/2, 300, questionImage.getIconWidth(), questionImage.getIconHeight());
        f.add(qABg);
        
        qBBg = new JLabel(questionImage);
        qBBg.setBounds(width*3/4 - questionImage.getIconWidth()/2, 300, questionImage.getIconWidth(), questionImage.getIconHeight());
        f.add(qBBg);
        
        qCBg = new JLabel(questionImage);
        qCBg.setBounds(width/4 - questionImage.getIconWidth()/2, 300 + questionImage.getIconHeight() + 30, questionImage.getIconWidth(), questionImage.getIconHeight());
        f.add(qCBg);
        
        qDBg = new JLabel(questionImage);
        qDBg.setBounds(width*3/4 - questionImage.getIconWidth()/2, 300 + questionImage.getIconHeight() + 30, questionImage.getIconWidth(), questionImage.getIconHeight());
        f.add(qDBg);
        
        qAValue = new JLabel("Question A");
        qAValue.setFont(font);
        qAValue.setHorizontalAlignment(SwingConstants.CENTER);
        qAValue.setBounds(width/4 - questionImage.getIconWidth()/2, 300, questionImage.getIconWidth(), questionImage.getIconHeight());
        f.add(qAValue);
        
        qBValue = new JLabel("Question B");
        qBValue.setFont(font);
        qBValue.setHorizontalAlignment(SwingConstants.CENTER);
        qBValue.setBounds(width*3/4 - questionImage.getIconWidth()/2, 300, questionImage.getIconWidth(), questionImage.getIconHeight());
        f.add(qBValue);
        
        qCValue = new JLabel("Question C");
        qCValue.setFont(font);
        qCValue.setHorizontalAlignment(SwingConstants.CENTER);
        qCValue.setBounds(width/4 - questionImage.getIconWidth()/2, 300 + questionImage.getIconHeight() + 30, questionImage.getIconWidth(), questionImage.getIconHeight());
        f.add(qCValue);
        
        qDValue = new JLabel("Question D");
        qDValue.setFont(font);
        qDValue.setHorizontalAlignment(SwingConstants.CENTER);
        qDValue.setBounds(width*3/4 - questionImage.getIconWidth()/2, 300 + questionImage.getIconHeight() + 30, questionImage.getIconWidth(), questionImage.getIconHeight());
        f.add(qDValue);
        
        bg = new JLabel(bgImage);
        bg.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());
        f.add(bg);
    }

}
