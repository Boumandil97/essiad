package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class connexion {
	
public static Connection conexion;
public	Connection getConnection() throws SQLException, ClassNotFoundException {
	
String	password="1234";
	String username="root";
	


	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
		 System.out.println("connexion reussi");
	} catch (SQLException e) {
	System.out.println("probleme de connexion");
		e.printStackTrace();
	}
	
	
	return conexion;
}
public static void stt(String query) {
	
	try {
		Statement state=conexion.createStatement();
		state.executeUpdate(query);
		System.out.println("ligne inseré avec succes");
	} catch (SQLException e) {
		System.out.println("ligne non insere");
		e.printStackTrace();
	}
	
}
public void disconnect() throws SQLException {
	conexion.close();
	System.out.println("you are disconnected");
}
public Statement exec() throws SQLException {
	Statement state=conexion.createStatement();
	return state;
	
	
	
}
}
