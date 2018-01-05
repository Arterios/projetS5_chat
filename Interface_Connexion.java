/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.Component;

/**
 *
 * @author adrian
 */
public class Interface_Connexion extends javax.swing.JFrame {
    final String texteSaisieMDP = "mot de passe";
    final String texteSaisieIdentifiant = "identifiant";
    /**
     * Creates new form Interface_Connexion
     */
    public Interface_Connexion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        saisieIdentifiant = new javax.swing.JTextField();
        saisieMDP = new javax.swing.JTextField();
        boutonConnexion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        boutonInscription = new javax.swing.JButton();
        boutonOublie = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("connexion");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        saisieIdentifiant.setText("identifiant");
        saisieIdentifiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saisieIdentifiantMouseClicked(evt);
            }
        });
        saisieIdentifiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saisieIdentifiantActionPerformed(evt);
            }
        });

        saisieMDP.setText("mot de passe");
        saisieMDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saisieMDPMouseClicked(evt);
            }
        });
        saisieMDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saisieMDPActionPerformed(evt);
            }
        });

        boutonConnexion.setText("se connecter");
        boutonConnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boutonConnexionMouseClicked(evt);
            }
        });
        boutonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonConnexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saisieMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saisieIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boutonConnexion)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(saisieIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saisieMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(boutonConnexion)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        boutonInscription.setText("inscription");
        boutonInscription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boutonInscriptionMouseClicked(evt);
            }
        });

        boutonOublie.setText("mot de passe oublié ?");
        boutonOublie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonOublieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(boutonInscription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addComponent(boutonOublie)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutonOublie)
                    .addComponent(boutonInscription))
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonOublieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonOublieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonOublieActionPerformed

    private void saisieIdentifiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saisieIdentifiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saisieIdentifiantActionPerformed

    private void saisieMDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saisieMDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saisieMDPActionPerformed

    private void boutonInscriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boutonInscriptionMouseClicked
        // TODO add your handling code here:
        new Interface_Inscription().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutonInscriptionMouseClicked

    private void boutonConnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boutonConnexionMouseClicked
        // TODO add your handling code here:
        if(/*test validité ID et MDP*/true)
            new Interface_Utilisateur_principale().setVisible(true);
        else
            new Interface_ErreurCo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutonConnexionMouseClicked

    private void boutonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonConnexionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonConnexionActionPerformed

    private void saisieIdentifiantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saisieIdentifiantMouseClicked
        // TODO add your handling code here:
        Component component = evt.getComponent();
        if (saisieIdentifiant.equals(component)&&texteSaisieIdentifiant.equals(saisieIdentifiant.getText())){
            saisieIdentifiant.setText(null);
        }
    }//GEN-LAST:event_saisieIdentifiantMouseClicked

    private void saisieMDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saisieMDPMouseClicked
        // TODO add your handling code here:
        Component component = evt.getComponent();
        if (saisieMDP.equals(component)&&texteSaisieMDP.equals(saisieMDP.getText())){
            saisieMDP.setText(null);
        }
    }//GEN-LAST:event_saisieMDPMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface_Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface_Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface_Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface_Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface_Connexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonConnexion;
    private javax.swing.JButton boutonInscription;
    private javax.swing.JButton boutonOublie;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField saisieIdentifiant;
    private javax.swing.JTextField saisieMDP;
    // End of variables declaration//GEN-END:variables
}