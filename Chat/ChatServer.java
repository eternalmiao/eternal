import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
	DatagramSocket DS1 = null;	//接收群聊信息的套接字
	DatagramSocket DS2 = null;	//接收和转发私聊信息的套接字
	MulticastSocket McS = null;	//多播套接字
	InetAddress iaddress = null;//多播地址（D类地址）
	int mPort = 2333;	//多播端口
	int uPort1 = 6666;	//接收群聊信息的端口
	int uPort2 = 8888;	//接收私聊信息的端口
	
	Vector<Client> clients = new Vector<Client>();//用户集合
	
	public static void main(String[] args) {//主函数
		new ChatServer().start();
	}
	
	public void start() {//启动
			try {
				DS1 = new DatagramSocket(uPort1);
				McS = new MulticastSocket();
				iaddress = InetAddress.getByName("224.255.10.0");
				McS.joinGroup(iaddress); //将多播套接字加入多播组				
			} catch (SocketException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Thread(new Unicast()).start();//启动私聊线程
			
			while(true) {
				boolean nc = true;
			    byte[] buf= new byte[1024];
		    	DatagramPacket dp = new DatagramPacket(buf,buf.length);
		    	
				try {
					DS1.receive(dp);
				} catch (IOException e) {
					e.printStackTrace();
				}//接收群聊信息
				
				String name = null;
				String ip = dp.getAddress().getHostAddress();
				for(int i=0; i<clients.size(); i++) {//查找是否是新用户
					Client c = clients.get(i);
					if(c.getIP().equals(ip)) {//老用户
						nc = false;
						name = c.getName();
						break;
					}					
				}
				
                if(nc == true) {//新用户
                	name = new String(buf, 0, dp.getLength()).trim();
                	Client c = new Client(ip, name);
					clients.add(c);
System.out.println("新用户:" + name);
					continue;//不发送信息
                } 
                
                new Thread(new Multicast(dp, name)).start();//多播线程
                
			}


	}

	class Client {//用户类
		String IP;//用户IP
		String name;//用户名
		Client(String IP, String name){
			this.IP = IP;
			this.name = name;
		}
		
		public String getIP() {
			return IP;
		}
		
		public String getName() {
			return name;
		}
	}
	
		
	class Multicast implements Runnable {//多播线程
		DatagramPacket dp = null;
		String name = null;
		Multicast(DatagramPacket dp, String name) {
			this.dp = dp;
			this.name = name;
		}
		
		public void run() {        
							
	        try {
				String data = new String(dp.getData(),"GB2312");//编码问题
		        String msg ="<" + name + ">" + " 对所有人说 : " + "\n  " + data;
		        byte buf[] = msg.getBytes(); 
				dp = new DatagramPacket(buf, buf.length, iaddress, mPort);
				McS.send(dp);//将信息发给多播组成员
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
	}	
	
	class Unicast implements Runnable {//私聊线程

		public void run() {
	        try {
	            DS2 = new DatagramSocket(uPort2);//私聊套接字
	        } catch (SocketException e1) {
	            e1.printStackTrace();
	        }
	        
	        while(true){
	    			String Sip = null;//源地址
	    			String Dip = null;//目的地址
	    			String Sname = null;//源用户名
	    			String Dname = null;//目的用户名
	    			byte[] buf=new byte[1024];
	        		boolean exit = false;//是否存在此用户
	                DatagramPacket dp=new DatagramPacket(buf,buf.length);
	                try {
						DS2.receive(dp);
					} catch (IOException e) {
						e.printStackTrace();
					}
	                String data = new String(buf,0,dp.getLength());
	                Sip = dp.getAddress().getHostAddress();	                
	                String[] str = data.split("@@");//“@@”前为目的用户名，后为发送信息
	                Dname = str[0].trim();	 
					for(int i=0; i<clients.size(); i++) {	
						Client c = clients.get(i);
						if(c.getName().equals(Dname)) {
							Dip = c.getIP();
							exit = true;//存在此用户
						}
						if(c.getIP().equals(Sip)) {
							Sname = c.getName();
						}
					}
					
					if(exit) {//私聊对象存在才发信息
						String msg = "<" + Sname + ">" +" 对  " + "<" + Dname + ">" + " 说：" + "\r\n" + str[1].trim();
						buf = msg.getBytes();
						try {
							dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(Sip), uPort2);
							DS2.send(dp);
							dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(Dip), uPort2);
							DS2.send(dp);							
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
	                 
	        }
	        
		}
		
	}
	
	
}