import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;






public class PrivateChat extends Frame {
	DatagramSocket DS = null;//接收和转发私聊信息的套接字
	int uPort = 8888;//接收私聊信息的端口
	String ServerIP = "127.0.0.1";//服务器地址
	TextField tfTxt1 = new TextField(6);	//私聊对象用户名输入框
	TextField tfTxt2 = new TextField(35);	//编辑窗口
	Label label1 = new Label("对");
	Label label2 = new Label("说");
	TextArea taContent = new TextArea(15,60);//显示窗口
	Button bSend = new Button("发送");
	Panel panel = new Panel();
	Thread tRecv =  new Thread(new RecvThread());  	//接收线程
	
	public void launchFrame() {//加载私聊界面
		setLocation(700, 300);
		setTitle("Private Chat");
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(label1);
		panel.add(tfTxt1);
		panel.add(label2);
		panel.add(tfTxt2);
		panel.add(bSend);
		add(taContent, BorderLayout.NORTH);
		add(panel, BorderLayout.SOUTH);
		taContent.setEditable(false);
		pack();
		tfTxt2.addActionListener(new TFListener());
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				tfTxt1.setText("");
				tfTxt2.setText("");
				taContent.setText("");
				setVisible(false);
			}
			
		});
		setResizable(false);
		setVisible(false);
		try {
			DS = new DatagramSocket(uPort);
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		tRecv.start();//启动接收线程
		
	}
	
	private class TFListener implements ActionListener {//监听是否发送信息
		
		public void actionPerformed(ActionEvent e) {
			String msg = tfTxt1.getText() + "@@" + tfTxt2.getText();//私聊信息模式为“私聊对象名@@信息”			
        	byte[] buf = msg.getBytes();
        	try {
        		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(ServerIP), uPort);
				DS.send(dp);
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
        	tfTxt2.setText("");			
		}
		
	}

	private class RecvThread implements Runnable {//接收线程
		
		public void run() {
	        try {   
		        byte[] buf=new byte[1024];		        
				while(true) {
	                DatagramPacket dp=new DatagramPacket(buf,buf.length);
	                DS.receive(dp);
	                String data = new String(buf,0,dp.getLength());
	                taContent.append(data);
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