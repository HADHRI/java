package views;


import controller.MenuController;

public class MenuView extends Display {

        /**
         * Creates new form test
         */

        public MenuView(String title) {
            super(title);
            initComponents();
            frame.setVisible(true);
        }



        private void initComponents() {
            java.awt.GridBagConstraints gridBagConstraints;

            jPanel1 = new javax.swing.JPanel();
            jPanel2 = new javax.swing.JPanel();
            buttonNewGame = new javax.swing.JButton();
            jPanel3 = new javax.swing.JPanel();
            jLabel9 = new javax.swing.JLabel();
            jLabel1 = new javax.swing.JLabel();
            buttonLoadGame = new javax.swing.JButton();
            buttonSettings = new javax.swing.JButton();
            buttonQuit = new javax.swing.JButton();



            jPanel1.setLayout(new java.awt.BorderLayout());

            jPanel2.setBackground(new java.awt.Color(255, 255, 255));

            buttonNewGame.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
            buttonNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_Add_New_104px.png"))); // NOI18N
            buttonNewGame.setText("NEW GAME");
            buttonNewGame.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonNewGameActionPerformed(evt);
                }
            });

            jPanel3.setBackground(new java.awt.Color(102, 153, 255));
            jPanel3.setLayout(new java.awt.GridBagLayout());

            jLabel9.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 100)); // NOI18N
            jLabel9.setForeground(new java.awt.Color(255, 255, 255));
            jLabel9.setText("Vivarium");
            jLabel9.setToolTipText("");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.gridheight = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(70, 310, 0, 322);
            jPanel3.add(jLabel9, gridBagConstraints);

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_Game_Controller_96px.png"))); // NOI18N
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(0, 540, 0, 0);
            jPanel3.add(jLabel1, gridBagConstraints);

            buttonLoadGame.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
            buttonLoadGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_Upload_104px_1.png"))); // NOI18N
            buttonLoadGame.setText("LOAD PART");
            buttonLoadGame.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ButtonLoadGameActionPerformed(evt);
                }
            });

            buttonSettings.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
            buttonSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_Settings_96px.png"))); // NOI18N
            buttonSettings.setText("  SETTINGS ");
            buttonSettings.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ButtonSettingsActionPerformed(evt);
                }
            });
            buttonQuit.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
            buttonQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_Exit_100px.png"))); // NOI18N
            buttonQuit.setText("    QUIT      ");

            /**LAMBA EXPRESSION POUR LE CONTROLLEUR MenuController **/
            buttonQuit.addActionListener(e-> {
                menuController.onClickQuit();
            });




            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(buttonLoadGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buttonNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buttonSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buttonQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(80, 80, 80)
                                    .addComponent(buttonNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buttonLoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buttonSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buttonQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(64, Short.MAX_VALUE))
            );

            jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
            frame.getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            frame.pack();
        }// </editor-fold>//GEN-END:initComponents

        private void buttonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewGameActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_buttonNewGameActionPerformed

        private void ButtonLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoadGameActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ButtonLoadGameActionPerformed

        private void ButtonSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSettingsActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ButtonSettingsActionPerformed

        private void ButtonQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQuitActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ButtonQuitActionPerformed


    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton buttonLoadGame;
        private javax.swing.JButton buttonQuit;
        private javax.swing.JButton buttonSettings;
        private javax.swing.JButton buttonNewGame;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;

        //Controller
        private MenuController menuController;
        // End of variables declaration//GEN-END:variables
    }


