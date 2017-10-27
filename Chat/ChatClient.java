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
	DatagramSocket DS = null;	//����Ⱥ����Ϣ���׽���
	MulticastSocket McS = null;	//�ಥ�׽���
	InetAddress iaddress = null;//�ಥ�׽���
	int mPort = 2333;//�ಥ�˿�
	int uPort = 6666;//����Ⱥ����Ϣ�Ķ˿�
	String ServerIP = "127.0.0.1";//��������ַ
	Choice choice = new Choice();
	Label label = new Label();
	TextField tfTxt = new TextField(65);	//�༭����
	TextArea taContent = new TextArea(20,80);//��ʾ����
	Button bSend = new Button("����");
	Panel panel = new Panel();
	Thread tRecv =  new Thread(new RecvThread());//�����߳�
	PrivateChat pchat = new PrivateChat();//˽�Ľ���

	public void launchFrame() {//����Ⱥ�Ľ���
		setLocation(300, 100);
		setTitle("WeChat");
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		choice.add("Ⱥ��");
		choice.add("˽��");
		panel.add(choice);
		panel.add(tfTxt);
		panel.add(bSend);
		add(label,BorderLayout.NORTH);
		add(taContent, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		taContent.setEditable(false);
		pack();
		pchat.launchFrame();//˽�Ĵ���
		
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
			McS.joinGroup(iaddress);//���ಥ�׽��ּ���ಥ��
		} catch (SocketException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		tRecv.start();//���������߳�
		
	}
	
	public void Login(String name) {//��½
    	try {
    		label.setText("IP��" + InetAddress.getLocalHost().getHostAddress() + "      �û�����" + name);
    		byte[] buf = name.getBytes();
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(ServerIP), uPort);
			DS.send(dp);//���û��������������Ǽ����û�
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	private class TFListener implements ActionListener {//�����Ƿ�����Ϣ��������

		public void actionPerformed(ActionEvent e) {
			DatagramPacket dp = null;
        	byte []buf = tfTxt.getText().getBytes();
        	try {
				dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(ServerIP), uPort);
				DS.send(dp);//������Ϣ����������Ⱥ�Ķ˿�
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
        	tfTxt.setText("");			
		}
		
	}
	
	private class ChoiceListener implements ItemListener {//�����Ƿ�ѡ��˽��

		public void itemStateChanged(ItemEvent e) {
			if(choice.getSelectedItem().equals("˽��")) { 
				choice.remove("˽��");
				new Thread(new isClosedThread()).start();
			}
		}
		
	}
	
	private class isClosedThread implements Runnable {//����˽�Ĵ����Ƿ��ѹر�

		public void run() {
			pchat.setVisible(true);
			
			while(pchat.isVisible()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			choice.add("˽��");
		}
		
	}
	
	private class RecvThread implements Runnable {//���������߳�
		
		public void run() {
	        try {
		        byte[] buf=new byte[1024];
		        
				while(true) {
	                DatagramPacket dp=new DatagramPacket(buf,buf.length);
	                McS.receive(dp);
	                String data = new String(buf,0,dp.getLength());
	                taContent.append(data);//����Ϣ��ӵ�taContent���Ѵ�����Ϣ��ĩβ
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
