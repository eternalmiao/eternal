import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;



public class ChatClient extends Frame {
	DatagramSocket DS = null;	//接收群聊信息的套接字
	MulticastSocket McS = null;	//多播套接字
	InetAddress iaddress = null;//多播套接字
	int mPort = 2333;//多播端口
	int uPort = 6666;//接收群聊信息的端口
	String ServerIP = "127.0.0.1";//服务器地址
	Choice choice = new Choice();
	Label label = new Label();
	TextField tfTxt = new TextField(65);	//编辑窗口
	TextArea taContent = new TextArea(20,80);//显示窗口
	Button bSend = new Button("发送");
	Panel panel = new Panel();
	Thread tRecv =  new Thread(new RecvThread());//接收线程
	PrivateChat pchat = new PrivateChat();//私聊界面

	public void launchFrame() {//加载群聊界面
		setLocation(300, 100);
		setTitle("WeChat");
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		choice.add("群聊");
		choice.add("私聊");
		panel.add(choice);
		panel.add(tfTxt);
		panel.add(bSend);
		add(label,BorderLayout.NORTH);
		add(taContent, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		taContent.setEditable(false);
		pack();
		pchat.launchFrame();//私聊窗口
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		tfTxt.addActionListener(new TFListener());
		bSend.addActionListener(new TFListener());
		choice.addItemListener(new ChoiceListener());
		setResizable(false);
		setVisible(true);
        try {
			DS = new DatagramSocket();
			McS = new MulticastSocket(mPort);
			iaddress = InetAddress.getByName("224.255.10.0");
			McS.joinGroup(iaddress);//将多播套接字加入多播组
		} catch (SocketException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		tRecv.start();//启动接收线程
		
	}
	
	public void Login(String name) {//登陆
    	try {
    		label.setText("IP：" + InetAddress.getLocalHost().getHostAddress() + "      用户名：" + name);
    		byte[] buf = name.getBytes();
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(ServerIP), uPort);
			DS.send(dp);//将用户名发给服务器登记新用户
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	private class TFListener implements ActionListener {//监听是否发送信息到服务器

		public void actionPerformed(ActionEvent e) {
			DatagramPacket dp = null;
        	byte []buf = tfTxt.getText().getBytes();
        	try {
				dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(ServerIP), uPort);
				DS.send(dp);//发送信息到服务器的群聊端口
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
        	tfTxt.setText("");			
		}
		
	}
	
	private class ChoiceListener implements ItemListener {//监听是否选择私聊

		public void itemStateChanged(ItemEvent e) {
			if(choice.getSelectedItem().equals("私聊")) { 
				choice.remove("私聊");
				new Thread(new isClosedThread()).start();
			}
		}
		
	}
	
	private class isClosedThread implements Runnable {//监听私聊窗口是否已关闭

		public void run() {
			pchat.setVisible(true);
			
			while(pchat.isVisible()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			choice.add("私聊");
		}
		
	}
	
	private class RecvThread implements Runnable {//监听接收线程
		
		public void run() {
	        try {
		        byte[] buf=new byte[1024];
		        
				while(true) {
	                DatagramPacket dp=new DatagramPacket(buf,buf.length);
	                McS.receive(dp);
	                String data = new String(buf,0,dp.getLength());
	                taContent.append(data);//将信息添加到taContent上已存在信息的末尾
	                taContent.append("\n\n");
				}
				
	        } catch (SocketException e1) {
	            e1.printStackTrace();
            }catch(Exception e)	{
                e.printStackTrace();
            }

		}
		
	}
		
}
