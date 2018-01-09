/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_projet;

import java.awt.Component;
import java.io.IOException;

import client.ClientDB;
import client.MainClient;
import packet.Commands;
import packet.ContentType;
import packet.Message;
import packet.Packet;
import packet.Ticket;
import utils.Id;

/**
 *
 * @author adrian
 */
public class Interface_CreationTicket extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	static String texteSaisieMessage = "Saisissez votre message ici.";
    static String texteIntitule = "Intitule";
    private GroupPanel[] groups;

    /**
     * Creates new form Interface_Connexion
     */
    public Interface_CreationTicket() {
    	groups = new GroupPanel[MainClient.user.getGroupList().size()];
    	int i = 0;
    	for(long id : MainClient.user.getGroupList()) {
    		groups[i++] = ClientDB.findGroup(id);
    	}
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saisieIntitule = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        saisieMessage = new javax.swing.JTextArea();
        BoutonAnnuler = new javax.swing.JButton();
        BoutonCreer = new javax.swing.JButton();
        listGroups = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("nouveau ticket");
        setResizable(false);

        saisieIntitule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaisieIntituleMouseClicked(evt);
            }
        });
        saisieIntitule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaisieIntituleActionPerformed(evt);
            }
        });

        saisieMessage.setColumns(20);
        saisieMessage.setRows(5);
        saisieMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saisieMessageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(saisieMessage);

        BoutonAnnuler.setText("Annuler");
        BoutonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAnnulerActionPerformed(evt);
            }
        });

        BoutonCreer.setText("Créer");
        BoutonCreer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonCreerActionPerformed(evt);
            }
        });

        listGroups.setModel(new javax.swing.DefaultComboBoxModel<>(groups));
        listGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listGroupsActionPerformed(evt);
            }
        });

        jLabel1.setText("Intitulé");

        jLabel2.setText("groupe destinataire");

        jLabel3.setText("Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(BoutonAnnuler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BoutonCreer)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listGroups, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saisieIntitule, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)))
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saisieIntitule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listGroups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonAnnuler)
                    .addComponent(BoutonCreer))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaisieIntituleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaisieIntituleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaisieIntituleActionPerformed

    private void BoutonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_BoutonAnnulerActionPerformed

    private void saisieMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saisieMessageMouseClicked
        Component component = evt.getComponent();
        if (saisieMessage.equals(component) && texteSaisieMessage.equals(saisieMessage.getText())) {
            saisieMessage.setText(null);
        }
    }//GEN-LAST:event_saisieMessageMouseClicked

    private void SaisieIntituleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaisieIntituleMouseClicked
        Component component = evt.getComponent();
        if (saisieIntitule.equals(component)&& texteIntitule.equals(saisieIntitule.getText())) {
            saisieIntitule.setText(null);
        }
    }//GEN-LAST:event_SaisieIntituleMouseClicked

    private void listGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listGroupsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listGroupsActionPerformed

    private void BoutonCreerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonCreerActionPerformed
    	long idGroup = ((GroupPanel)listGroups.getSelectedItem()).getId();
        String textMessage = saisieMessage.getText();
        String textIntitule = saisieIntitule.getText();
        Packet resp = null;
        if( !textIntitule.isEmpty() && !textMessage.isEmpty()) {
        	Ticket ticket = new Ticket(Commands.SEND, Id.DEFAULT_ID_TICKET, MainClient.user.getId(), idGroup, textIntitule, null);
        	try {
				MainClient.comm.send(ticket);
				resp = MainClient.comm.receive();
				System.out.println("recu : "+resp);
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				new Interface_NotificationErreur("Erreur de reseau :\n"+e.getStackTrace()).setVisible(true);
			}
        	if((resp == null) || (resp.getCommand() & Commands.FAIL) == Commands.FAIL) {
        		new Interface_NotificationErreur("Erreur pour la creation du ticket").setVisible(true);
        	} else {
        		Ticket t = (Ticket) resp;
        		ClientDB.add(t);
        		//TODO update display for ticket
        		Message messageToSend = new Message(Commands.SEND, Id.DEFAULT_ID_MESSAGE, MainClient.user.getId(), t.getId(), 0L, textMessage);
        		try {
					MainClient.comm.send(messageToSend);
					resp = MainClient.comm.receive();
					System.out.println("recu : "+resp);
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
					new Interface_NotificationErreur("Erreur de reseau :\n"+e.getStackTrace()).setVisible(true);
				}
        		if((resp == null) || (resp.getCommand() & Commands.FAIL) == Commands.FAIL) {
            		new Interface_NotificationErreur("Erreur pour la creation du message").setVisible(true);
            	} else {
            		ClientDB.add((Message)resp);
            	}
        	}
        	this.dispose();
        }else {
        	new Interface_NotificationErreur("Veuillez tout completer").setVisible(true);
        }
    }//GEN-LAST:event_BoutonCreerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonAnnuler;
    private javax.swing.JButton BoutonCreer;
    private javax.swing.JTextField saisieIntitule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<GroupPanel> listGroups;
    private javax.swing.JTextArea saisieMessage;
    // End of variables declaration//GEN-END:variables
}
