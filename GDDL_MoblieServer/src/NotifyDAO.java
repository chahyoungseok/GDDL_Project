

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NotifyDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	Date time = new Date();
	String timeNow = format.format(time);
	
	public NotifyDAO() {
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
	
	public void InsertNotify(String editTitle, String editContent) {
		String SQL = "INSERT INTO notify_tb VALUES (?, ?, ?, ?)";
		
	      try {
	         pstmt = conn.prepareStatement(SQL);
	         pstmt.setString(1,null);
	         pstmt.setString(2,editTitle);
	         pstmt.setString(3,editContent);
	         pstmt.setString(4,String.valueOf(timeNow));
	         
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
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	}
	
	public ArrayList<Notify_Module> LoadNotify() {
		String SQL = "SELECT * FROM notify_tb ORDER BY notify_time DESC";
		Notify_Module noti_module;
		ArrayList<Notify_Module> notiArray = new ArrayList<Notify_Module>();
		
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				noti_module = new Notify_Module();
				noti_module.setNum(String.valueOf(rs.getInt(1)));
				noti_module.setTitle(rs.getString(2));
				noti_module.setContent(rs.getString(3));
				noti_module.setTime(rs.getString(4));
				notiArray.add(noti_module);			
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return notiArray;
	}
}
