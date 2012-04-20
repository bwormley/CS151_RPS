
package cs151_rps.io;

import java.util.Locale;
import cs151_rps.*; 
import cs151_rps.score.Referee;
import javax.swing.JOptionPane;

/* ************************** IMPORTANT **********************************
 * When mainGameFrame's main method is invoked, the first form               *
 * that displays is the startForm. When Start Game button is clicked     *
 * in the startForm, that is when mainGameFrame is displayed.                *
 * ***********************************************************************/

public class mainGameFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainGameFrame
     */
    public mainGameFrame() {
        initComponents();
    }

    //create the PassiveGameController reference to pass human player's info
    public PassiveGameController passiveController = new PassiveGameController(); 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        playerTitleLabel = new javax.swing.JLabel();
        roundLabel = new javax.swing.JLabel();
        currentRoundLabel = new javax.swing.JLabel();
        ofLabel = new javax.swing.JLabel();
        totalRoundLabel = new javax.swing.JLabel();
        computerTitleLabel = new javax.swing.JLabel();
        p1WinsTtlLabel = new javax.swing.JLabel();
        tiesTtlLabel = new javax.swing.JLabel();
        p2WinsTtlLabel = new javax.swing.JLabel();
        playerScoreLabel = new javax.swing.JLabel();
        numOfTiesLabel = new javax.swing.JLabel();
        computerScoreLabel = new javax.swing.JLabel();
        playerMoveLabel = new javax.swing.JLabel();
        computerMoveLabel = new javax.swing.JLabel();
        rockButton = new javax.swing.JButton();
        paperButton = new javax.swing.JButton();
        scissorsButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        youWinLabel = new javax.swing.JLabel();
        computerWinsLabel = new javax.swing.JLabel();
        computerPredictionLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        roundTtlLabel = new javax.swing.JLabel();
        numofRoundsTextField = new javax.swing.JTextField();
        gameTypeLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gameTypeList = new javax.swing.JList();
        startGameButton = new javax.swing.JButton();
        helpButton1 = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(570, 390));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setVisible(false);

        playerTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        playerTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerTitleLabel.setText("You");
        playerTitleLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        roundLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roundLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundLabel.setText("Round");

        currentRoundLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        currentRoundLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentRoundLabel.setText("1");

        ofLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ofLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ofLabel.setText("of");

        totalRoundLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalRoundLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalRoundLabel.setText("n");

        computerTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        computerTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        computerTitleLabel.setText("Computer");
        computerTitleLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        p1WinsTtlLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        p1WinsTtlLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1WinsTtlLabel.setText("Wins");

        tiesTtlLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tiesTtlLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiesTtlLabel.setText("Ties");

        p2WinsTtlLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        p2WinsTtlLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2WinsTtlLabel.setText("Wins");

        playerScoreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        playerScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerScoreLabel.setText("0");
        playerScoreLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        playerScoreLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        numOfTiesLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numOfTiesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numOfTiesLabel.setText("0");
        numOfTiesLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        numOfTiesLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        computerScoreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        computerScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        computerScoreLabel.setText("0");
        computerScoreLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        computerScoreLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        playerMoveLabel.setText("jLabel1");
        playerMoveLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), null));

        computerMoveLabel.setText("jLabel1");
        computerMoveLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), null));

        rockButton.setText("Rock");
        rockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rockButtonActionPerformed(evt);
            }
        });

        paperButton.setText("Paper");
        paperButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paperButtonActionPerformed(evt);
            }
        });

        scissorsButton.setText("Scissors");
        scissorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scissorsButtonActionPerformed(evt);
            }
        });

        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        youWinLabel.setVisible(false);
        youWinLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        youWinLabel.setForeground(new java.awt.Color(0, 0, 153));
        youWinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        youWinLabel.setText("You win!");

        computerWinsLabel.setVisible(false);
        computerWinsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        computerWinsLabel.setForeground(new java.awt.Color(255, 0, 0));
        computerWinsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        computerWinsLabel.setText("Computer wins!");

        computerPredictionLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        computerPredictionLabel.setForeground(new java.awt.Color(0, 102, 0));
        computerPredictionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        computerPredictionLabel.setText("Computer predicted . . . ");
        computerPredictionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(computerPredictionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 90, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(playerTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(105, 105, 105))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(playerScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p1WinsTtlLabel))
                                        .addGap(128, 128, 128)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(currentRoundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(ofLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(totalRoundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tiesTtlLabel)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(roundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(numOfTiesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(youWinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playerMoveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(paperButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scissorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(computerMoveLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(computerWinsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(computerTitleLabel))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(computerScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p2WinsTtlLabel))
                                .addGap(56, 56, 56))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(roundLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(computerTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(playerTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ofLabel)
                        .addComponent(currentRoundLabel)
                        .addComponent(totalRoundLabel)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p1WinsTtlLabel)
                            .addComponent(p2WinsTtlLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerScoreLabel)
                            .addComponent(computerScoreLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(playerMoveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(youWinLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(computerMoveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(computerWinsLabel))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(tiesTtlLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numOfTiesLabel)
                        .addGap(18, 18, 18)
                        .addComponent(rockButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paperButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scissorsButton)
                        .addGap(18, 18, 18)
                        .addComponent(helpButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(computerPredictionLabel)
                .addContainerGap())
        );

        jPanel1.setBounds(0, 0, 550, 350);
        jLayeredPane1.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanel3PropertyChange(evt);
            }
        });

        roundTtlLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roundTtlLabel.setText("Number of Rounds: ");

        numofRoundsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numofRoundsTextFieldActionPerformed(evt);
            }
        });

        gameTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gameTypeLabel.setText("Game Type: ");

        gameTypeList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Smart", "Random" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        gameTypeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        gameTypeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                gameTypeListValueChanged(evt);
            }
        });
        gameTypeList.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                gameTypeListComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(gameTypeList);

        startGameButton.setText("Start Game");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        helpButton1.setText("Help");
        helpButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButton1ActionPerformed(evt);
            }
        });

        warningLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(startGameButton)
                .addGap(49, 49, 49)
                .addComponent(helpButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(gameTypeLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(roundTtlLabel)
                .addGap(18, 18, 18)
                .addComponent(numofRoundsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numofRoundsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundTtlLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameTypeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startGameButton)
                    .addComponent(helpButton1))
                .addGap(31, 31, 31))
        );

        jPanel3.setBounds(65, 65, 360, 238);
        jLayeredPane1.add(jPanel3, javax.swing.JLayeredPane.POPUP_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        int totalRounds = passiveController.getNumberOfRounds(); 
        String roundsString = String.valueOf(totalRounds); 
        totalRoundLabel.setText(roundsString); 
    }//GEN-LAST:event_formComponentShown

    private void rockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rockButtonActionPerformed
        // TODO add your handling code here:
        makeWinLabelsInvisible();
        BoxScore b = passiveController.humanThrows(GameObject.ROCK);
        playerScoreLabel.setText(""+b.numberOfHumanWins);
        computerScoreLabel.setText(""+b.numberOfComputerWins); 
        numOfTiesLabel.setText(""+b.numberOfTies);
        currentRoundLabel.setText(""+b.roundNumber); 
        displayWinnerLabel(b.winner);
        computerPredictionLabel.setText("Computer predicted "+b.computersPredictedMove);
        
    }//GEN-LAST:event_rockButtonActionPerformed

    private void paperButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paperButtonActionPerformed
        // TODO add your handling code here:
        makeWinLabelsInvisible();
        BoxScore b = passiveController.humanThrows(GameObject.PAPER);
        playerScoreLabel.setText(""+b.numberOfHumanWins);
        computerScoreLabel.setText(""+b.numberOfComputerWins); 
        numOfTiesLabel.setText(""+b.numberOfTies);
        currentRoundLabel.setText(""+b.roundNumber); 
        computerPredictionLabel.setText("Computer predicted "+b.computersPredictedMove);
    }//GEN-LAST:event_paperButtonActionPerformed

    private void scissorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scissorsButtonActionPerformed
        // TODO add your handling code here:
        makeWinLabelsInvisible();
        BoxScore b = passiveController.humanThrows(GameObject.SCISSORS);
        playerScoreLabel.setText(""+b.numberOfHumanWins);
        computerScoreLabel.setText(""+b.numberOfComputerWins); 
        numOfTiesLabel.setText(""+b.numberOfTies);
        currentRoundLabel.setText(""+b.roundNumber); 
        computerPredictionLabel.setText("Computer predicted "+b.computersPredictedMove);
    }//GEN-LAST:event_scissorsButtonActionPerformed

    private void makeWinLabelsInvisible() {
        youWinLabel.setVisible(false);
        computerWinsLabel.setVisible(false);
    }
    
    private void displayWinnerLabel(Referee.Winner winner) {
        if (winner == Referee.Winner.PLAYER1) 
            youWinLabel.setVisible(true);
        if (winner == Referee.Winner.PLAYER2)
            computerWinsLabel.setVisible(true); 
    }
    
    private void endGame(Referee.Winner winner){
        rockButton.setEnabled(false);
        paperButton.setEnabled(false); 
        scissorsButton.setEnabled(false); 
        String message; 
        if (winner == Referee.Winner.PLAYER1)
            message = "Congratulations"; 
    }
    
    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        // TODO add your handling code here:
        EnglishMessage message = new EnglishMessage(); 
        JOptionPane.showMessageDialog( new javax.swing.JFrame(),message.getMessage(Message.ID.HELP));
    }//GEN-LAST:event_helpButtonActionPerformed

    private void numofRoundsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numofRoundsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numofRoundsTextFieldActionPerformed

    private void gameTypeListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gameTypeListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_gameTypeListValueChanged

    private void gameTypeListComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_gameTypeListComponentShown
        // TODO add your handling code here:
        gameTypeList.setSelectedIndex(0);
    }//GEN-LAST:event_gameTypeListComponentShown

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        // TODO add your handling code here:
        /*
         * if the number of rounds are entered and the gameType is chosen,
         * display the mainGameFrame and close this form. else, display and
         * error message and go back to the startForm.
         */
        String input = numofRoundsTextField.getText();

        //if the user didn't choose gameType, set it to Random
        if (gameTypeList.getSelectedIndex() == -1) {
            gameTypeList.setSelectedIndex(0);
        }

        String gameType = (String) (gameTypeList.getSelectedValue());
        int rounds;
        try {
            rounds = Integer.parseInt(input);
            //pass the info to PassiveGameController
            totalRoundLabel.setText(""+rounds);
            passiveController.setNumberOfRounds(rounds);
            passiveController.setGameType(gameType); 
            jPanel3.setVisible(false);
            jPanel1.setVisible(true); 
        } catch (NumberFormatException nn) {
            warningLabel.setText("Enter valid number of rounds and "
                    + " choose game Type.");
        }
    }//GEN-LAST:event_startGameButtonActionPerformed

    private void helpButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButton1ActionPerformed
        // TODO add your handling code here:
        EnglishMessage message = new EnglishMessage(); 
        JOptionPane.showMessageDialog( new javax.swing.JFrame(),message.getMessage(Message.ID.HELP));
    }//GEN-LAST:event_helpButton1ActionPerformed

    private void jPanel3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel3PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3PropertyChange

    /**
     * @param args the command line arguments
     */
    
     public static void start() {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                /* First, the startForm is opened. The mainGameFrame is displayed 
                 * when Start Game button is clicked in the startForm */
                
                new mainGameFrame().setVisible(true); 
            }

        });
     }
        
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                /* First, the startForm is opened. The mainGameFrame is displayed 
                 * when Start Game button is clicked in the startForm */
                new mainGameFrame().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel computerMoveLabel;
    private javax.swing.JLabel computerPredictionLabel;
    private javax.swing.JLabel computerScoreLabel;
    private javax.swing.JLabel computerTitleLabel;
    private javax.swing.JLabel computerWinsLabel;
    private javax.swing.JLabel currentRoundLabel;
    private javax.swing.JLabel gameTypeLabel;
    private javax.swing.JList gameTypeList;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton helpButton1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel numOfTiesLabel;
    private javax.swing.JTextField numofRoundsTextField;
    private javax.swing.JLabel ofLabel;
    private javax.swing.JLabel p1WinsTtlLabel;
    private javax.swing.JLabel p2WinsTtlLabel;
    private javax.swing.JButton paperButton;
    private javax.swing.JLabel playerMoveLabel;
    private javax.swing.JLabel playerScoreLabel;
    private javax.swing.JLabel playerTitleLabel;
    private javax.swing.JButton rockButton;
    private javax.swing.JLabel roundLabel;
    private javax.swing.JLabel roundTtlLabel;
    private javax.swing.JButton scissorsButton;
    private javax.swing.JButton startGameButton;
    private javax.swing.JLabel tiesTtlLabel;
    private javax.swing.JLabel totalRoundLabel;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JLabel youWinLabel;
    // End of variables declaration//GEN-END:variables
}
