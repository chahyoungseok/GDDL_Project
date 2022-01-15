import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServerMain extends HttpServlet{
   private ServerSocket server;
   public Accept accept;
   //ä�� ������ ��ü�� ���� arrayList ����
   public HashMap<String ,User> UserMap= new HashMap<String, User>();
   public SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
   public Date time = new Date();
   public ServerModule serverModule;
   public Socket socket;
   public Boolean m_status;
   
   //������
   public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
        	server = new ServerSocket(7777);
        	accept = new Accept();
            accept.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
   public class Accept extends Thread{
      public void run() {
    	  InputQuit quit = new InputQuit();
          quit.start();
          m_status = true;
          while(m_status) {
        	  try {         
                  //����ڰ� �����ϱ���� ����� ������ ���� 
                  System.out.println("Connecting...");
                  socket = server.accept();
                  IDThread thread = new IDThread(socket);
                  thread.start();              
               }catch(Exception e) {
                  e.printStackTrace();
               }
          }
      }
   }
   
   class IDThread extends Thread{
      private Socket socket;
      
      public IDThread(Socket socket) {
         this.socket = socket;
      }
      public void run() {
         try {
            
            //���޹��� ���� ���� input/output Stream ����, ������ ��ȯ �غ� �Ϸ�
            //Ŭ���̾�Ʈ���� ���� ���� �غ�
            System.out.println("IDthread started");
            InputStream input = socket.getInputStream();
            DataInputStream inputData = new DataInputStream(input);
            
            String userID = inputData.readUTF();
            System.out.println(userID);
            
            //������ ������ ���ϰ� ���̵� hashMap����            
            User user = new User(socket);
            UserMap.put(userID, user);
         
            System.out.println(userID+" Connected to Server");
            
            user.start();
         }
         catch(Exception e){
            e.printStackTrace();
         }
      }   
   }
   
   class User extends Thread{
      String sendID;
      String tmp = "����ȣ";
      String receiveID;
      Socket socket;
      Boolean status = true;
      ServerModule serverModule;
      DataInputStream inputData;
      DataOutputStream outputData;
      
      public User(Socket socket) {
         try {   
               this.socket= socket;
               InputStream input = socket.getInputStream();
               OutputStream output = socket.getOutputStream();
               inputData = new DataInputStream(input);
               outputData = new DataOutputStream(output);
            }catch(Exception e){
               e.printStackTrace();
            }
         }
      
         public void run(){
            try {
               while(status) {
                  String timeNow = format.format(time);
                  String response = inputData.readUTF();
                  if(response.equals("/quit")) {
                	  for(String key : UserMap.keySet()) {
                		  if(UserMap.get(key) == this) {
                			  UserMap.remove(key);
                			  System.out.println("���� ����");
                		  }
                	  }
                	  status = false;
                  }
                  else {
                	  String[] splitedMsg = response.split("@");            
                      String sendID = splitedMsg[0];
                      String receiveID = splitedMsg[1];
                      String msg = splitedMsg[2];

                      System.out.println(timeNow +"\n�۽��� : "+ splitedMsg[0] +" \n������ : "+receiveID+" \n�޼������� : "+ msg);
                      SendToClient(sendID,receiveID,msg);
                  }
               }
            }catch(Exception e) {
               e.printStackTrace();
            }
         }
   }
   public synchronized void SendToClient(String sendUser,String receiveUser,String msg) {
      try {
            UserMap.get(sendUser).outputData.writeUTF(sendUser+"@"+msg);
            serverModule = new ServerModule();
            serverModule.setSenderID(sendUser);
            serverModule.setMsg(msg);
            serverModule.setC_time(format.format(time));
            new ChatDAO().MsgToDB(serverModule);
            if(UserMap.get(receiveUser)!=null){
               UserMap.get(receiveUser).outputData.writeUTF(sendUser+"@"+msg);
            }
      
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public class InputQuit extends Thread{
   	String msg = "";
   	Boolean status = true;
   	
   	public void run() {
   		Scanner scan = new Scanner(System.in);
   		
   		msg = scan.nextLine();
		if("/quit".equals(msg)) {
			for(String key : UserMap.keySet()){
                UserMap.get(key).status = false;
                m_status = null;
            }
			UserMap.clear();
			System.out.println("���������� ������ �������׽��ϴ�.");
		}
		else {
			msg = null;
		}
   	}
   }
}
