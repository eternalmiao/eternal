package cn.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import cn.bean.Command;
import cn.bean.Course;
import cn.bean.Grade;
import cn.bean.Major;
import cn.bean.Result;
import cn.bean.Student;
import cn.bean.Subject;
import cn.bean.Teacher;
import cn.biz.TeacherBiz;
import cn.biz.impl.TeacherBizImpl;
import cn.dao.impl.GradeDaoImpl;
import cn.dao.impl.MajorDaoImpl;
import cn.dao.impl.ResultDaoImpl;
import cn.dao.impl.StudentDaoImpl;
import cn.dao.impl.SubjectDaoImpl;

public class TeacherView extends JFrame {

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
	private Teacher tea;
	private TeacherBiz teaBiz;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenu mnNewMenu_5;
	private JMenu mnNewMenu_6;
	private JMenu mnNewMenu_7;
	private GradeDaoImpl gradeImpl;
	private SubjectDaoImpl subImpl;
	private MajorDaoImpl majorImpl;
	private StudentDaoImpl stuImpl;
	private ResultDaoImpl resImpl;

	public TeacherView(Teacher tea) throws HeadlessException {
		super();
		this.tea = tea;
		teaBiz = new TeacherBizImpl();
		gradeImpl = new GradeDaoImpl();
		subImpl = new SubjectDaoImpl();
		majorImpl = new MajorDaoImpl();
		stuImpl = new StudentDaoImpl();
		resImpl = new ResultDaoImpl();
		initView();
		initListener();

	}

	public void initView() {
		setTitle("教师操作界面");
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

		mnNewMenu_3 = new JMenu("查看与发布成绩");

		menuBar.add(mnNewMenu_3);

		mnNewMenu_6 = new JMenu("教师课程表");

		menuBar.add(mnNewMenu_6);

		mnNewMenu_7 = new JMenu("退出登录");

		menuBar.add(mnNewMenu_7);

		change = new JPanel();
		change.setBounds(0, 21, 835, 375);
		panel.add(change);
		change.setLayout(null);

		NowLocat();
		final String notice = teaBiz.lookNtice();
		callBoard = new JTextArea();
		callBoard.setBounds(0, 26, 835, 349);
		change.add(callBoard);
		callBoard.setEditable(false);
		callBoard.setText(notice);
		callBoard.setLineWrap(true);

	}

	private void initListener() {
		// 返回主页，显示公告
		final String notice = teaBiz.lookNtice();
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		List<Command> commList = teaBiz
				.queryCommand(tea, new Subject(1, "", 1));
		Object[][] comms = new Object[commList.size()][4];

		for (int i = 0; i < commList.size(); i++) {
			Command comm = commList.get(i);
			comms[i][0] = comm.getSub().getName();
			comms[i][1] = comm.getStu().getName();
			comms[i][2] = comm.getNum();
			comms[i][3] = comm.getCom();
		}
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change.removeAll();
				now = "教学质量评价";
				NowLocat();
				// 初始化数据
				final List<Subject> subList = subImpl.findAllSubject();
				// 科目信息
				String[] subs = new String[subList.size()];
				for (int i = 0; i < subList.size(); i++) {
					subs[i] = subList.get(i).getName();
				}

				table = new JTable();
				table.setModel(new DefaultTableModel(null, new String[] { "科目",
						"评价的学生", "满意程度", "评论内容" }) {
					/**
					 * 
					 */
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
						BorderFactory.createEtchedBorder(null, null), "学生评价");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);
				change.add(paneltable);

				JLabel label_5 = new JLabel("科目:");
				label_5.setBounds(606, 0, 39, 23);
				change.add(label_5);

				final JComboBox<Object> choice_3 = new JComboBox<Object>();
				choice_3.setBounds(647, 0, 89, 21);
				// 添加科目选项
				choice_3.setModel(new DefaultComboBoxModel<Object>(subs));

				change.add(choice_3);

				JButton btnNewButton_2 = new JButton("查询");
				btnNewButton_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 添加科目查找方法
						Subject sub = subList.get(choice_3.getSelectedIndex());
						List<Command> comList = teaBiz.queryCommand(tea, sub);
						if (comList.size() > 0) {
							Object[][] coms = new Object[comList.size()][4];
							for (int i = 0; i < comList.size(); i++) {
								Command com = comList.get(i);

								coms[i][0] = com.getSub().getName();
								coms[i][1] = com.getStu().getName();
								coms[i][2] = com.getNum() + "";
								coms[i][3] = com.getCom();
							}
							table.setModel(new DefaultTableModel(coms,
									new String[] { "科目", "评价的学生", "满意程度",
											"评论内容" }) {
								/**
								 * 
								 */
								private static final long serialVersionUID = 1L;
								boolean[] columnEditables = new boolean[] {
										false, false, false, false };

								public boolean isCellEditable(int row,
										int column) {
									return columnEditables[column];
								}
							});

						} else {
							JOptionPane.showMessageDialog(TeacherView.this,
									"暂无评价!");
						}

					}
				});
				btnNewButton_2.setBounds(742, 0, 63, 23);
				change.add(btnNewButton_2);
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

				JLabel lblNewLabel = new JLabel("教工号：");
				lblNewLabel.setBounds(186, 46, 83, 34);
				change.add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("姓名：");
				lblNewLabel_1.setBounds(186, 90, 75, 50);
				change.add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("联系电话：");
				lblNewLabel_2.setBounds(186, 150, 200, 50);
				change.add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("家庭地址：");
				lblNewLabel_3.setBounds(186, 210, 200, 50);
				change.add(lblNewLabel_3);

				id = new JTextField();
				id.setEditable(false);
				id.setText(tea.getId() + "");
				id.setBounds(279, 53, 294, 21);
				change.add(id);
				id.setColumns(10);

				name = new JTextField();
				name.setEditable(false);
				name.setText(tea.getName());
				name.setBounds(279, 105, 294, 21);
				change.add(name);
				name.setColumns(10);

				phone = new JTextField();
				phone.setEditable(false);
				phone.setText(tea.getPhone());
				phone.setBounds(279, 165, 292, 21);
				change.add(phone);
				phone.setColumns(10);

				address = new JTextField();
				address.setEditable(false);
				address.setText(tea.getAddress());
				address.setBounds(279, 225, 294, 21);
				change.add(address);
				address.setColumns(10);
				change.repaint();
			}
		});
		// 修改密码
		mnNewMenu_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// UpdatePassword update = new UpdatePassword();
				// update.setVisible(true);
				TeaChangePswView teaChangePswView = new TeaChangePswView(tea);
				teaChangePswView.setVisible(true);

			}
		});

		// 查看成绩与添加成绩
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change.removeAll();
				now = "成绩";
				NowLocat();

				table = new JTable();
				table.getSelectionModel().setSelectionInterval(0, 0);
				table.addFocusListener(new FocusAdapter() {

					@Override
					public void focusLost(FocusEvent e) {

					}

					public void focusGained(FocusEvent e) {
					}
				});
				table.setModel(new DefaultTableModel(null, new String[] { "科目",
						"学号", "学生", "分数", "考试时间" }) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false,
							false, true, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

				// 初始化面板
				JPanel paneltable = new JPanel(new BorderLayout());
				paneltable.setBounds(0, 64, 835, 349);
				Border btable = BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(null, null), "成绩列表");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);// 使表格能够滚动显示，并且剧中
				change.add(paneltable);

				// 初始化数据
				final List<Grade> gradeList = gradeImpl.findAllGrade();
				final List<Subject> subList = subImpl.findAllSubject();
				final List<Major> majorList = majorImpl.findAllMajor();

				// 将年级信息转化String数组
				String[] grades = new String[gradeList.size()];
				for (int i = 0; i < gradeList.size(); i++) {
					grades[i] = gradeList.get(i).getName();
				}
				// 将专业信息转化成String数组
				String[] majors = new String[majorList.size()];
				for (int i = 0; i < majorList.size(); i++) {
					majors[i] = majorList.get(i).getName();
				}
				// 科目信息
				String[] subs = new String[subList.size()];
				for (int i = 0; i < subList.size(); i++) {
					subs[i] = subList.get(i).getName();
				}

				JLabel label_3 = new JLabel("年级:");
				label_3.setBounds(202, 0, 41, 23);
				change.add(label_3);

				final JComboBox<Object> gradebox = new JComboBox<Object>();
				gradebox.setBounds(251, 0, 88, 21);
				gradebox.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						grades));
				change.add(gradebox);

				JLabel label_2 = new JLabel("专业:");
				label_2.setBounds(360, 0, 41, 23);
				change.add(label_2);

				final JComboBox<String> majbox = new JComboBox<String>();
				majbox.setBounds(410, 0, 88, 21);
				majbox.setModel((ComboBoxModel<String>) new DefaultComboBoxModel<String>(
						majors));
				change.add(majbox);

				JLabel timelab = new JLabel("时间:");
				timelab.setBounds(540, 0, 41, 23);
				change.add(timelab);

				final JTextField timeInput = new JTextField();
				timeInput.setBounds(590, 0, 100, 24);
				change.add(timeInput);

				JLabel label_4 = new JLabel("班级:");
				label_4.setBounds(360, 28, 35, 23);
				change.add(label_4);

				final JComboBox<Object> classnobox = new JComboBox<Object>();
				classnobox.setBounds(410, 28, 88, 21);
				classnobox.setModel(new DefaultComboBoxModel<Object>(
						new String[] { "", "1", "2 ", "3", "4", "5", "6", "7",
								"8" }));
				change.add(classnobox);

				JLabel label_5 = new JLabel("科目:");
				label_5.setBounds(202, 28, 41, 23);
				change.add(label_5);

				final JComboBox<Object> subbox = new JComboBox<Object>();
				subbox.setBounds(251, 28, 88, 22);
				subbox.setModel(new DefaultComboBoxModel<Object>(subs));
				change.add(subbox);

				// 查询按钮
				JButton btnNewButton_2 = new JButton("查询");
				// 监听
				btnNewButton_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 获取下拉列表选中信息
						int gradeid = gradebox.getSelectedIndex();
						int majorid = majbox.getSelectedIndex();
						int classno = classnobox.getSelectedIndex();
						Grade grade = gradeList.get(gradeid);
						Major maj = majorList.get(majorid);
						Subject sub = subList.get(subbox.getSelectedIndex());
						String time = timeInput.getText();
						// 获取对应班级学生信息
						List<Student> stuList = stuImpl.findStudentByMGC(
								grade.getId(), maj.getId(), classno);
						// 转存到二维数组中
						if (stuList.size() > 0) {
							Object[][] infos = new Object[stuList.size()][5];
							for (int i = 0; i < stuList.size(); i++) {
								Student stu = stuList.get(i);
								infos[i][0] = sub.getName();
								infos[i][1] = stu.getId() + "";
								infos[i][2] = stu.getName();
								// 获取成绩
								Result res = resImpl.checkResult(stu.getId(),
										sub.getId());
								if (res != null) {
									// 成绩存在
									infos[i][3] = res.getScore() + "";
									// 考试时间
									infos[i][4] = res.getTime();
								} else {
									// 不存在
									infos[i][4] = time;
								}

							}
							if (infos[0][3] != null) {
								// 成绩已存在，使整个表格不可编辑
								table.setModel(new DefaultTableModel(infos,
										new String[] { "科目", "学号", "学生", "分数",
												"考试时间" }) {
									private static final long serialVersionUID = 1L;
									boolean[] columnEditables = new boolean[] {
											false, false, false, false, false };

									public boolean isCellEditable(int row,
											int column) {
										return columnEditables[column];
									}
								});
							} else {
								// 还没有添加过成绩的，成绩栏可编辑
								table.setModel(new DefaultTableModel(infos,
										new String[] { "科目", "学号", "学生", "分数",
												"考试时间" }) {
									private static final long serialVersionUID = 1L;
									boolean[] columnEditables = new boolean[] {
											false, false, false, true, false };

									public boolean isCellEditable(int row,
											int column) {
										return columnEditables[column];
									}
								});
							}
						}

					}
				});
				btnNewButton_2.setBounds(762, 0, 63, 23);
				change.add(btnNewButton_2);

				// 提交按钮
				JButton btnNewButton_3 = new JButton("提交");
				// 添加成绩
				btnNewButton_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						// 当表格中含有数据时
						if (table.getValueAt(0, 0) != null) {
							List<Result> resList = new ArrayList<>();
							Subject sub = subList.get(subbox.getSelectedIndex());
							String time = timeInput.getText();
							if (time == null || time.length() == 0) {
								JOptionPane.showMessageDialog(TeacherView.this,
										"请输入考试时间!");
								return;
							}
							// 获取行数
							int count = table.getRowCount();
							for (int i = 0; i < count; i++) {
								Result res = new Result();
								int stuid = Integer.parseInt(table.getValueAt(
										i, 1).toString());
								double score = 0;
								try {
									score = Double.parseDouble(table
											.getValueAt(i, 3).toString());
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(
											TeacherView.this, "请输入成绩!");
									return;
								}
								if (score <= 0 || score > 100) {
									JOptionPane.showMessageDialog(
											TeacherView.this, "请输入正确的成绩!");
									return;
								}
								res.setStu(stuImpl.findStudent(stuid));
								res.setScore(score);
								res.setTea(tea);
								res.setSub(sub);
								res.setTime(time);
								resList.add(res);
							}
							if (teaBiz.addAllResult(resList)) {
								JOptionPane.showMessageDialog(TeacherView.this,
										"添加成功!");
							} else {
								JOptionPane.showMessageDialog(TeacherView.this,
										"添加失败!");
							}

						}

					}
				});
				btnNewButton_3.setBounds(762, 28, 63, 23);
				change.add(btnNewButton_3);
				change.repaint();

			}
		});
		// 查看教师课程表

		mnNewMenu_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 初始化数据

				List<Course> couList = teaBiz.queryCourse(tea);
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
							+ " " + cou.getWeek() + " "
							+ cou.getTea().getName();
				}

				change.removeAll();
				now = "查看教师课程表";
				NowLocat();

				table = new JTable();
				table.setFillsViewportHeight(true);
				table.setModel(new DefaultTableModel(cous, new String[] { "时间",
						"周一", "周二", "周三", "周四", "周五", "周六", "周日" }) {
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
						BorderFactory.createEtchedBorder(null, null), "教师课表");// 边框样式
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
				LoginView login = new LoginView();
				login.setVisible(true);
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
