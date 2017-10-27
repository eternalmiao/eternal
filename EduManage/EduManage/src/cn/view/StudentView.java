package cn.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.bean.Course;
import cn.bean.Result;
import cn.bean.Student;
import cn.biz.StudentBiz;
import cn.biz.impl.StudentBizImpl;

public class StudentView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 340332722585123218L;
	private JPanel contentPane;
	private ImageIcon icon = new ImageIcon("photos\\003.png");
	private String now = "通知公告";
	private JTable table;
	private JPanel panel;
	private JTextArea callBoard;
	private JLabel label_1;
	private JLabel location;
	private JPanel change;
	private JTextField id;
	private JTextField name;
	private JTextField phone;
	private JTextField address;
	private JTextField dormiting;
	private JTextField major;
	private JTextField grade;
	private JTextField classno;
	private final StudentBiz stuBiz;
	private Student stu;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_5;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenu mnNewMenu_6;
	private JMenu mnNewMenu_7;

	public StudentView(Student stu) throws HeadlessException {
		super();
		stuBiz = new StudentBizImpl();
		this.stu = stu;
		initView();
		initListner();
	}

	/**
	 * Create the frame.
	 */
	public void initView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel(icon);
		label.setBounds(5, 5, 835, 56);
		contentPane.add(label);

		panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(5, 59, 835, 396);
		contentPane.add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 204, 255));
		menuBar.setBounds(0, 0, 835, 21);
		panel.add(menuBar);

		mnNewMenu = new JMenu("主页");

		menuBar.add(mnNewMenu);

		mnNewMenu_2 = new JMenu("教学质量评价");

		menuBar.add(mnNewMenu_2);

		JMenu mnNewMenu_1 = new JMenu("信息维护");
		menuBar.add(mnNewMenu_1);

		mnNewMenu_4 = new JMenu("个人信息");

		mnNewMenu_1.add(mnNewMenu_4);

		mnNewMenu_5 = new JMenu("修改密码");

		mnNewMenu_1.add(mnNewMenu_5);

		mnNewMenu_3 = new JMenu("查看成绩");

		menuBar.add(mnNewMenu_3);

		mnNewMenu_6 = new JMenu("查看课程表");

		menuBar.add(mnNewMenu_6);

		mnNewMenu_7 = new JMenu("退出登录");

		menuBar.add(mnNewMenu_7);

		change = new JPanel();
		change.setBounds(0, 21, 835, 375);
		panel.add(change);
		change.setLayout(null);

		NowLocat();
		final String notice = stuBiz.lookNotice();
		callBoard = new JTextArea();
		callBoard.setBounds(0, 26, 835, 349);
		change.add(callBoard);
		callBoard.setEditable(false);
		callBoard.setText(notice);
		callBoard.setLineWrap(true);

	}

	private void initListner() {

		// 返回主页
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 获取公告
				final String notice = stuBiz.lookNotice();

				change.removeAll();
				now = "通知公告";
				NowLocat();
				callBoard = new JTextArea();
				callBoard.setBounds(0, 26, 835, 349);
				change.add(callBoard);
				callBoard.setEditable(false);
				callBoard.setText(notice);
				callBoard.setLineWrap(true);
				change.repaint();
			}
		});

		// 评价界面

		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 获取学生所有考试成绩列表
				final List<Result> resList = stuBiz.queryResult(stu);
				// 取出未评价的科目
				final List<Result> noComms = new ArrayList<>();
				for (Result result : resList) {
					if (result.getIscomm() == 0) {
						noComms.add(result);
					}
				}
				// 构造二维数组存放数据
				Object[][] comms = new Object[noComms.size()][2];

				for (int i = 0; i < noComms.size(); ++i) {
					Result res = noComms.get(i);
					comms[i][0] = res.getSub().getName();
					comms[i][1] = res.getTea().getName();
				}
				change.removeAll();
				now = "教学质量评价";
				NowLocat();

				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int selectedrow = table.getSelectedRow();

						// 防止点按位置超出范围
						if (selectedrow != -1) {
							Result res = noComms.get(selectedrow);
							if (res.getIscomm() == 1) {
								// 已存在评论
								JOptionPane.showMessageDialog(StudentView.this,
										"已评价，不可重复评价!");
							} else {
								StuCommandView commView = new StuCommandView(
										stu, res);
								commView.setVisible(true);
							}
						}
					}

				});

				table.setModel(new DefaultTableModel(comms, new String[] {
						"科目", "授课老师" }) {

					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false,
							false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

				JPanel paneltable = new JPanel(new BorderLayout());
				paneltable.setBounds(0, 36, 835, 349);
				Border btable = BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(null, null), "教师评价");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);
				change.add(paneltable);
				change.repaint();
			}
		});

		// 查看考试成绩
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 获取成绩数据
				final List<Result> resList = stuBiz.queryResult(stu);
				Object[][] ress = new Object[resList.size()][4];

				for (int i = 0; i < resList.size(); i++) {
					Result res = resList.get(i);
					ress[i][0] = res.getSub().getName();
					ress[i][1] = res.getTea().getName();
					ress[i][2] = res.getScore();
					ress[i][3] = res.getTime();
				}

				change.removeAll();
				now = "查看成绩";
				NowLocat();

				table = new JTable();
				table.setModel(new DefaultTableModel(ress, new String[] { "科目",
						"授课老师", "分数", "考试时间" }) {
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false,
							false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

				JPanel paneltable = new JPanel(new BorderLayout());
				paneltable.setBounds(0, 36, 835, 349);
				Border btable = BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(null, null), "成绩列表");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);
				change.add(paneltable);
				change.repaint();
			}
		});

		// 查看个人信息
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change.removeAll();
				now = "个人信息";
				NowLocat();

				JLabel lblNewLabel = new JLabel("学号：");
				lblNewLabel.setBounds(39, 46, 83, 34);
				change.add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("姓名：");
				lblNewLabel_1.setBounds(39, 90, 75, 50);
				change.add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("联系电话：");
				lblNewLabel_2.setBounds(39, 150, 200, 50);
				change.add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("家庭地址：");
				lblNewLabel_3.setBounds(39, 220, 200, 50);
				change.add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel("宿舍：");
				lblNewLabel_4.setBounds(407, 38, 200, 50);
				change.add(lblNewLabel_4);

				JLabel lblNewLabel_5 = new JLabel("所属专业：");
				lblNewLabel_5.setBounds(407, 94, 200, 50);
				change.add(lblNewLabel_5);

				JLabel lblNewLabel_6 = new JLabel("年级：");
				lblNewLabel_6.setBounds(407, 150, 200, 50);
				change.add(lblNewLabel_6);

				JLabel lblNewLabel_7 = new JLabel("班级：");
				lblNewLabel_7.setBounds(407, 220, 200, 50);
				change.add(lblNewLabel_7);

				id = new JTextField();
				id.setEditable(false);
				id.setText("" + stu.getId());
				id.setBounds(103, 53, 294, 21);
				change.add(id);
				id.setColumns(10);

				name = new JTextField();
				name.setEditable(false);
				name.setText(stu.getName());
				name.setBounds(103, 105, 294, 21);
				change.add(name);
				name.setColumns(10);

				phone = new JTextField();
				phone.setEditable(false);
				phone.setText(stu.getPhone());
				phone.setBounds(105, 165, 292, 21);
				change.add(phone);
				phone.setColumns(10);

				address = new JTextField();
				address.setEditable(false);
				address.setText(stu.getAddress());
				address.setBounds(103, 235, 294, 21);
				change.add(address);
				address.setColumns(10);

				dormiting = new JTextField();
				dormiting.setEditable(false);
				dormiting.setText(stu.getDormiting());
				dormiting.setBounds(468, 53, 337, 21);
				change.add(dormiting);
				dormiting.setColumns(10);

				major = new JTextField();
				major.setEditable(false);
				major.setText(stu.getMajor().getName());
				major.setBounds(468, 105, 337, 21);
				change.add(major);
				major.setColumns(10);

				grade = new JTextField();
				grade.setEditable(false);
				grade.setBounds(468, 165, 337, 21);
				grade.setText(stu.getGrade().getName());
				change.add(grade);
				grade.setColumns(10);

				classno = new JTextField();
				classno.setEditable(false);
				classno.setBounds(468, 235, 337, 21);
				classno.setText(stu.getClassno() + "");
				change.add(classno);
				classno.setColumns(10);
				change.repaint();
			}
		});
		// 更换密码
		mnNewMenu_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// UpdatePassword update = new UpdatePassword();
				// update.setVisible(true);
				StuChangePswView changePswView = new StuChangePswView(stu);
				changePswView.setVisible(true);
			}
		});

		// 课程表
		mnNewMenu_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 获取课程表
				List<Course> couList = stuBiz.queryCourse(stu);

				Object[][] cous = new Object[6][8];

				cous[0][0] = "8:30-10:05";
				cous[1][0] = "10:30-12:00";
				cous[2][0] = "2:40-4:15";
				cous[3][0] = "4:30-6:05";
				cous[4][0] = "6:30-8:00";
				cous[5][0] = "8:10-9:30";
				// 插入数据
				for (int i = 0; i < couList.size(); i++) {
					Course cou = couList.get(i);
					int x = cou.getWeekday();
					int y = cou.getTimepoint() - 1;
					cous[y][x] = cou.getSub().getName() + " " + cou.getRoom()
							+ " "	+ cou.getWeek()+" " + cou.getTea().getName();
				}
				change.removeAll();
				now = "查看课表";
				NowLocat();
				table = new JTable();
				table.setModel(new DefaultTableModel(

				cous, new String[] { "时间","周一", "周二", "周三", "周四", "周五", "周六", "周日" }) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false,
							false, false, false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

				JPanel paneltable = new JPanel(new BorderLayout());
				paneltable.setBounds(0, 36, 835, 349);
				Border btable = BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(null, null), "课程表");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);
				change.add(paneltable);
				change.repaint();
			}
		});
		// 退出登录
		mnNewMenu_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginView loginview = new LoginView();
				loginview.setVisible(true);

			}
		});
	}

	private void NowLocat() {
		label_1 = new JLabel("当前位置 —");
		label_1.setBounds(0, 0, 101, 23);
		change.add(label_1);
		label_1.setIcon(new ImageIcon("photos\\004.png"));

		location = new JLabel(now);
		location.setBounds(110, 0, 83, 23);
		change.add(location);

	}
}
