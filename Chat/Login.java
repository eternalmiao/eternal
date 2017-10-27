import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends Frame {//登陆界面
	Panel panel = new Panel();
	Label label = new Label("用户名：");
	TextField name = new TextField(10);
	Button button = new Button("登陆");
	
	public static void main(String[] args) {//主函数
		new Login().launchFrame();
	}
	
	public void launchFrame() {
		setLocation(500, 300);
		setTitle("Login");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(label);
		panel.add(name);
		panel.add(button);
		add(panel);
		pack();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		button.addActionListener(new ButtonListener());
		setResizable(false);
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ChatClient cc = new ChatClient();//聊天界面
			cc.launchFrame();
			cc.Login(name.getText());
			setVisible(false);
		}
	}
	
}
