package cn.view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.bean.Grade;
import cn.bean.Major;
import cn.bean.Student;
import cn.dao.GradeDao;
import cn.dao.MajorDao;
import cn.dao.StudentDao;
import cn.dao.impl.GradeDaoImpl;
import cn.dao.impl.MajorDaoImpl;
import cn.dao.impl.StudentDaoImpl;

public class UpdateStuView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField phone;
	private JTextField address;
	private JTextField dormitory;
	private StudentDao stuDao;
	private MajorDao majorDao;
	private GradeDao gradeDao;
	private JComboBox<Object> gradebox;
	private JComboBox<Object> majbox;
	private JComboBox<Object> classnobox;
	private JButton btnexit;
	private JButton btnok;
	private List<Major> majList;
	private List<Grade> gradeList;
	private Student stu;

	public UpdateStuView(Student stu) throws HeadlessException {
		super();
		stuDao = new StudentDaoImpl();
		majorDao = new MajorDaoImpl();
		gradeDao = new GradeDaoImpl();
		this.stu = stu;
		initView();
		initListener();

	}

	/**
	 * Create the frame.
	 */
	public void initView() {

		// 初始化数据
		majList = majorDao.findAllMajor();
		gradeList = gradeDao.findAllGrade();

		String[] majs = new String[majList.size() + 1];
		String[] grades = new String[gradeList.size() + 1];
		for (int k = 0; k < majList.size(); k++) {
			majs[k] = majList.get(k).getName();
		}
		for (int l = 0; l < gradeList.size(); l++) {
			grades[l] = gradeList.get(l).getName();
		}

		setTitle("添加学生信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 468, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_2 = new JLabel("专业：");
		label_2.setBounds(248, 89, 41, 23);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("年级：");
		label_3.setBounds(248, 132, 35, 23);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("班级：");
		label_4.setBounds(248, 177, 35, 23);
		contentPane.add(label_4);

		majbox = new JComboBox<Object>();
		majbox.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
				majs));
		majbox.setBounds(317, 89, 63, 21);
		majbox.setSelectedItem(stu.getMajor().getName());;
		contentPane.add(majbox);

		gradebox = new JComboBox<Object>();
		gradebox.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
				grades));
		gradebox.setSelectedItem(stu.getGrade().getName());
		gradebox.setBounds(317, 134, 63, 21);
		contentPane.add(gradebox);
		classnobox = new JComboBox<Object>();
		classnobox
				.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
		classnobox.setBounds(317, 177, 63, 21);
		classnobox.setSelectedIndex(stu.getClassno()-1);
		contentPane.add(classnobox);

		JLabel label = new JLabel("学号：");
		label.setBounds(77, 47, 63, 23);
		contentPane.add(label);

		JLabel label_1 = new JLabel("姓名：");
		label_1.setBounds(77, 87, 53, 23);
		contentPane.add(label_1);

		JLabel label_5 = new JLabel("电话：");
		label_5.setBounds(77, 132, 53, 23);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("家庭地址：");
		label_6.setBounds(71, 175, 69, 23);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("宿舍号：");
		label_7.setBounds(248, 47, 53, 23);
		contentPane.add(label_7);

		id = new JTextField();
		id.setEditable(false);
		id.setBounds(146, 49, 66, 21);
		id.setText(stu.getId()+"");
		contentPane.add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setBounds(146, 89, 66, 21);
		contentPane.add(name);
		name.setText(stu.getName());
		name.setColumns(10);

		phone = new JTextField();
		phone.setBounds(146, 134, 66, 21);
		contentPane.add(phone);
		phone.setText(stu.getPhone());
		phone.setColumns(10);

		address = new JTextField();
		address.setBounds(146, 177, 66, 21);
		contentPane.add(address);
		address.setText(stu.getAddress());
		address.setColumns(10);

		dormitory = new JTextField();
		dormitory.setBounds(314, 49, 66, 21);
		contentPane.add(dormitory);
		dormitory.setText(stu.getDormiting());
		dormitory.setColumns(10);

		JLabel label_8 = new JLabel("请填满以下添加内容：");
		label_8.setBounds(147, 10, 188, 23);
		contentPane.add(label_8);

		btnok = new JButton("确定");

		btnok.setBounds(77, 229, 93, 23);
		contentPane.add(btnok);

		btnexit = new JButton("取消");

		btnexit.setBounds(259, 229, 93, 23);
		contentPane.add(btnexit);
	}

	private void initListener() {
		btnok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (name.getText().equals("")) {
					JOptionPane.showMessageDialog(UpdateStuView.this, "名字不能为空!");
				} else if (phone.getText().equals("")) {
					JOptionPane.showMessageDialog(UpdateStuView.this, "电话不能为空!");
				} else if (address.getText().equals("")) {
					JOptionPane.showMessageDialog(UpdateStuView.this, "地址不能为空!");
				} else if (dormitory.getText().equals("")) {
					JOptionPane.showMessageDialog(UpdateStuView.this, "宿舍号不能为空!");
				} else {
					// 学号自增长，不可改
					// 添加修改方法
					// "学号", "名字", "电话", "家庭地址", "宿舍号", "专业",
					// "年级", "班级"
					String stuname = name.getText();
					String stuphone = phone.getText();
					String stuaddress = address.getText();
					String studormitory = dormitory.getText();
					int classno = classnobox.getSelectedIndex() + 1;
					Grade grade = gradeList.get(gradebox.getSelectedIndex());
					Major major = majList.get(majbox.getSelectedIndex());
					String psw = stu.getPassword();
					int stuid = stu.getId();
					Student stu = new Student(stuid, stuname, stuphone, psw, stuaddress, studormitory, major, grade, classno);
					if(stuDao.updateStudent(stu)){
						JOptionPane.showMessageDialog(UpdateStuView.this,
								"修改成功!");
						dispose();
					}else {
						JOptionPane.showMessageDialog(UpdateStuView.this,
								"修改失败!");
					}
				}

			}
		});

		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
}
