/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quizgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author Tlpczdqp
 */
public class QuizPage extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(QuizPage.class.getName());

    
    private QuizPlayer player;
     
    private Question[] questions;
    private int currentQuestionIndex;
    
    public QuizPage(QuizPlayer player) {
        this.player = player;
        this.currentQuestionIndex = 0;

        initializeQuestions();
        initComponents();
//        customizeComponents();

        optionA.setContentAreaFilled(false);
        optionA.setOpaque(true);
        optionB.setContentAreaFilled(false);
        optionB.setOpaque(true);
        optionC.setContentAreaFilled(false);
        optionC.setOpaque(true);
        optionD.setContentAreaFilled(false);
        optionD.setOpaque(true);

           
        loadQuestion();

        setLocationRelativeTo(null);
    }
    
    //Questions
    private void initializeQuestions() {
        questions = new Question[10];
        
        //format (question, new String[]{optionA, optionB, optionC, optionD},answerIndex);
        questions[0] = new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Madrid"},
            1
        );

        questions[1] = new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Madrid"},
            1
        );

        questions[2] = new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Madrid"},
            1
        );

        questions[3] = new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Madrid"},
            1
        );

        questions[4] = new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Madrid"},
            1
        );

        questions[5] = new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Madrid"},
            1
        );

        questions[6] = new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Madrid"},
            1
        );

        questions[7] = new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Madrid"},
            1
        );

        questions[8] = new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Madrid"},
            1
        );

        questions[9] = new Question(
            "What is the capital of France?",
            new String[]{"London", "Paris", "Berlin", "Madrid"},
            1
        );
    }
    
     private void loadQuestion() {
        Question q = questions[currentQuestionIndex];

        questionNumberLabel.setText("Question: " + (currentQuestionIndex + 1) + "/10");

        questionLabel.setText("<html><center>" + q.getQuestionText() + "</center></html>");

        String[] options = q.getOptions();
        optionA.setText("A: " + options[0]);
        optionB.setText("B: " + options[1]);
        optionC.setText("C: " + options[2]);
        optionD.setText("D: " + options[3]);

        // Reset button colors
        optionA.setBackground(new Color(52, 152, 219));
        optionB.setBackground(new Color(52, 152, 219));
        optionC.setBackground(new Color(52, 152, 219));
        optionD.setBackground(new Color(52, 152, 219));

        // Enable all buttons
        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);
    }
    
     private void updateHpDisplay() {
        StringBuilder hp = new StringBuilder();
        for (int i = 0; i < player.getHp(); i++) {
            hp.append("1 ");
        }
        for (int i = player.getHp(); i < 3; i++) {
            hp.append("0 ");
        }
        hpLabel.setText(hp.toString());
    } 
     private void updateScoreDisplay() {
        scoreLabel.setText("Score: " + player.getScore());
    }
     
    private void processAnswer(int selectedIndex) {
        // Disable all buttons to prevent double-clicking
        optionA.setEnabled(false);
        optionB.setEnabled(false);
        optionC.setEnabled(false);
        optionD.setEnabled(false);

        Question q = questions[currentQuestionIndex];

        JButton[] buttons = {optionA, optionB, optionC, optionD};

        if (q.isCorrect(selectedIndex)) {
            // correct answer = +10 points
            player.addScore(10);
            buttons[selectedIndex].setBackground(new Color(39, 174, 96));
            updateScoreDisplay();
        } else {
            // wrong answer = lose hp
            player.loseHp();
            buttons[selectedIndex].setBackground(new Color(192, 57, 43));
            buttons[q.getCorrectIndex()].setBackground(new Color(39, 174, 96));
            updateHpDisplay();
        }

        player.plusAnsweredQuestion();

        // Use Timer to wait 1 second before moving to next question
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Timer) e.getSource()).stop();

                if (!player.isAlive()) {
                    goToResults();
                } else if (currentQuestionIndex >= 9) {
                    goToResults();
                } else {
                    currentQuestionIndex++;
                    loadQuestion();
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Opens the Result Page and closes this page.
     */
    private void goToResults() {
        new ResultPage(player).setVisible(true);
        dispose();
    }
    
    /**
     * Creates new form QuizPage
     */
    public QuizPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        questionNumberLabel = new javax.swing.JLabel();
        hpLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        questionPanel = new javax.swing.JPanel();
        questionLabel = new javax.swing.JLabel();
        optionsPanel = new javax.swing.JPanel();
        optionB = new javax.swing.JButton();
        optionA = new javax.swing.JButton();
        optionC = new javax.swing.JButton();
        optionD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionNumberLabel.setText("Question 1/10");

        hpLabel.setText("111");

        scoreLabel.setText("Score: 0");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(questionNumberLabel)
                .addGap(77, 77, 77)
                .addComponent(hpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scoreLabel)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionNumberLabel)
                    .addComponent(hpLabel)
                    .addComponent(scoreLabel))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        questionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        optionB.setText("B");
        optionB.addActionListener(this::optionBActionPerformed);

        optionA.setText("A");
        optionA.addActionListener(this::optionAActionPerformed);

        optionC.setText("C");
        optionC.addActionListener(this::optionCActionPerformed);

        optionD.setText("D");
        optionD.addActionListener(this::optionDActionPerformed);

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionA, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionB, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionC, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionD, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionsPanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(optionC, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionD, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(optionA, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(questionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionAActionPerformed
        // TODO add your handling code here:
        processAnswer(0);
    }//GEN-LAST:event_optionAActionPerformed

    private void optionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionBActionPerformed
        // TODO add your handling code here:
         processAnswer(1);
    }//GEN-LAST:event_optionBActionPerformed

    private void optionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionCActionPerformed
        // TODO add your handling code here:
         processAnswer(2);
    }//GEN-LAST:event_optionCActionPerformed

    private void optionDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionDActionPerformed
        // TODO add your handling code here:
         processAnswer(3);
    }//GEN-LAST:event_optionDActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hpLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton optionA;
    private javax.swing.JButton optionB;
    private javax.swing.JButton optionC;
    private javax.swing.JButton optionD;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
