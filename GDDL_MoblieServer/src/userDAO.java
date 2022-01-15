

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userDAO{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public userDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/" + FinalDB.dbProject +"?serverTimezone=Asia/Seoul&useSSL=false";
			String dbID = FinalDB.dbID;
			String dbPassword =FinalDB.dbPassword;
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(dbURL, dbID, dbPassword);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String searchPassword(String userID) {
		String SQL = "SELECT * from user_data where user_id like ?";
		String pass="";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pass=rs.getString(2);
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
		return pass;
	}
	public String CheckID(String inputID) {
		String SQL = "SELECT * from user_data where user_id like ? ";
		String DB_ID="";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, inputID);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DB_ID=rs.getString(1);
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
		return DB_ID;
	}
	public String CheckStudentNumber(String inputNumber) {
		String SQL = "SELECT * from user_data where school_number like ? ";
		String DB_SchoolNumber="";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, inputNumber);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DB_SchoolNumber=rs.getString(5);
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
		return DB_SchoolNumber;
	}
	
	public void RegisterUser(User_Module user) {
		String SQL = "INSERT INTO user_data VALUES (?, ?, ?, ?, ?, ?)";
	      try {
	         pstmt = conn.prepareStatement(SQL);
	         pstmt.setString(1,user.getUserId());
	         pstmt.setString(2,user.getUserPass());
	         pstmt.setString(3,user.getUserName());
	         pstmt.setString(4,user.getUserMajor());
	         pstmt.setString(5,user.getUserSchoolNumber());
	         pstmt.setString(6,user.getUserGender());
	         
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
	
	public void ChangePass(String IdentificationID,String AfterPass) {
		String SQL = "UPDATE user_data SET pass=? where user_id=\"" + IdentificationID + "\"";
	      try {
	         pstmt = conn.prepareStatement(SQL);
	         pstmt.setString(1, AfterPass);
	         
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
	public User_Module LoadUserInfo(String inputID) {
		User_Module userInfo = new User_Module();
		String SQL = "SELECT user_id,name,major,school_number,gender from user_data where user_id like? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, inputID);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userInfo.setUserId(rs.getString(1));
				userInfo.setUserName(rs.getString(2));
				userInfo.setUserMajor(rs.getString(3));
				userInfo.setUserSchoolNumber(rs.getString(4));
				userInfo.setUserGender(rs.getString(5));
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
		return userInfo;
	}
	

	
}
