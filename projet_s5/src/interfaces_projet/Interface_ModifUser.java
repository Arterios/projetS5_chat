
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_projet;

import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author adrian
 */
public class Interface_ModifUser extends javax.swing.JFrame {

	UserPanel user;
	
    /**
     * Creates new form Interface_modifUser
     */
    public Interface_ModifUser(UserPanel user) {
    	this.user = user;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        boutonAnnuler = new javax.swing.JButton();
        boutonAddUser = new javax.swing.JButton();
        saisieNom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        saisiePrenom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        saisieMDP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        saisieMail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("modification utilisateur");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel4.setText("adressse mail");

        boutonAnnuler.setText("annuler");
        boutonAnnuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boutonAnnulerMouseClicked(evt);
            }
        });

        boutonAddUser.setText("ajouter utilisateur");
        boutonAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boutonAddUserMouseClicked(evt);
            }
        });

        saisieNom.setText(user.getNom());
        
        jLabel1.setText("Nom");

        saisiePrenom.setText(user.getPrenom());
        jLabel2.setText("Prenom");

        jLabel3.setText("nouveau mot de passe");
        
        saisieCategorie = new JTextField();
        saisieCategorie.setText(user.getCategory());
        
        JLabel label = new JLabel();
        label.setText("Categorie");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(20)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(saisieNom, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        						.addComponent(saisiePrenom, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(10)
        							.addComponent(jLabel2))
        						.addComponent(saisieCategorie, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(10)
        							.addComponent(label, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(29)
        					.addComponent(jLabel1)))
        			.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addGroup(layout.createSequentialGroup()
        						.addGap(10)
        						.addComponent(jLabel3))
        					.addComponent(saisieMDP)
        					.addComponent(saisieMail, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(jLabel4)))
        			.addGap(20))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(34)
        			.addComponent(boutonAnnuler)
        			.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
        			.addComponent(boutonAddUser)
        			.addGap(45))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(26)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(saisieNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel4)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(saisieMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel3)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(saisieMDP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel2)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(saisiePrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(18)
        			.addComponent(label)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(saisieCategorie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(boutonAnnuler)
        				.addComponent(boutonAddUser))
        			.addContainerGap(30, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    private void boutonAnnulerMouseClicked(java.awt.event.MouseEvent evt) {                                           
        this.dispose();
    }                                          

    private void boutonAddUserMouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:

        //recuperer les donnees dans les differents JTextFields et ajouter a la BD

        /*	new Interface_NotificationSucces().setVisible(true);
        this.dispose();
        }else {
            new Interface_NotificationErreur("Veuillez tout compléter").setVisible(true);
        }*/
    }
    
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
            java.util.logging.Logger.getLogger(Interface_ModifUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface_ModifUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface_ModifUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface_ModifUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	UserPanel hugo = new UserPanel(10, "ROUSSEL", "Hugo", "CAT", new ArrayList<>() , new ArrayList<>());
                new Interface_ModifUser(hugo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton boutonAddUser;
    private javax.swing.JButton boutonAnnuler;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField saisieMDP;
    private javax.swing.JTextField saisieMail;
    private javax.swing.JTextField saisieNom;
    private javax.swing.JTextField saisiePrenom;
    private JTextField saisieCategorie;
}
