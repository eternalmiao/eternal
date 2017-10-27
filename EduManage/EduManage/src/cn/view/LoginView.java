package cn.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.bean.Root;
import cn.bean.Student;
import cn.bean.Teacher;
import cn.biz.RootBiz;
import cn.biz.StudentBiz;
import cn.biz.TeacherBiz;
import cn.biz.impl.RootBizImpl;
import cn.biz.impl.StudentBizImpl;
import cn.biz.impl.TeacherBizImpl;

public class LoginView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;// 容器面板
	private JTextField account;// 账户输入框
	private Image image = null;// 背景图片
	private ImageIcon icon = new ImageIcon("photos\\001.png");
	private JRadioButton r1;// 学生
	private JRadioButton r2;// 教师
	private JRadioButton r3;// 管理员
	private JPasswordField password;// 密码输入框
	private JButton button;// 登陆按钮
	private JButton button_1;// 重置按钮
	private StudentBiz stuBiz;
	private TeacherBiz teaBiz;
	private RootBiz rootBiz;

	public LoginView() throws HeadlessException {
		super();
		stuBiz = new StudentBizImpl();
		teaBiz = new TeacherBizImpl();
		rootBiz = new RootBizImpl();
		// 初始化界面
		initFrame();
		// 初始化监听
		initListener();

	}

	/**
	 * 初始化界面
	 * 
	 * @return
	 */
	public void initFrame() {
		setTitle("登录");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ButtonGroup group = new ButtonGroup();

		Panel panel = new Panel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(237, 50, 241, 196);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("密    码:");
		label_1.setBounds(10, 84, 50, 23);
		panel.add(label_1);

		JLabel label = new JLabel("用户名:");
		label.setBounds(10, 55, 50, 23);
		panel.add(label);

		account = new JTextField();
		account.setBounds(66, 57, 124, 21);
		panel.add(account);
		account.setColumns(10);

		password = new JPasswordField();
		password.setBounds(66, 84, 124, 21);
		panel.add(password);

		r1 = new JRadioButton("学生");
		r1.setSelected(true);
		r1.setBounds(10, 113, 65, 23);
		panel.add(r1);
		group.add(r1);

		r2 = new JRadioButton("教师");
		r2.setBounds(77, 113, 62, 23);
		panel.add(r2);
		group.add(r2);

		r3 = new JRadioButton("管理员");
		r3.setBounds(141, 113, 76, 23);
		panel.add(r3);
		group.add(r3);

		button = new JButton("登录");

		button.setBounds(10, 142, 76, 23);
		panel.add(button);

		button_1 = new JButton("重置");
		button_1.setBounds(105, 142, 76, 23);
		panel.add(button_1);

		JLabel label_2 = new JLabel("     Login");
		label_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		label_2.setForeground(new Color(51, 0, 255));
		label_2.setBounds(10, 10, 184, 39);
		panel.add(label_2);

	}

	private void initListener() {
		// 登录按钮监听
		button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				if (account.getText().equals("")) {
					JOptionPane.showMessageDialog(LoginView.this, "用户名不能为空!");
					return;
				} else if (password.getText().equals("")) {
					JOptionPane.showMessageDialog(LoginView.this, "密码不能为空!");
					return;
				}
				String name = account.getText();
				
				String psw = password.getText();
				// 登陆操作
				if (r1.isSelected()) {
					//学生
					int id = Integer.parseInt(name);
					Student stu = stuBiz.login(id, psw);
					if (stu == null) {
						JOptionPane.showMessageDialog(LoginView.this,
								"账户名或者密码错误！");
					} else {
						dispose();
						StudentView stuView = new StudentView(stu);
						stuView.setVisible(true);

					}

				} else if (r2.isSelected()) {
					//教师
					int id = Integer.parseInt(name);
					Teacher tea = teaBiz.login(id, psw);
					if (tea == null) {
						JOptionPane.showMessageDialog(LoginView.this,
								"账户名或者密码错误！");
					}else {
						dispose();
						TeacherView teaView = new TeacherView(tea);
						teaView.setVisible(true);
					}

				} else if (r3.isSelected()) {
					//管理员登录
					Root root = rootBiz.login(name, psw);
					if (root == null) {
						JOptionPane.showMessageDialog(LoginView.this,
								"账户名或者密码错误！");
					}else {
						dispose();
						ManagerView managerView = new ManagerView(root);
						managerView.setVisible(true);
						
					}
				}
			}
		});
		// 重置按钮监听
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				account.setText("");
				password.setText("");
			}
		});

	}

	public void paint(Graphics g) {
		super.paint(g);
		image = icon.getImage();
		g.drawImage(image, 0, 0, null);
	}
}
