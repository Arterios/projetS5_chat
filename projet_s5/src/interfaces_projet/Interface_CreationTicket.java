/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_projet;

import java.io.IOException;

import client.ClientDB;
import client.MainClient;
import packet.Commands;
import packet.Message;
import packet.Packet;
import packet.Ticket;
import utils.Id;
import utils.StatusType;

/**
 *
 * @author adrian
 */
public class Interface_CreationTicket extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
    private GroupPanel[] groups;

    /**
     * Creates new form Interface_Connexion
     */
    public Interface_CreationTicket() {
    	groups = MainClient.getConnectedUser().getGroupList().toArray(groups);
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
        labelIntitule = new javax.swing.JLabel();
        labelGroupDest = new javax.swing.JLabel();
        labelMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("nouveau ticket");
        setAlwaysOnTop(true);
        setResizable(false);

        saisieMessage.setColumns(20);
        saisieMessage.setRows(5);
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

        labelIntitule.setText("Intitulé");

        labelGroupDest.setText("groupe destinataire");

        labelMessage.setText("Message");

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
                .addComponent(labelMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listGroups, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saisieIntitule, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(labelIntitule))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelGroupDest)))
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelIntitule)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saisieIntitule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelGroupDest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listGroups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelMessage)
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

    private void BoutonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_BoutonAnnulerActionPerformed

    private void listGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listGroupsActionPerformed
        // TODO potentiellement a supprimer
    	
    }//GEN-LAST:event_listGroupsActionPerformed

    private void BoutonCreerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonCreerActionPerformed
    	long idGroup = ((GroupPanel)listGroups.getSelectedItem()).getId();
        String textMessage = saisieMessage.getText();
        String textIntitule = saisieIntitule.getText();
        Packet resp = null;
        if( !textIntitule.isEmpty() && !textMessage.isEmpty()) {
        	Ticket ticket = new Ticket(Commands.SEND, Id.DEFAULT_ID_TICKET, MainClient.getConnectedUser().getId(), idGroup, textIntitule, null);
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
        		Message messageToSend = new Message(Commands.SEND, Id.DEFAULT_ID_MESSAGE, MainClient.getConnectedUser().getId(), t.getId(), 0L, StatusType.MESSAGE_PENDING, textMessage);
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
    private javax.swing.JLabel labelIntitule;
    private javax.swing.JLabel labelGroupDest;
    private javax.swing.JLabel labelMessage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<GroupPanel> listGroups;
    private javax.swing.JTextArea saisieMessage;
    // End of variables declaration//GEN-END:variables
}
