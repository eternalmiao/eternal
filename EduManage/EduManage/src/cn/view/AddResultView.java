package cn.view;

import java.awt.Font;
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

import cn.bean.Result;
import cn.bean.Student;
import cn.bean.Subject;
import cn.bean.Teacher;
import cn.dao.ResultDao;
import cn.dao.SubjectDao;
import cn.dao.TeacherDao;
import cn.dao.impl.ResultDaoImpl;
import cn.dao.impl.SubjectDaoImpl;
import cn.dao.impl.TeacherDaoImpl;

public class AddResultView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3949004849167835118L;
	private JPanel contentPane;
	private JTextField stuId;
	private JTextField result;
	private JTextField testtime;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private SubjectDao subDao;
	private JComboBox<Object> subox2;
	private JComboBox<Object> teabox;
	private List<Subject> subjectList;
	private ResultDao resDao;
	private TeacherDao teaDao;
	private List<Teacher> teaList;

	public AddResultView() throws HeadlessException {
		super();
		subDao = new SubjectDaoImpl();
		resDao = new ResultDaoImpl();
		teaDao = new TeacherDaoImpl();
		initView();
		initListener();
	}

	/**
	 * Create the frame.
	 */
	public void initView() {
		// 科目信息
		subjectList = subDao.findAllSubject();

		String[] subs = new String[subjectList.size()];

		for (int k = 0; k < subjectList.size(); k++) {
			subs[k] = subjectList.get(k).getName();
		}

		teaList = teaDao.findAllTeacher();
		String[] teas = new String[teaList.size()];
		for (int i = 0; i < teaList.size(); i++) {
			teas[i] = teaList.get(i).getName();
		}

		setTitle("添加学生成绩");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 402, 300);
		contentPane = new JPanel();
		// contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("请输入以下内容：");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 15));
		lblNewLabel.setBounds(119, 10, 172, 22);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("学号：");
		lblNewLabel_1.setBounds(54, 90, 54, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("科目：");
		lblNewLabel_2.setBounds(54, 59, 54, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("授课老师：");
		lblNewLabel_3.setBounds(25, 121, 79, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("分数：");
		lblNewLabel_4.setBounds(54, 152, 54, 15);
		contentPane.add(lblNewLabel_4);

		JLabel label5 = new JLabel("考试时间：");
		label5.setBounds(40, 183, 79, 15);
		contentPane.add(label5);

		stuId = new JTextField();
		stuId.setBounds(143, 87, 163, 21);
		contentPane.add(stuId);
		stuId.setColumns(10);

		// subId = new JTextField();
		// subId.setBounds(143, 56, 163, 21);
		// contentPane.add(subId);
		// subId.setColumns(10);
		subox2 = new JComboBox<Object>();
		subox2.setBounds(143, 56, 163, 21);
		subox2.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
				subs));
		contentPane.add(subox2);

		// teaId = new JTextField();
		// teaId.setBounds(143, 118, 163, 21);
		// contentPane.add(teaId);
		// teaId.setColumns(10);

		teabox = new JComboBox<Object>();
		teabox.setBounds(143, 118, 163, 21);
		teabox.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
				teas));
		contentPane.add(teabox);

		result = new JTextField();
		result.setBounds(143, 149, 163, 21);
		contentPane.add(result);
		result.setColumns(10);

		testtime = new JTextField();
		testtime.setBounds(143, 180, 163, 21);
		contentPane.add(testtime);
		testtime.setColumns(10);

		btnNewButton = new JButton("确认");

		btnNewButton.setBounds(65, 239, 93, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("取消");

		btnNewButton_1.setBounds(213, 239, 93, 23);
		contentPane.add(btnNewButton_1);

	}

	private void initListener() {
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (stuId.getText().equals("")) {
					JOptionPane
							.showMessageDialog(AddResultView.this, "学号不能为空!");
				} else if (result.getText().equals("")) {
					JOptionPane
							.showMessageDialog(AddResultView.this, "分数不能为空!");
				} else if (testtime.getText().equals("")) {
					JOptionPane.showMessageDialog(AddResultView.this,
							"考试时间不能为空!");
				} else {
					Result res = new Result();
					Student stu = new Student();
					stu.setId(Integer.parseInt(stuId.getText()));
					res.setStu(stu);
					Teacher tea = teaList.get(teabox.getSelectedIndex());
					res.setTea(tea);
					Subject sub = subjectList.get(subox2.getSelectedIndex());
					res.setSub(sub);
					double score = Double.parseDouble(result.getText());
					res.setScore(score);
					String time = testtime.getText();
					res.setTime(time);
					if (resDao.checkResult(stu.getId(), sub.getId()) != null) {
						JOptionPane.showMessageDialog(AddResultView.this,
								"成绩已存在不可重复添加");
						return;
					}
					if (resDao.addResult(res)) {
						JOptionPane.showMessageDialog(AddResultView.this,
								"添加成功");
					} else {
						JOptionPane.showMessageDialog(AddResultView.this,
								"添加失败！");
					}

				}
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

	}
}
