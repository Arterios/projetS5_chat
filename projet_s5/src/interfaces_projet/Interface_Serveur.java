package interfaces_projet;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.Categorie;
import packet.Group;
import packet.User;
import server.Database;


public class Interface_Serveur extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private List<UserPanel> listUser = new ArrayList<>();
	private List<GroupPanel> listGroup=new ArrayList<>();
	public class ConfirmDialogInFrame extends JFrame{
		private static final long serialVersionUID = 1L;
		public ConfirmDialogInFrame() {
	        setVisible(false);
	        setAlwaysOnTop(true);
	    }
	}
	private Database data ;
    public Interface_Serveur(Database datab) {
    	this.data =datab;
    	if(data.isStarted()) {
	        initComponents();
	        this.setLocationRelativeTo(null);
	        this.addWindowListener(new java.awt.event.WindowAdapter() {
	        	@Override
	     		public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	        		if (JOptionPane.showConfirmDialog(new ConfirmDialogInFrame(), "Are you sure to close this window?", "Really Closing?",
	        				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
	     				data.closeConnection();
	     				System.exit(0);
	     			}
	     		}
	     	});
    	} else {
    		System.err.println("Cannot start server : database not started");
    	}
    }
    private void recupUserPanel(){
    	List<User> lUser = data.retrieveAllUser();
    	this.listUser.clear();
    	for(User u : lUser ) {
    		this.listUser.add(new UserPanel(u.getId(), u.getNom(), u.getPrenom(), u.getCategory(), null, null));
    	}
    }
    private void recupGroupPanel(){
    	List<Group> lGroup = data.retrieveAllGroup();
    	this.listGroup.clear();
    	for(Group g : lGroup ) {
    		this.listGroup.add(new GroupPanel(g.getId(), g.getName()));
    	}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
		recupUserPanel();
		recupGroupPanel();
        tableau = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        boutonAddUser = new javax.swing.JButton();
        boutonDelUser = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        boutonModifUser = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listUsers = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        groups = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeDesUtilisateurs = new javax.swing.JList<>();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButtonMoveUserInGroup = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        boutonRemoveFromGroup = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listGroups = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        boutonAddGroup = new javax.swing.JButton();
        boutonDelGroup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
       
        setTitle("gestion du serveur");

        tableau.setAutoscrolls(true);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 2, 20));

        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        boutonAddUser.setText("ajouter un utilisateur");
        boutonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	addUserActionPerformed();
            }
        });
        jPanel7.add(boutonAddUser);

        boutonDelUser.setText("supprimer un utilisateur");
        boutonDelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	deleteUserAction();
            }
        });
        jPanel7.add(boutonDelUser);

        jPanel6.add(jPanel7);

        jPanel2.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel8.setLayout(new java.awt.BorderLayout());

        boutonModifUser.setText("modifier utilisateur");
        boutonModifUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	modifUserAction();
            }
        });
        jPanel8.add(boutonModifUser, java.awt.BorderLayout.PAGE_END);
       
        listUsers.setModel(new javax.swing.AbstractListModel<String>() {
        	private static final long serialVersionUID = 1L;
			private List<UserPanel> listUserU = listUser;       	
            public int getSize() { return listUserU.size(); }
            public String getElementAt(int i) { return listUserU.get(i).getPrenom()+" "+listUserU.get(i).getNom();}
        });
        jScrollPane2.setViewportView(listUsers);

        jPanel8.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(jPanel5);

        tableau.addTab("Utilisateurs", jPanel1);

        groups.setLayout(new java.awt.GridLayout(1, 0));

        listeDesUtilisateurs.setModel(new javax.swing.AbstractListModel<String>() {
        	private static final long serialVersionUID = 1L;
        	private List<UserPanel> listUserg =  listUser;
            public int getSize() { return listUserg.size(); }
            public String getElementAt(int i) { return listUserg.get(i).getPrenom()+" "+listUserg.get(i).getNom(); }
        });
        jScrollPane1.setViewportView(listeDesUtilisateurs);

        groups.add(jScrollPane1);

        jPanel9.setLayout(new java.awt.GridLayout(4, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel10);

        jPanel11.setLayout(new java.awt.BorderLayout());

        jButtonMoveUserInGroup.setText("-- ajouter au groupe ->");
        jButtonMoveUserInGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	moveUserInGroup();
            }
        });
        jPanel11.add(jButtonMoveUserInGroup, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel11);

        jPanel12.setLayout(new java.awt.BorderLayout());

        boutonRemoveFromGroup.setText("<- retirer du groupe --");
        boutonRemoveFromGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	moveUserOutGroup();
            }
        });
        jPanel12.add(boutonRemoveFromGroup, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel12);

        jPanel13.setLayout(new java.awt.BorderLayout());
        jPanel9.add(jPanel13);

        groups.add(jPanel9);

        jPanel3.setLayout(new java.awt.BorderLayout());

        listGroups.setModel(new javax.swing.AbstractListModel<String>() {
        	private static final long serialVersionUID = 1L;
            private List<GroupPanel> listGrp = listGroup;
            public int getSize() { return listGrp.size(); }
            public String getElementAt(int i) { return listGrp.get(i).getName(); }
        });
        jScrollPane3.setViewportView(listGroups);

        jPanel3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        boutonAddGroup.setText("ajouter un groupe");
        boutonAddGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	addGroup();
            }
        });
        jPanel4.add(boutonAddGroup);

        boutonDelGroup.setText("supprimer un groupe");
        boutonDelGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	deleteGroup();
            }
        });
        jPanel4.add(boutonDelGroup);

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        groups.add(jPanel3);

        tableau.addTab("Groupes", groups);

        getContentPane().add(tableau, java.awt.BorderLayout.PAGE_START);

        pack();
    }
    private void addUserActionPerformed() {
    	new Interface_ModifUser(new UserPanel(0, "nom", "prenom", Categorie.INVITE.toString(), null, null),this).setVisible(true);
    }
    public Database getDatabase() {
    	return data;
    }
    public void refreshPage2() {
    	recupGroupPanel();
    	listGroups.updateUI();
    }
    private void addGroup() {
    		new Interface_AddGroup( this).setVisible(true);
    }
    private void deleteGroup() {
    	int selectGroup = listGroups.getSelectedIndex();
    	if(selectGroup != -1 && 0 !=data.deleteGroup(listGroup.get(selectGroup).getId())){
    		JOptionPane.showMessageDialog(null,listGroup.get(selectGroup).getName()+" a bien �t� supprim� ",
    				    "",JOptionPane.INFORMATION_MESSAGE);
    		refreshPage2();
    	}
    }
    private void moveUserInGroup() {
    	int selectUser = listeDesUtilisateurs.getSelectedIndex();
    	int selectGroup = listGroups.getSelectedIndex();
    	int i = 0;
    	if(selectUser != -1 && selectGroup != -1) {
    		i=data.addGroupToUser(listGroup.get(selectGroup).getId(),listUser.get(selectUser).getId());
    		if( i!=1) {
    			JOptionPane.showMessageDialog(null,"Erreur cet utilisateur est deja dans ce groupe","Erreur",JOptionPane.ERROR_MESSAGE);
    		}else {
    			JOptionPane.showMessageDialog(null, listUser.get(selectUser).getPrenom()+" "+listUser.get(selectUser).getNom()+" a bien �t� deplac� dans "+listGroup.get(selectGroup).getName(),
    				    "",JOptionPane.INFORMATION_MESSAGE);
    		}
    	}else {
    		JOptionPane.showMessageDialog(null,"Attention: Veuillez selectionner un utilisateur et un groupe","Erreur",JOptionPane.ERROR_MESSAGE);
        	}
    }
    private void moveUserOutGroup() {
    	int selectUser = listeDesUtilisateurs.getSelectedIndex();
    	int selectGroup = listGroups.getSelectedIndex();
    	int i = 0;
    	if(selectUser != -1 && selectGroup != -1) {
    		i=data.takeUserOutOfGroup(listGroup.get(selectGroup).getId(),listUser.get(selectUser).getId());
    		if( i!=1) {
    			JOptionPane.showMessageDialog(null,"Erreur cet utilisateur n'est pas dans ce groupe","Erreur",JOptionPane.ERROR_MESSAGE);
    		}else {
    			JOptionPane.showMessageDialog(null, listUser.get(selectUser).getPrenom()+" "+listUser.get(selectUser).getNom()+" a bien �t� enlev� du groupe "+listGroup.get(selectGroup).getName(),
    				    "",JOptionPane.INFORMATION_MESSAGE);
    		}
    	}else {
    		JOptionPane.showMessageDialog(null,"Attention: Veuillez selectionner un utilisateur et un groupe","Erreur",JOptionPane.ERROR_MESSAGE);
    	}
    }
    private void deleteUserAction() {
    	int selectUser = listUsers.getSelectedIndex();
    	if(selectUser !=-1) {
    		if (1== data.deleteUser(listUser.get(selectUser).getId())) {
    			JOptionPane.showMessageDialog(null, "utilisateur supprimer.",
    				    "",JOptionPane.INFORMATION_MESSAGE);
    			refreshPage1();
    		}else {
    			JOptionPane.showMessageDialog(null, "Veuillez contacter les developpeurs.",
    				    "Erreur",JOptionPane.ERROR_MESSAGE);
    		}
    	}else {
    		JOptionPane.showMessageDialog(null, "Veuillez selectionner un utilisateur.",
				    "Erreur",JOptionPane.ERROR_MESSAGE);
    	}
    }
    public void refreshPage1() {
    	recupUserPanel();
    	listUsers.updateUI();
    }
    private void modifUserAction() {
    	int selectUser = listUsers.getSelectedIndex();
    	if(selectUser !=-1) {
    		new Interface_ModifUser(listUser.get(selectUser),this).setVisible(true);
    	}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonAddGroup;
    private javax.swing.JButton boutonAddUser;
    private javax.swing.JButton boutonDelGroup;
    private javax.swing.JButton boutonDelUser;
    private javax.swing.JPanel groups;
    private javax.swing.JButton jButtonMoveUserInGroup;
    private javax.swing.JButton boutonRemoveFromGroup;
    private javax.swing.JButton boutonModifUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listGroups;
    private javax.swing.JList<String> listUsers;
    private javax.swing.JList<String> listeDesUtilisateurs;
    private javax.swing.JTabbedPane tableau;
    // End of variables declaration//GEN-END:variables
}
