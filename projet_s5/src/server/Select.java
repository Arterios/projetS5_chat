package server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import packet.Commands;
import packet.Group;
import packet.Message;
import packet.Ticket;
import packet.User;
import utils.StatusType;

public class Select {
	private String sql;
	protected long connect (String motDePasse, String mail,java.sql.Statement state) {
		long i = -1;
		sql = "SELECT idUtilisateur FROM utilisateur WHERE motDePasse = SHA1('"+motDePasse+"') AND courriel= '"+mail+"';";
		try {
			ResultSet r = state.executeQuery(sql);
			if(r.next()){ 
				System.out.println("[OK] requete connect");
				i=r.getLong(1);
			}
			r.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	protected List<Long> idMessageOfTicket (long idTicket,java.sql.Statement state) {
		List<Long> l = new ArrayList<>();
		sql = "SELECT DISTINCT idMessage FROM message WHERE idTicketMessage = '"+idTicket+"' ORDER BY dateMessage;";
		try {
			ResultSet r = state.executeQuery(sql);
			while(r.next()){ 
				if(!l.contains(r.getObject(1)))
					l.add(r.getLong(1));
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l ;
	}
	protected List<Long> idutilInGroup (long idGrp,java.sql.Statement state) {
		List<Long> l = new ArrayList<>();
		sql = "SELECT * FROM posseder WHERE idGroupePosseder = '"+idGrp+"';";
		try {
			ResultSet r = state.executeQuery(sql);
			while(r.next()){ 
				l.add(r.getLong(2));
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	private void changeStatus(long idMessage ,long idUser,java.sql.Statement state) {
		sql="SELECT * FROM status WHERE idLecteur ='"+idUser+"' AND idMessageStatus = '"+idMessage+"' AND etat = '"+StatusType.USER_PENDING+"' ;";
		try {
			ResultSet r = state.executeQuery(sql);
			if (r.next() ) {
				sql="UPDATE status SET etat = '"+StatusType.USER_SENT+"' WHERE	idLecteur ='"+idUser+"' AND idMessageStatus = '"+idMessage+"';";
				state.executeUpdate(sql);
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected Message RecupMessage (long idMessage ,long idUser,java.sql.Statement state){
		
		changeStatus(idMessage, idUser, state);
		byte status = recupStatusMessage(idMessage, state);
		sql= "SELECT UNIX_TIMESTAMP(dateMessage),auteur,message,idTicketMessage FROM message WHERE idMessage= '"+idMessage+"';";
		Message m = null;
		try {
			ResultSet r = state.executeQuery(sql);
			if(r.next()) {
				
				long user = r.getLong(2);
				long ticket = r.getLong(4);
				long time = r.getLong(1);
				String text = r.getString(3);
				m = new Message(Commands.SEND,idMessage,user,ticket,time, status, text);
				
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return m;
		}
		return m;
	}
	
	private List<Long> recupListTicketOfUser (long idUser,java.sql.Statement state){
		List<Long> listTicket = new ArrayList<>();
		sql= "SELECT DISTINCT  idTicket,idUtilisateurPosseder,auteur FROM ticket,message,posseder where idTicketMessage = idTicket and idGroupeDestinataire = idGroupePosseder and ( auteur='"+idUser+"'OR  idUtilisateurPosseder='"+idUser+"')ORDER BY dateMessage DESC;";
		try {
			ResultSet r = state.executeQuery(sql);
			while(r.next()) {
				if(!listTicket.contains(r.getLong(1)))
					listTicket.add(r.getLong(1));
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTicket;
	}
	private List<Long> recupListGroupOfUser (long idUser,java.sql.Statement state){
		List<Long> Listgroup = new ArrayList<>();
		sql= "SELECT idGroupePosseder FROM posseder,groupe WHERE idUtilisateurPosseder = '"+idUser+"' AND idGroupePosseder = idGroupe ;";
		try {
			ResultSet r = state.executeQuery(sql);
			while(r.next()) {
				Listgroup.add(r.getLong(1));
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Listgroup;
	}
	
	protected User recupUserWithList(long idUser,java.sql.Statement state){
		sql= "SELECT nomUtilisateur,prenom,categorie FROM utilisateur WHERE idUtilisateur ='"+idUser+"' AND courriel IS NOT NULL;";
		User u = null;
		try {
			ResultSet r = state.executeQuery(sql);
			if(r.next()) {
				String nom = r.getString(1);
				String prenom = r.getString(2);
				String agent = r.getString(3);
				List<Long> groups = recupListGroupOfUser(idUser,state);
				List<Long> tickets = recupListTicketOfUser(idUser, state);
				u = new User(Commands.SEND,idUser,nom,prenom,agent,groups,tickets);
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	protected User recupUserShort(long idUser,java.sql.Statement state){
		sql= "SELECT nomUtilisateur,prenom,categorie FROM utilisateur WHERE idUtilisateur ='"+idUser+"' AND courriel IS NOT NULL;";
		User u = null;
		try {
			ResultSet r = state.executeQuery(sql);
			if(r.next()) {
				return new User(Commands.SEND,idUser,r.getString(1),r.getString(2),r.getString(3),null,null);
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return u;
		}
		return u;
	}
	protected String nameOfGroup ( long idGroup ,java.sql.Statement state){
		sql="SELECT nomGroupe FROM groupe WHERE idGroupe = '"+idGroup+"';";
		try {
			ResultSet r = state.executeQuery(sql);
			if(r.next()){ 
				return r.getString(1);
			}
			r.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private long retrieveAuthorOfTicket (long idTicket,java.sql.Statement state){
		sql="SELECT DISTINCT auteur,dateMessage FROM ticket,message WHERE idTicket ='"+idTicket+"' AND idTicketMessage = idTicket ORDER BY dateMessage;";
		try {
			ResultSet r = state.executeQuery(sql);
			if(r.next()){ 
				return r.getLong(1);
			}
			r.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1 ;
	}
	protected Group retrieveGroup(long idGroup,java.sql.Statement state) {
		sql = "SELECT nomGroupe FROM groupe WHERE idGroupe = '"+idGroup+"';";
		Group g = null;
		try {
			ResultSet r = state.executeQuery(sql);
			if(r.next()) {
				g = new Group(Commands.SEND,idGroup,r.getString(1));
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return g;
	}
	protected Ticket retrieveTicket (long idTicket,java.sql.Statement state){
		long idGroup = 0;
		long idAuteur ;
		String name ;
		sql = "SELECT idGroupeDestinataire,objet FROM ticket WHERE idTicket ='"+idTicket+"' ";
		try {
			ResultSet r = state.executeQuery(sql);
			if(r.next()){ 
				idGroup = r.getLong(1);
				name = r.getString(2);
			}else {
				return null;
			}
			r.close();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		if ( (idAuteur = retrieveAuthorOfTicket(idTicket, state)) ==-1) {
			idAuteur = 0L;
		}
		return new Ticket(Commands.SEND,idTicket,idAuteur,idGroup,name,idMessageOfTicket(idTicket, state));
	}
	protected List<User> retrieveAllUser(java.sql.Statement state) {
		sql = "SELECT idUtilisateur,nomUtilisateur,prenom,categorie FROM utilisateur WHERE courriel IS NOT NULL";
		List<User> listUser = new ArrayList<>();
		try {
			ResultSet r = state.executeQuery(sql);
			while(r.next()) {
				listUser.add(new User(Commands.SEND,r.getLong(1),r.getString(2),r.getString(3),r.getString(4),null,null));
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listUser;
	}
	protected List<Group> retrieveAllGroup(java.sql.Statement state) {
		sql = "SELECT idGroupe,nomGroupe FROM groupe";
		List<Group> listGrp = new ArrayList<>();
		try {
			ResultSet r = state.executeQuery(sql);
			while(r.next()) {
				listGrp.add(new Group(Commands.SEND,r.getLong(1),r.getString(2)));
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listGrp;
	}
	protected HashMap<Byte,List<Long>> recupStatus(long idMessage,java.sql.Statement state){
		HashMap<Byte,List<Long>> status = new HashMap<>();
		status.put(StatusType.USER_PENDING, new ArrayList<>());
		status.put(StatusType.USER_SENT, new ArrayList<>());
		status.put(StatusType.USER_READ, new ArrayList<>());
		sql = "SELECT idLecteur,etat FROM status WHERE IdMessageStatus = '"+idMessage+"'";
		try {
			ResultSet r = state.executeQuery(sql);
			while(r.next()) {
				status.get(r.getByte(2)).add(r.getLong(1));
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.err.println(status);
		return status;
	}
	
	protected byte recupStatusMessage(long idMessage, java.sql.Statement state) {
		byte ret = 0;
		HashMap<Byte, List<Long>> etat = recupStatus(idMessage, state);
		if(etat.get(StatusType.USER_PENDING).isEmpty()) {
			if(etat.get(StatusType.USER_SENT).isEmpty()) {
				ret = StatusType.USER_READ;
			} else {
				ret = StatusType.USER_SENT;
			}
		} else {
			ret = StatusType.USER_PENDING;
		}
		return ret;
	}
	protected String recupMail(long idUser, java.sql.Statement state) {
		sql = "SELECT courriel FROM utilisateur WHERE idUtilisateur= '"+idUser+"';";
		try {
			ResultSet r = state.executeQuery(sql);
			if(r.next()) {
				return r.getString(1);
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	protected List<Long> retrieveUserRecipientOfMessage (long idMessage, java.sql.Statement state){
		sql="SELECT idGroupeDestinataire,idTicket FROM ticket,message WHERE	idTicketMessage=idTicket AND idMessage = '"+idMessage+"' ;";
		ResultSet r;
		List<Long> listUser = null;
		try {
			r = state.executeQuery(sql);
			if (r.next()) {
				long idGrp = r.getLong(1);
				long ticket = r.getLong(2);
				listUser = idutilInGroup(idGrp, state);
				listUser.add(retrieveAuthorOfTicket(ticket, state));
			}else {
				return null;
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
}
