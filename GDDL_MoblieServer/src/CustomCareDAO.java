

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomCareDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	public CustomCareDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/"+FinalDB.dbProject+"?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			String dbID = FinalDB.dbID;
			String dbPassword = FinalDB.dbPassword;
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(dbURL, dbID, dbPassword);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Report(Custom_Module customer) {
		String SQL = "INSERT INTO customercare_tb VALUES (?,?,?,?,?,?)";
		try {
	         pstmt = conn.prepareStatement(SQL);
	         pstmt.setString(1,null);
	         pstmt.setString(2,customer.getTitle());
	         pstmt.setString(3,customer.getCheck_content());
	         pstmt.setString(4,customer.getContent());
	         pstmt.setString(5, customer.getReporter());
	         pstmt.setString(6, customer.getDefandant());
	         
	         pstmt.executeUpdate();
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         try {
	            pstmt.close();
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	}
}
