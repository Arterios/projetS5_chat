/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_projet;

import java.awt.Component;

/**
 *
 * @author adrian
 */
public class Interface_Utilisateur_principale extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	static String texteSaisieMessage = "Saisissez votre texte ici.";
    /**
     * Creates new form JFrame
     */
    public Interface_Utilisateur_principale() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        arborescence = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        saisieMessage = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        messagesTicket = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPincipal.setLayout(new java.awt.GridLayout(1, 3));

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(arborescence.getPreferredSize());
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setAlignmentX(0.0F);
        jScrollPane4.setAutoscrolls(true);
        jScrollPane4.setPreferredSize(new java.awt.Dimension(100, 400));

        arborescence.setToolTipText("groupe1\n\tmessage1\n\tmessage2\ngroupe2\n\tmessage1\n\tmessage2");
        arborescence.setAlignmentX(0.0F);
        arborescence.setAlignmentY(0.0F);
        arborescence.setAutoscrolls(true);
        arborescence.setMaximumSize(new java.awt.Dimension(4000, 1000));
        arborescence.setPreferredSize(new java.awt.Dimension(150, 300));
        arborescence.setScrollsOnExpand(true);
        arborescence.setToggleClickCount(1);
        jScrollPane4.setViewportView(arborescence);

        jPanel1.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanelPincipal.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        saisieMessage.setColumns(20);
        saisieMessage.setRows(5);
        saisieMessage.setText(texteSaisieMessage);
        saisieMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saisieMessageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(saisieMessage);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.SOUTH);

        messagesTicket.setModel(new javax.swing.AbstractListModel<String>() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(messagesTicket);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanelPincipal.add(jPanel2);

        getContentPane().add(jPanelPincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saisieMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saisieMessageMouseClicked
        // TODO add your handling code here:
        Component component = evt.getComponent();
        if (saisieMessage.equals(component)&&texteSaisieMessage.equals(saisieMessage.getText())){
            saisieMessage.setText(null);
        }
    }//GEN-LAST:event_saisieMessageMouseClicked

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
            java.util.logging.Logger.getLogger(Interface_Utilisateur_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface_Utilisateur_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface_Utilisateur_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface_Utilisateur_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface_Utilisateur_principale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arborescence;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelPincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> messagesTicket;
    private javax.swing.JTextArea saisieMessage;
    // End of variables declaration//GEN-END:variables
}
