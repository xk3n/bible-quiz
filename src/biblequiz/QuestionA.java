/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblequiz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class QuestionA implements Runnable {
    ImageIcon bgImage = new ImageIcon("image\\bgQuestion.jpg");
    ImageIcon levelImage = new ImageIcon("image\\levelContainer.png");
    ImageIcon answerImage = new ImageIcon("image\\answerBg.png");
    ImageIcon submitImage = new ImageIcon("image\\submitBg.png");
    ImageIcon[] question = new ImageIcon[20];
    int width = bgImage.getIconWidth() + 17;
    int height = bgImage.getIconHeight() + 39;
    JFrame f;
    JLabel bg, answerBg, answerBtnBg;
    JLabel questionLbl;
    JLabel levelValue, levelBg;
    JLabel scores, lives;
    JButton answerBtn;
    JTextField answer;
    Font font;
    int questionIndex;
    QuestionA(int questionIndex){
        for (int i = 0; i < question.length; i++) {
            question[i] = new ImageIcon("image\\questions\\question"+(i+1)+".png");
        }
        this.questionIndex = questionIndex;
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
        
        scores = new JLabel("error");
        scores.setBounds(20, 20, 200, 50);
        scores.setFont(font);
        f.add(scores);
        
        lives = new JLabel("error");
        lives.setBounds(width - 220, 20, 200, 50);
        lives.setFont(font);
        f.add(lives);
        
        levelBg = new JLabel(levelImage);
        levelBg.setBounds(width/2 - levelImage.getIconWidth()/2, 20, levelImage.getIconWidth(), levelImage.getIconHeight());
        f.add(levelBg);
        
        levelValue = new JLabel("error");
        levelValue.setFont(font);
        levelValue.setHorizontalAlignment(SwingConstants.CENTER);
        levelValue.setBounds(levelBg.getBounds().x, levelBg.getBounds().y, levelBg.getBounds().width, levelBg.getBounds().height);
        f.add(levelValue);
        
        questionLbl = new JLabel(question[questionIndex], JLabel.CENTER);
        questionLbl.setBounds(width/2 - (1011/2), 100, 1011, 191);
        f.add(questionLbl);
        
        
        answer = new JTextField("Type your answer here!");
        answer.setHorizontalAlignment(SwingConstants.CENTER);
        answer.setFont(font);
        answer.setBackground(Color.red);
        answer.setOpaque(false);
        answer.setBorder(null);
        answer.setBounds(210, 360, answerImage.getIconWidth(), answerImage.getIconHeight());
        f.add(answer);
        
        answerBg = new JLabel(answerImage);
        answerBg.setBounds(answer.getBounds().x, answer.getBounds().y, answerImage.getIconWidth(), answerImage.getIconHeight());
        f.add(answerBg);
        
        
        answerBtn = new JButton("Submit");
        answerBtn.setHorizontalAlignment(SwingConstants.CENTER);
        answerBtn.setFont(font);
        answerBtn.setBackground(Color.red);
        answerBtn.setForeground(new Color(219, 71,71));
        answerBtn.setOpaque(false);
        answerBtn.setBorder(null);
        answerBtn.setBounds(width/2 - submitImage.getIconWidth()/2, answer.getBounds().y + answerImage.getIconHeight() + 50, submitImage.getIconWidth(), submitImage.getIconHeight());
        f.add(answerBtn);
        
        answerBtnBg = new JLabel(submitImage);
        answerBtnBg.setBackground(Color.red);
        answerBtnBg.setOpaque(false);
        answerBtnBg.setBorder(null);
        answerBtnBg.setBounds(width/2 - submitImage.getIconWidth()/2, answer.getBounds().y + answerImage.getIconHeight() + 50, submitImage.getIconWidth(), submitImage.getIconHeight());
        f.add(answerBtnBg);
                
                
        bg = new JLabel(bgImage);
        bg.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());
        f.add(bg);
    }
    
    void changeQuestion(int questionIndex){
        questionLbl.setIcon(question[questionIndex]);
    }
}
