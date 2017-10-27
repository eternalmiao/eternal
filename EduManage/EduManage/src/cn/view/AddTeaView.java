package cn.view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.bean.Teacher;
import cn.dao.TeacherDao;
import cn.dao.impl.TeacherDaoImpl;

public class AddTeaView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField address;
	private TeacherDao teaDao;
	public AddTeaView() throws HeadlessException {
		super();
		teaDao = new TeacherDaoImpl();
		init();
	}


	public void init()
	{
		setTitle("添加教师信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 291, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JLabel label = new JLabel("教工号：");
//		label.setBounds(77, 47, 63, 23);
//		contentPane.add(label);
		
		JLabel label_1 = new JLabel("姓名：");
		label_1.setBounds(77, 87, 53, 23);
		contentPane.add(label_1);
		
		JLabel label_5 = new JLabel("电话：");
		label_5.setBounds(77, 132, 53, 23);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("家庭地址：");
		label_6.setBounds(71, 175, 69, 23);
		contentPane.add(label_6);
		
//		id = new JTextField();
//		id.setEditable(false);
//		id.setBounds(146, 49, 66, 21);
//		contentPane.add(id);
//		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(146, 89, 66, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(146, 134, 66, 21);
		contentPane.add(phone);
		phone.setColumns(10);
		
		address = new JTextField();
		address.setBounds(146, 177, 66, 21);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel label_8 = new JLabel("请填满以下添加内容：");
		label_8.setBounds(77, 10, 142, 23);
		contentPane.add(label_8);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(name.getText().equals(""))
				{
					JOptionPane.showMessageDialog(AddTeaView.this, "名字不能为空!");
				}
				else if(phone.getText().equals(""))
				{
					JOptionPane.showMessageDialog(AddTeaView.this, "电话不能为空!");
				}
				else if(address.getText().equals(""))
				{
					JOptionPane.showMessageDialog(AddTeaView.this, "地址不能为空!");
				}
				else 
				{
					//教工号自增
					//添加修改方法
					String teaname = name.getText();
					String teaphone = phone.getText();
					String teaaddress =  address.getText();
					Teacher tea = new Teacher();
					tea.setName(teaname);
					tea.setPhone(teaphone);
					tea.setAddress(teaaddress);
					tea.setPassword("000000");
					if(teaDao.addTeacher(tea)){
						JOptionPane.showMessageDialog(AddTeaView.this, "添加成功!");
						dispose();
					}else {
						JOptionPane.showMessageDialog(AddTeaView.this, "添加失败!");
					}
				}
				
			}
		});
		btnNewButton.setBounds(33, 229, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(146, 229, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
