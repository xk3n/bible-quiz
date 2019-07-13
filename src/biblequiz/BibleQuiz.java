package biblequiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class BibleQuiz implements Runnable, ActionListener, KeyListener {

    static int level = 1;
    static int scores = 0;
    static int lives = 3;
    static int tableIncrement = 0;

    ImageIcon bgImage = new ImageIcon("image\\bg.jpg");
    ImageIcon playerTfImage = new ImageIcon("image\\playerNameBg.png");
    ImageIcon tableImage = new ImageIcon("image\\questionContainer.png");
    int width = bgImage.getIconWidth() + 17;
    int height = bgImage.getIconHeight() + 39;
    JFrame f;
    JLabel bg, playerNameBg, viewScoreBg;
    JButton startBtn, viewScore;
    JTextField playerName;
    String[] getAnswer = {
        "fisherman",
        "betlehem",
        "27",
        "peter",
        "peter and andrew",
        "2 john",
        "tax collector",
        "benjamin",
        "john the baptizer",
        "40",
        "Matthew",
        "turning water into wine",
        "River Jordan",
        "12",
        "the wise man",
        "raised him from the dead",
        "herod",
        "revelation",
        "you shall have no other gods before me",
        "moses"
    };
    PickQuestion pickQuestion;
    QuestionA questionA;
    ScoreTable scoreTable;

    BibleQuiz() {

    }

    public static void main(String[] args) {
        BibleQuiz starter = new BibleQuiz();
        starter.pickQuestion = new PickQuestion();
        starter.questionA = new QuestionA(BibleQuiz.level - 1);
        starter.scoreTable = new ScoreTable();
        
        starter.run();
        starter.f.setVisible(true);

        starter.pickQuestion.run();
        starter.questionA.run();
        starter.scoreTable.run();
        starter.addListen();
    }

    @Override
    public void run() {
        Font font = new Font("Helvetica", Font.BOLD, 30);
        f = new JFrame("The Bible Quiz");
        f.setVisible(false);
        f.setSize(width, height);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        startBtn = new JButton();
        startBtn.setOpaque(false);
        startBtn.setBackground(Color.red);
        startBtn.setBorder(null);
        startBtn.setBounds(width / 2 - 285, height - 142, 554, 57);
        startBtn.addActionListener(this);
        f.add(startBtn);
        
        viewScore = new JButton("View Scoreboard");
        viewScore.setOpaque(false);
        viewScore.setFont(font);
        viewScore.setBackground(Color.red);
        viewScore.setBorder(null);
        viewScore.setBounds(width*3/4  + 50 - tableImage.getIconWidth()/2, 160, tableImage.getIconWidth(), tableImage.getIconHeight());
        viewScore.addActionListener(this);
        f.add(viewScore);
        
        playerName = new JTextField("Player Name");
        playerName.setHorizontalAlignment(JTextField.CENTER);
        playerName.setFont(font);
        playerName.setBackground(Color.red);
        playerName.setOpaque(false);
        playerName.setBorder(null);
        playerName.setBounds(width/4 - 50 - playerTfImage.getIconWidth()/2, 160, playerTfImage.getIconWidth(), playerTfImage.getIconHeight());
        f.add(playerName);
        
        playerNameBg = new JLabel(playerTfImage);
        playerNameBg.setBounds(playerName.getBounds().x, playerName.getBounds().y, playerName.getBounds().width, playerName.getBounds().height);
        f.add(playerNameBg);
        
        viewScoreBg = new JLabel(tableImage);
        viewScoreBg.setBounds(viewScore.getBounds().x, viewScore.getBounds().y, viewScore.getBounds().width, viewScore.getBounds().height);
        f.add(viewScoreBg);
        
        bg = new JLabel(bgImage);
        bg.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());
        f.add(bg);

    }

    public void addListen() {
        pickQuestion.qABtn.addActionListener(this);
        pickQuestion.qBBtn.addActionListener(this);
        pickQuestion.qCBtn.addActionListener(this);
        pickQuestion.qDBtn.addActionListener(this);
        questionA.answerBtn.addActionListener(this);
        questionA.answer.addKeyListener(this);
        questionA.scores.setText("Scores " + scores);
        questionA.lives.setText("Lives " + lives);
        pickQuestion.f.addWindowListener(new WindowAdapter(){
            
            @Override
            public void windowClosing(WindowEvent e){
                pickQuestion.f.setVisible(false);
                f.setVisible(true);
            }
        });
        questionA.f.addWindowListener(new WindowAdapter(){
            
            @Override
            public void windowClosing(WindowEvent e){
                questionA.f.setVisible(false);
                pickQuestion.f.setVisible(true);
            }
        });
        scoreTable.f.addWindowListener(new WindowAdapter(){
            
            @Override
            public void windowClosing(WindowEvent e){
                scoreTable.f.setVisible(false);
                f.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            f.setVisible(false);
            pickQuestion.f.setVisible(true);
            pickQuestion.levelValue.setText("Level " + level);
        }
        
        if (e.getSource() == viewScore){
            f.setVisible(false);
            scoreTable.f.setVisible(true);
        }

        if (e.getSource() == pickQuestion.qABtn) {
            if (level > 0 && level <= 5) {
                pickQuestion.f.setVisible(false);
                questionA.f.setVisible(true);
                questionA.levelValue.setText("Level " + level);
            } else {
                JOptionPane.showConfirmDialog(f, "You have already finished this Question.\nPlease Proceed to Question B", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        } else if (e.getSource() == pickQuestion.qBBtn) {
            if (level >= 6 && level <= 10) {
                pickQuestion.f.setVisible(false);
                questionA.f.setVisible(true);
                questionA.levelValue.setText("Level " + level);
            } else if (level <= 5) {
                JOptionPane.showConfirmDialog(f, "Please complete the Question A first.", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(f, "You have already finished this Question.\nPlease Proceed to Question C", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        } else if (e.getSource() == pickQuestion.qCBtn) {
            if (level >= 11 && level <= 15) {
                pickQuestion.f.setVisible(false);
                questionA.f.setVisible(true);
                questionA.levelValue.setText("Level " + level);
            } else if (level <= 10) {
                JOptionPane.showConfirmDialog(f, "Please complete the Question B first.", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(f, "You have already finished this Question.\nPlease Proceed to Question C", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        } else if (e.getSource() == pickQuestion.qDBtn) {
            if (level >= 16 && level <= 20) {
                pickQuestion.f.setVisible(false);
                questionA.f.setVisible(true);
                questionA.levelValue.setText("Level " + level);
            } else if (level <= 15) {
                JOptionPane.showConfirmDialog(f, "Please complete the Question C first.", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(f, "You have already finished this Question.\nPlease Proceed to Question C", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        }

        if (e.getSource() == questionA.answerBtn) {
            confirmAnswer();
        }
    }

    public void confirmAnswer() {
        boolean restart = false;
        if (questionA.answer.getText().equalsIgnoreCase(getAnswer[level - 1])) {
            level++;
            JOptionPane.showConfirmDialog(f, "Congrats! you have guessed the answer!", "Good Job!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            switch (level) {
                case 6:
                    JOptionPane.showConfirmDialog(f, "You have unlocked Question B!", "Good Job!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                    questionA.f.setVisible(false);
                    pickQuestion.f.setVisible(true);
                    break;
                case 11:
                    JOptionPane.showConfirmDialog(f, "You have unlocked Question C!", "Good Job!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                    questionA.f.setVisible(false);
                    pickQuestion.f.setVisible(true);
                    break;
                case 16:
                    JOptionPane.showConfirmDialog(f, "You have unlocked Question D!", "Good Job!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                    questionA.f.setVisible(false);
                    pickQuestion.f.setVisible(true);
                    break;
                case 21:
                    JOptionPane.showConfirmDialog(f, "Congratulations! You have finished the Bible Quiz. Your score is " + (scores * lives), "Good Job!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                    scoreTable.scoresData[tableIncrement][0] = playerName.getText();
                    scoreTable.scoresData[tableIncrement][1] = String.valueOf(scores * lives);
                    scoreTable.scoresData[tableIncrement][2] = String.valueOf(lives);
                    scoreTable.scoresData[tableIncrement][3] = String.valueOf(level-1);
                    tableIncrement++;
                    scores = 0;
                    lives = 3;
                    level = 1;
                    restart = true;
                    questionA.f.setVisible(false);
                    scoreTable.f.setVisible(true);
                    break;
                default:
                    break;
            }

            
            if(level < 21 && lives > 0 && !restart){
                lives++;
                if (level > 0 && level <= 5) {
                    scores += 50;
                } else if (level >= 6 && level <= 10) {
                    scores += 100;
                } else if (level >= 11 && level <= 15) {
                    scores += 150;
                } else if (level >= 16 && level <= 20) {
                    scores += 200;
                }
            }
                
                questionA.changeQuestion(level - 1);
                questionA.levelValue.setText("Level " + level);
                questionA.scores.setText("Scores " + scores);
                questionA.lives.setText("Lives " + lives);
                pickQuestion.levelValue.setText("Level " + level);
                questionA.answer.setText("");
        } else {
            if (!questionA.answer.getText().isEmpty()) {
                lives--;
                if (lives > 0) {
                    JOptionPane.showConfirmDialog(f, "Try again!", "Wrong Answer", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                    questionA.scores.setText("Scores " + scores);
                    questionA.lives.setText("Lives " + lives);
                    pickQuestion.levelValue.setText("Level " + level);
                    questionA.answer.setText("");
                } else {
                    JOptionPane.showConfirmDialog(f, "You have failed to finish the Bible Quiz\nYour final score is " + (scores), "Wrong Answer", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                    scoreTable.scoresData[tableIncrement][0] = playerName.getText();
                    scoreTable.scoresData[tableIncrement][1] = String.valueOf(scores * (lives+1));
                    scoreTable.scoresData[tableIncrement][2] = String.valueOf(lives);
                    scoreTable.scoresData[tableIncrement][3] = String.valueOf(level-1);
                    tableIncrement++;
                    questionA.f.setVisible(false);
                    scoreTable.f.setVisible(true);
                    scores = 0;
                    lives = 3;
                    level = 1;
                    questionA.scores.setText("Scores " + scores);
                    questionA.lives.setText("Lives " + lives);
                    pickQuestion.levelValue.setText("Level " + level);
                    questionA.answer.setText("Type your answer here!");
                    questionA.changeQuestion(level - 1);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getSource() == questionA.answer) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                confirmAnswer();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
