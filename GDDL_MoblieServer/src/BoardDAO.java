

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	Date time = new Date();
	String timeNow = format.format(time);
	
	public BoardDAO() {
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
	
	public void PostOnBoard(Board_Module board_module) {
		String SQL = "INSERT INTO orders_tb VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,null);
			pstmt.setString(2,String.valueOf(timeNow));
			pstmt.setString(3,board_module.getOrders());
			pstmt.setString(4,null);
			pstmt.setString(5,board_module.getTitle());
			pstmt.setString(6,board_module.getText());
			pstmt.setDouble(7,board_module.getLatitude());
			pstmt.setDouble(8,board_module.getLongitude());
			pstmt.setString(9,board_module.getDetail_address());
			pstmt.setInt(10, board_module.getPrice());
			pstmt.setString(11,board_module.getProgress());
			
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
	public ArrayList<Board_Module> LoadBoard() {
		String SQL = "SELECT * FROM orders_tb ORDER BY errand ASC, o_time DESC";
		Board_Module tmp_module;
		ArrayList<Board_Module> OrderOnBoard = new ArrayList<Board_Module>();
		
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				tmp_module = new Board_Module();
				tmp_module.setO_number(rs.getInt(1));
				tmp_module.setO_time(rs.getString(2));
				tmp_module.setOrders(rs.getString(3));
				tmp_module.setErrand(rs.getString(4));
				tmp_module.setTitle(rs.getString(5));
				tmp_module.setText(rs.getString(6));
				tmp_module.setLatitude(rs.getDouble(7));
				tmp_module.setLongitude(rs.getDouble(8));
				tmp_module.setDetail_address(rs.getString(9));
				tmp_module.setPrice(rs.getInt(10));
				tmp_module.setProgress(rs.getString(11));
				OrderOnBoard.add(tmp_module);			
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
		return OrderOnBoard;
	}
	
	public ArrayList<Board_Module> LoadOwnBoard(String inputID) {
		String SQL = "SELECT * FROM orders_tb WHERE orders =\""+inputID+"\" ORDER BY errand ASC, o_time DESC";
		Board_Module tmp_module;
		ArrayList<Board_Module> OrderOnBoard = new ArrayList<Board_Module>();
		
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			System.out.println(inputID);
			
			while(rs.next()) {
				tmp_module = new Board_Module();
				tmp_module.setO_number(rs.getInt(1));
				tmp_module.setO_time(rs.getString(2));
				tmp_module.setOrders(rs.getString(3));
				tmp_module.setErrand(rs.getString(4));
				tmp_module.setTitle(rs.getString(5));
				tmp_module.setText(rs.getString(6));
				tmp_module.setLatitude(rs.getDouble(7));
				tmp_module.setLongitude(rs.getDouble(8));
				tmp_module.setDetail_address(rs.getString(9));
				tmp_module.setPrice(rs.getInt(10));
				tmp_module.setProgress(rs.getString(11));
				OrderOnBoard.add(tmp_module);		
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
		return OrderOnBoard;
	}
	
	public String EditProgress(int inputOrderNum,String ErrandUserID){
        String progress ="";
        String checkProgress = "SELECT * FROM orders_tb WHERE o_number = ?";
        
        try {
           pstmt = conn.prepareStatement(checkProgress);
           pstmt.setInt(1,inputOrderNum);
           rs = pstmt.executeQuery();
           while(rs.next()) {
              progress = rs.getString(11);
           }
        }
        catch(Exception e) {
           e.printStackTrace();
        }  
        //progress가 waiting일때, progress->@@Ongoing, errand = UserID(Errand)
        if(progress.equals("@@Waiting")) {
           String m = "@@Ongoing";
           String update = "UPDATE orders_tb SET progress =\"" + m + "\" WHERE o_number = ?";
           try {
              pstmt = conn.prepareStatement(update);
              pstmt.setInt(1, inputOrderNum);
              pstmt.executeUpdate();

             System.out.println(progress);
              String UpdateErrand = "UPDATE orders_tb SET errand = ? WHERE o_number = ?";
                 try {
                    pstmt = conn.prepareStatement(UpdateErrand);
                    pstmt.setString(1, ErrandUserID);
                    pstmt.setInt(2, inputOrderNum);
                    pstmt.executeUpdate();
                 }
                 catch(Exception e) {
                    e.printStackTrace();
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
           return "@@AcceptOrder";
           
        }
        
        else{
           return "@@AcceptError";
        }
        
     }
  
	//주문번호로 식별 후 취소
	public void CancelOrder(String inputOrderNum){
        String SQL = "DELETE FROM orders_tb WHERE o_number = ?;";
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,Integer.parseInt(inputOrderNum));
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
	
	public void OrderCompleted(int inputOrderNum) {
		String c = "@@Completed";
        String update = "UPDATE orders_tb SET progress =\"" + c + "\" WHERE o_number = ?";
        try {
            pstmt = conn.prepareStatement(update);
            pstmt.setInt(1, inputOrderNum);
            pstmt.executeUpdate();


         } catch(Exception e) {
            e.printStackTrace();
         } finally {
            try {
               pstmt.close();
               conn.close();
            }catch(SQLException e){
               e.printStackTrace();
            }
         }
         
      }
	
	public String GetLocation(String inputID) {
		String progress = "@@Ongoing";
		String query = "SELECT longitude, latitude FROM orders_tb WHERE progress =\"" + progress + "\" AND errand = \"" + inputID + "\"";
		double latitude = 0;
		double longitude = 0;
		String location = "";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				longitude = rs.getDouble(1);
				latitude = rs.getDouble(2);
			}
			location = String.valueOf(longitude) + "@"+String.valueOf(latitude);
			
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
		return location;
	}

	
	
	
	
}
