

public class startPanel extends javax.swing.JPanel {

    /**
     * Creates new form startPanel
     */
    public startPanel() {
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        roundsPanel = new javax.swing.JPanel();
        roundTtlLabel = new javax.swing.JLabel();
        numofRoundsTextField = new javax.swing.JTextField();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        gameTypePanel = new javax.swing.JPanel();
        roundTtlLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gameTypeList = new javax.swing.JList();
        startGameButton = new javax.swing.JButton();

        roundTtlLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roundTtlLabel.setText("Number of Rounds: ");

        numofRoundsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numofRoundsTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundsPanelLayout = new javax.swing.GroupLayout(roundsPanel);
        roundsPanel.setLayout(roundsPanelLayout);
        roundsPanelLayout.setHorizontalGroup(
            roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundTtlLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numofRoundsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundsPanelLayout.setVerticalGroup(
            roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundsPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roundTtlLabel)
                    .addComponent(numofRoundsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        roundsPanel.setBounds(0, 0, 242, 50);
        jLayeredPane1.add(roundsPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        roundTtlLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roundTtlLabel1.setText("Game Type: ");

        gameTypeList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        gameTypeList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(gameTypeList);

        startGameButton.setText("Start Game");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gameTypePanelLayout = new javax.swing.GroupLayout(gameTypePanel);
        gameTypePanel.setLayout(gameTypePanelLayout);
        gameTypePanelLayout.setHorizontalGroup(
            gameTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameTypePanelLayout.createSequentialGroup()
                .addGroup(gameTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameTypePanelLayout.createSequentialGroup()
                        .addContainerGap(44, Short.MAX_VALUE)
                        .addComponent(roundTtlLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gameTypePanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(startGameButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        gameTypePanelLayout.setVerticalGroup(
            gameTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameTypePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gameTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundTtlLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startGameButton))
        );

        gameTypePanel.setBounds(0, 0, 230, 98);
        jLayeredPane2.add(gameTypePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void numofRoundsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numofRoundsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numofRoundsTextFieldActionPerformed

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startGameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList gameTypeList;
    private javax.swing.JPanel gameTypePanel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField numofRoundsTextField;
    private javax.swing.JLabel roundTtlLabel;
    private javax.swing.JLabel roundTtlLabel1;
    private javax.swing.JPanel roundsPanel;
    private javax.swing.JButton startGameButton;
    // End of variables declaration//GEN-END:variables
}
