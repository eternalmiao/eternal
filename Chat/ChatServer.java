import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
	DatagramSocket DS1 = null;	//����Ⱥ����Ϣ���׽���
	DatagramSocket DS2 = null;	//���պ�ת��˽����Ϣ���׽���
	MulticastSocket McS = null;	//�ಥ�׽���
	InetAddress iaddress = null;//�ಥ��ַ��D���ַ��
	int mPort = 2333;	//�ಥ�˿�
	int uPort1 = 6666;	//����Ⱥ����Ϣ�Ķ˿�
	int uPort2 = 8888;	//����˽����Ϣ�Ķ˿�
	
	Vector<Client> clients = new Vector<Client>();//�û�����
	
	public static void main(String[] args) {//������
		new ChatServer().start();
	}
	
	public void start() {//����
			try {
				DS1 = new DatagramSocket(uPort1);
				McS = new MulticastSocket();
				iaddress = InetAddress.getByName("224.255.10.0");
				McS.joinGroup(iaddress); //���ಥ�׽��ּ���ಥ��				
			} catch (SocketException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Thread(new Unicast()).start();//����˽���߳�
			
			while(true) {
				boolean nc = true;
			    byte[] buf= new byte[1024];
		    	DatagramPacket dp = new DatagramPacket(buf,buf.length);
		    	
				try {
					DS1.receive(dp);
				} catch (IOException e) {
					e.printStackTrace();
				}//����Ⱥ����Ϣ
				
				String name = null;
				String ip = dp.getAddress().getHostAddress();
				for(int i=0; i<clients.size(); i++) {//�����Ƿ������û�
					Client c = clients.get(i);
					if(c.getIP().equals(ip)) {//���û�
						nc = false;
						name = c.getName();
						break;
					}					
				}
				
                if(nc == true) {//���û�
                	name = new String(buf, 0, dp.getLength()).trim();
                	Client c = new Client(ip, name);
					clients.add(c);
System.out.println("���û�:" + name);
					continue;//��������Ϣ
                } 
                
                new Thread(new Multicast(dp, name)).start();//�ಥ�߳�
                
			}


	}

	class Client {//�û���
		String IP;//�û�IP
		String name;//�û���
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
	
		
	class Multicast implements Runnable {//�ಥ�߳�
		DatagramPacket dp = null;
		String name = null;
		Multicast(DatagramPacket dp, String name) {
			this.dp = dp;
			this.name = name;
		}
		
		public void run() {        
							
	        try {
				String data = new String(dp.getData(),"GB2312");//��������
		        String msg ="<" + name + ">" + " ��������˵ : " + "\n  " + data;
		        byte buf[] = msg.getBytes(); 
				dp = new DatagramPacket(buf, buf.length, iaddress, mPort);
				McS.send(dp);//����Ϣ�����ಥ���Ա
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
	}	
	
	class Unicast implements Runnable {//˽���߳�

		public void run() {
	        try {
	            DS2 = new DatagramSocket(uPort2);//˽���׽���
	        } catch (SocketException e1) {
	            e1.printStackTrace();
	        }
	        
	        while(true){
	    			String Sip = null;//Դ��ַ
	    			String Dip = null;//Ŀ�ĵ�ַ
	    			String Sname = null;//Դ�û���
	    			String Dname = null;//Ŀ���û���
	    			byte[] buf=new byte[1024];
	        		boolean exit = false;//�Ƿ���ڴ��û�
	                DatagramPacket dp=new DatagramPacket(buf,buf.length);
	                try {
						DS2.receive(dp);
					} catch (IOException e) {
						e.printStackTrace();
					}
	                String data = new String(buf,0,dp.getLength());
	                Sip = dp.getAddress().getHostAddress();	                
	                String[] str = data.split("@@");//��@@��ǰΪĿ���û�������Ϊ������Ϣ
	                Dname = str[0].trim();	 
					for(int i=0; i<clients.size(); i++) {	
						Client c = clients.get(i);
						if(c.getName().equals(Dname)) {
							Dip = c.getIP();
							exit = true;//���ڴ��û�
						}
						if(c.getIP().equals(Sip)) {
							Sname = c.getName();
						}
					}
					
					if(exit) {//˽�Ķ�����ڲŷ���Ϣ
						String msg = "<" + Sname + ">" +" ��  " + "<" + Dname + ">" + " ˵��" + "\r\n" + str[1].trim();
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