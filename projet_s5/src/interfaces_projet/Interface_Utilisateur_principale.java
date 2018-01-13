package interfaces_projet;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import client.MainClient;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface_Utilisateur_principale extends javax.swing.JFrame implements TreeSelectionListener{
	private static final long serialVersionUID = 1L;
	static String texteSaisieMessage = "Saisissez votre texte ici.";
	private UserPanel user;

	/**
	 * Creates new form JFrame
	 */
	public Interface_Utilisateur_principale(UserPanel user) {
		setMinimumSize(new Dimension(200, 200));
		this.user = user;
		initComponents();
        this.setLocationRelativeTo(null);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to close the app?", "Really Closing?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					// action on closing
					MainClient.close();
				}
			}
		});
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	}

	private void initComponents() {

		setPreferredSize(new Dimension(560, 600));		
        setTitle("forum universite");

		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Tickets");
		System.out.println(user);
		if (!user.getTicketList().isEmpty()) {
			for (TicketPanel ticket : user.getTicketList()) {
				DefaultMutableTreeNode ticketNode = new DefaultMutableTreeNode(ticket);
				/*if (!groupe.getTicketList().isEmpty()) {
					Iterable<TicketPanel> iterable3 = groupe.getTicketList();
					System.out.println("iterable3=" + iterable3.toString());
					for (TicketPanel ticket : iterable3) {
						DefaultMutableTreeNode treeNode3 = new DefaultMutableTreeNode(ticket.getName());
						treeNode2.add(treeNode3);
					}
				}*/
				top.add(ticketNode);
				
			}
		}
		arborescence = new JTree(top);
		arborescence.setAutoscrolls(true);
		arborescence.setScrollsOnExpand(true);
		arborescence.setToggleClickCount(1);
		arborescence.addTreeSelectionListener(this);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
								
		splitPane = new JSplitPane();
		splitPane.setPreferredSize(null);
		splitPane.setDividerSize(3);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		leftJPanel = new javax.swing.JPanel();				
		leftJPanel.setLayout(new BorderLayout(0, 0));
		
		ticketScrollPane = new javax.swing.JScrollPane();
		ticketScrollPane.setAutoscrolls(true);
		
		ticketScrollPane.setViewportView(arborescence);
		leftJPanel.add(ticketScrollPane);
		
		newTicketButton = new JButton("Nouveau Ticket");
		newTicketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newTicketButtonAction();
			}
		});
		leftJPanel.add(newTicketButton, BorderLayout.SOUTH);
		rightJPanel = new javax.swing.JPanel();
								
		rightJPanel.setLayout(new java.awt.BorderLayout());
										
		ticketViewer = 	new javax.swing.JScrollPane();
		ticketViewer.setPreferredSize(new Dimension(150, 460));
		ticketViewer.setViewportView(new TicketPanel(0, "", null, null, null));
		textPanel = new javax.swing.JScrollPane();
		saisieMessage = new javax.swing.JTextArea();
		saisieMessage.setPreferredSize(new Dimension(4, 60));
		
		saisieMessage.setText(texteSaisieMessage);
		saisieMessage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				saisieMessageMouseClicked(evt);
			}
		});
		textPanel.setViewportView(saisieMessage);
		
		rightJPanel.add(textPanel, java.awt.BorderLayout.SOUTH);
		rightJPanel.add(ticketViewer, BorderLayout.CENTER);

		splitPane.setRightComponent(rightJPanel);
		splitPane.setLeftComponent(leftJPanel);

		pack();
		
		splitPane.setDividerLocation(0.25);
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node =  (DefaultMutableTreeNode) arborescence.getLastSelectedPathComponent();
		try {
			TicketPanel t = (TicketPanel) node.getUserObject();
			displayTicket(t);
		} catch (ClassCastException ec) {
			// expected to happen when user click on top node
		} 
	}
	
	private void newTicketButtonAction() {
		new Interface_CreationTicket().setVisible(true);
	}
	
	private void displayTicket(TicketPanel ticket) {
		ticketViewer.setViewportView(ticket);
		ticket.loadMessage();
		pack();
	}

	private void saisieMessageMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_saisieMessageMouseClicked

		Component component = evt.getComponent();
		if (saisieMessage.equals(component) && texteSaisieMessage.equals(saisieMessage.getText())) {
			saisieMessage.setText(null);
		}
	}

	private javax.swing.JTree arborescence;
	private javax.swing.JPanel leftJPanel;
	private javax.swing.JPanel rightJPanel;
	private javax.swing.JScrollPane textPanel;
	private javax.swing.JScrollPane ticketViewer;
	private javax.swing.JScrollPane ticketScrollPane;
	private javax.swing.JTextArea saisieMessage;
	private JSplitPane splitPane;
	private JButton newTicketButton;
}
