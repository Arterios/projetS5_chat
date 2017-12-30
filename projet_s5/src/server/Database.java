package server;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static Connection conn = null;
	private static java.sql.Statement state = null ;
	private static Add add = new Add();
	private static Delete delete = new Delete();
	
	public static int start(String url , String user , String passwd) {
		int i =0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver charger [OK]");
			
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("connection [OK]");
			state = conn.createStatement();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("PATATE");
			e.printStackTrace();
			i=1;
		}
		return i;
	}
	public static boolean isStarted() {
		if (state == null) {
			System.out.println("la connection n'a pas été établie");
			return false;
		}
		return true ;
	}
	public static int addgroup(long val, String nom){
		if (isStarted())
			return add.addgroup(val,nom,state);
		else
			return -1;
	}
	
	public static int deletegroup (long val) {
		if (isStarted())
			return delete.deletegroup(val, state);
		else
			return -1;
	}
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/projet";
		String user = "root";
		String passwd = "";
		start(url,user,passwd);
		String groupe = "sfhj";
		long val = 05655;
		System.out.println(addgroup(val,groupe));
		
	}

}