package cn.view;

import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.bean.Root;
import cn.biz.RootBiz;
import cn.biz.impl.RootBizImpl;

public class ManagerChangePswView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4483675755475820316L;
	private JPanel contentPane;
	private JTextField account;
	private JPasswordField oldpassword;
	private JPasswordField newpassword;
	private JPasswordField surepassword;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private RootBiz rootbiz;
	private Root root;

	public ManagerChangePswView(Root root) throws HeadlessException {
		super();
		this.root = root;
		rootbiz = new RootBizImpl();
		initView();
		initListener();
	}

	/**
	 * 初始化view
	 */
	public void initView() {
		setTitle("修改密码");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 383, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("请输入以下内容：");
		lblNewLabel.setBounds(95, 0, 200, 50);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("帐号：");
		lblNewLabel_1.setBounds(30, 39, 55, 38);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("旧密码：");
		lblNewLabel_2.setBounds(30, 87, 55, 38);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("新密码：");
		lblNewLabel_3.setBounds(30, 121, 200, 50);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("确认密码：");
		lblNewLabel_4.setBounds(30, 160, 65, 50);
		contentPane.add(lblNewLabel_4);

		account = new JTextField();
		account.setEditable(false);
		account.setBounds(105, 48, 206, 21);

		account.setText(root.getName());

		contentPane.add(account);
		account.setColumns(10);

		btnNewButton = new JButton("确定");

		btnNewButton.setBounds(50, 229, 93, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(218, 229, 93, 23);
		contentPane.add(btnNewButton_1);

		oldpassword = new JPasswordField();
		oldpassword.setBounds(105, 96, 206, 21);
		contentPane.add(oldpassword);

		newpassword = new JPasswordField();
		newpassword.setBounds(105, 136, 206, 21);
		contentPane.add(newpassword);

		surepassword = new JPasswordField();
		surepassword.setBounds(105, 181, 206, 21);
		contentPane.add(surepassword);
	}

	private void initListener() {
		// 确认按钮监听
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String old = new String(oldpassword.getPassword());
				String newp = new String(newpassword.getPassword());
				String sure = new String(surepassword.getPassword());
				if (old.equals("")) {
					JOptionPane.showMessageDialog(ManagerChangePswView.this,
							"旧密码不能为空!");
				} else if (!old.equals(root.getPassword())) {
					JOptionPane
							.showMessageDialog(ManagerChangePswView.this, "旧密码不正确!");
				} else if (newp.equals("")) {
					JOptionPane.showMessageDialog(ManagerChangePswView.this,
							"新密码不能为空!");
				} else if (sure.equals("")) {
					JOptionPane.showMessageDialog(ManagerChangePswView.this,
							"确认密码不能为空!");
				} else if (!sure.equals(newp)) {
					JOptionPane.showMessageDialog(ManagerChangePswView.this, "密码不一致!");
				} else {

					// 学生修改
					root.setPassword(newp);
					if (rootbiz.changePsw(root)) {
						JOptionPane.showMessageDialog(ManagerChangePswView.this,
								"修改成功!");
						dispose();
					} else {
						JOptionPane.showMessageDialog(ManagerChangePswView.this,
								"修改失败!");
					}

				}
			}
		});
		// 取消
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

	}
}
