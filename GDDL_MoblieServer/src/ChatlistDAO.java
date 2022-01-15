

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChatlistDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public ChatModule chat_module;
	
	public ChatlistDAO() {
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
	
	public ChatModule getID(String inputID) {
		
		String SQL = "SELECT * FROM chatlist_tb WHERE order_id=\"" + inputID + "\" OR errand_id=\"" + inputID + "\"";
		ChatModule chat_module = new ChatModule();
		
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
		
			while(rs.next()){
				chat_module.setIncreasNum(rs.getInt(1));
				chat_module.setOrderID(rs.getString(2));
				chat_module.setErrandID(rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return chat_module;
	}
	
	
	
	public void InsertChatRoom(String orderID,String errandID) {
		
		String SQL = "INSERT INTO chatlist_tb VALUES(?,?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,null);
			pstmt.setString(2,orderID);
			pstmt.setString(3,errandID);
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
	
	public int removeChattingRoom(String orderID,String errandID) {
		String SQL = "DELETE FROM chatlist_tb WHERE order_id=\"" + orderID + "\" AND errand_id=\"" + errandID + "\"";
		try {
			pstmt = conn.prepareStatement(SQL);
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;//데이터베이스 오류
	}
}
