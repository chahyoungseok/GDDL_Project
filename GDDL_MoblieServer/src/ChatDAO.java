
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ChatDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	ServerModule serverModule;
	
	public ChatDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/"+FinalDB.dbProject+"?serverTimezone=Asia/Seoul&useSSL=false";
			String dbID = FinalDB.dbID;
			String dbPassword = FinalDB.dbPassword;
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(dbURL, dbID, dbPassword);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void MsgToDB(ServerModule serverModule) {
	     String SQL = "INSERT INTO chatting_tb VALUES(?,?,?,?,?)";
	     try{
	         pstmt = conn.prepareStatement(SQL);
	         pstmt.setString(1, null);
	         pstmt.setString(2, serverModule.getC_time());
	         pstmt.setString(3, serverModule.getSenderID());
	         pstmt.setString(4, serverModule.getMsg());
	         pstmt.setInt(5, 1);
	         
	         pstmt.executeUpdate();
	      }catch(Exception e) {
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
	
	public ArrayList<ServerModule> getChattingRecord(String userID,String otherID) {
		String SQL = "SELECT * FROM chatting_tb WHERE ( sender_id=\"" + userID + "\" OR sender_id=\"" + otherID + "\" ) AND alive= 1";
		ServerModule serverModule;
		ArrayList<ServerModule> chattingList = new ArrayList<ServerModule>();
		
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
		
			while(rs.next()){
				serverModule = new ServerModule();
				serverModule.setNum(rs.getInt(1));
				serverModule.setC_time(rs.getString(2));
				serverModule.setSenderID(rs.getString(3));
				serverModule.setMsg(rs.getString(4));
				chattingList.add(serverModule);	
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
		return chattingList;
	}
	
	public int updateAlive(String orderID,String errandID) {
		String SQL = "update chatting_tb set alive=0 where sender_id=\"" + orderID + "\" OR sender_id = \"" + errandID + "\"";
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
