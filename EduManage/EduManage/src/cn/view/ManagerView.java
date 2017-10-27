package cn.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import cn.bean.Notice;
import cn.bean.Result;
import cn.bean.Root;
import cn.bean.Student;
import cn.bean.Subject;
import cn.bean.Teacher;
import cn.biz.RootBiz;
import cn.biz.impl.RootBizImpl;
import cn.dao.CommandDao;
import cn.dao.CourseDao;
import cn.dao.GradeDao;
import cn.dao.MajorDao;
import cn.dao.ResultDao;
import cn.dao.StudentDao;
import cn.dao.SubjectDao;
import cn.dao.TeacherDao;
import cn.dao.impl.CommandDaoImpl;
import cn.dao.impl.CourseDaoImpl;
import cn.dao.impl.GradeDaoImpl;
import cn.dao.impl.MajorDaoImpl;
import cn.dao.impl.ResultDaoImpl;
import cn.dao.impl.StudentDaoImpl;
import cn.dao.impl.SubjectDaoImpl;
import cn.dao.impl.TeacherDaoImpl;

public class ManagerView extends JFrame {
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
	private JButton btnNewButton_3;
	private JButton btnNewButton_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea teacon;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private RootBiz rootbiz;
	private JMenu noticeMenu;
	private JMenu commMenu;
	private JMenu resMenu;
	private JMenu courseMenu;
	private JMenu stuMenu;
	private JMenu teaMenu;
	private JMenu subMenu;
	private JMenu exitMenu;
	private JMenu changePswMenu;
	private Root root;
	private TeacherDao teadao;
	private SubjectDao subDao;
	private CommandDao commDao;
	private GradeDao gradeDao;
	private MajorDao majorDao;
	private ResultDao resDao;
	private CourseDao courseDao;
	private StudentDao stuDao;

	public ManagerView(Root root) throws HeadlessException {
		super();
		rootbiz = new RootBizImpl();
		teadao = new TeacherDaoImpl();
		subDao = new SubjectDaoImpl();
		commDao = new CommandDaoImpl();
		gradeDao = new GradeDaoImpl();
		resDao = new ResultDaoImpl();
		majorDao = new MajorDaoImpl();
		courseDao = new CourseDaoImpl();
		stuDao = new StudentDaoImpl();
		this.root = root;
		initView();
		initListener();
	}

	/**
	 * 初始化基本界面
	 */
	public void initView() {
		setTitle("管理员操作界面");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 515);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel(icon);
		label.setBounds(5, 5, 835, 56);
		contentPane.add(label);

		panel = new JPanel();
		// panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(5, 59, 925, 431);
		contentPane.add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		// menuBar.setBackground(new Color(255, 204, 255));
		menuBar.setBounds(0, 0, 835, 21);
		panel.add(menuBar);

		noticeMenu = new JMenu("修改公告");

		menuBar.add(noticeMenu);

		commMenu = new JMenu("教学质量评价");

		menuBar.add(commMenu);

		resMenu = new JMenu("查看成绩");

		menuBar.add(resMenu);

		courseMenu = new JMenu("查看课程表");

		menuBar.add(courseMenu);

		exitMenu = new JMenu("退出登录");

		stuMenu = new JMenu("学生信息");

		menuBar.add(stuMenu);

		teaMenu = new JMenu("老师信息");

		menuBar.add(teaMenu);

		changePswMenu = new JMenu("修改密码");

		subMenu = new JMenu("查看科目");

		menuBar.add(subMenu);
		menuBar.add(changePswMenu);
		menuBar.add(exitMenu);

		change = new JPanel();
		change.setBounds(0, 21, 925, 410);
		JLabel welcome = new JLabel();
		welcome.setFont(new Font("utf-8", Font.BOLD | Font.ITALIC, 18));
		welcome.setText("     BUG教务管理系统，给你一个永无BUG的体验！");
		welcome.setBounds(200, 20, 600, 70);

		JLabel text1 = new JLabel();
		text1.setText("     ——————来自BUG团队");
		text1.setBounds(280, 90, 200, 35);

		JLabel text2 = new JLabel();
		text2.setText("     组长：袁文俊");
		text2.setBounds(300, 130, 200, 35);
		JLabel text3 = new JLabel();
		text3.setText("     组员：陈鹏飞");
		text3.setBounds(305, 170, 200, 35);
		JLabel text4 = new JLabel();
		text4.setText("     组员：冯宇龙");
		text4.setBounds(310, 210, 200, 35);
		JLabel text5 = new JLabel();
		text5.setText("     组员：周远朋");
		text5.setBounds(315, 250, 200, 35);
		JLabel text6 = new JLabel();
		text6.setText("     组员：朱淼鑫");
		text6.setBounds(320, 290, 200, 35);

		change.add(welcome);
		change.add(text1);
		change.add(text2);
		change.add(text3);
		change.add(text4);
		change.add(text5);
		change.add(text6);

		panel.add(change);
		change.setLayout(null);

	}

	private void initListener() {
		// 公告栏
		noticeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				change.removeAll();
				final Notice notice = rootbiz.getNotice();
				NowLocat();
				JLabel label_2 = new JLabel("学生公告：");
				label_2.setBounds(0, 29, 69, 23);
				change.add(label_2);

				callBoard = new JTextArea();
				callBoard.setBounds(0, 52, 835, 157);
				change.add(callBoard);
				callBoard.setText(notice.getStucontent());

				callBoard.setLineWrap(true);

				JButton btnNewButton = new JButton("确认修改");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 学生公告
						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定修改?", "确认修改", JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							String s = callBoard.getText();
							notice.setStucontent(s);
							if (rootbiz.addNotice(notice)) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"修改成功！");
								callBoard.setText(notice.getStucontent());

							} else {
								JOptionPane.showMessageDialog(ManagerView.this,
										"修改失败！");
							}

						}
					}
				});
				btnNewButton.setBounds(745, 211, 90, 23);
				change.add(btnNewButton);

				JLabel label_3 = new JLabel("教师公告：");
				label_3.setBounds(0, 211, 69, 23);
				change.add(label_3);
				teacon = new JTextArea();
				teacon.setBounds(0, 233, 835, 144);
				teacon.setText(notice.getTeacontent());
				change.add(teacon);
				teacon.setColumns(10);

				JButton btnNewButton_10 = new JButton("确认修改");
				btnNewButton_10.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 教师公告
						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定修改?", "确认修改", JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							String s = teacon.getText();
							notice.setTeacontent(s);
							if (rootbiz.addNotice(notice)) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"修改成功！");
								teacon.setText(notice.getTeacontent());

							} else {
								JOptionPane.showMessageDialog(ManagerView.this,
										"修改失败！");
							}
						}
					}
				});
				btnNewButton_10.setBounds(742, 377, 93, 23);
				change.add(btnNewButton_10);

				change.repaint();
			}
		});

		// 评价管理界面
		commMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change.removeAll();
				now = "教学质量评价";
				NowLocat();

				// 获取教师信息和科目信息
				final List<Teacher> teaList = teadao.findAllTeacher();
				final List<Subject> subList = subDao.findAllSubject();

				String[] teas = new String[teaList.size() + 1];
				String[] subs = new String[subList.size() + 1];
				teas[0] = "";
				subs[0] = "";
				for (int i = 0; i < teaList.size(); i++) {
					teas[i + 1] = teaList.get(i).getName();
				}
				for (int j = 0; j < subList.size(); j++) {
					subs[j + 1] = subList.get(j).getName();
				}

				JLabel label_5 = new JLabel("科目:");
				label_5.setBounds(626, 0, 35, 23);
				change.add(label_5);

				final JComboBox<Object> subbox = new JComboBox<Object>();
				subbox.setBounds(667, 0, 89, 21);
				subbox.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						subs));
				change.add(subbox);

				JLabel tealab = new JLabel("教师:");
				tealab.setBounds(426, 0, 35, 23);
				change.add(tealab);

				final JComboBox<Object> teabox = new JComboBox<Object>();
				teabox.setBounds(478, 0, 89, 21);
				teabox.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						teas));
				change.add(teabox);

				table = new JTable();
				// 初始化表格模型
				table.setModel(new DefaultTableModel(null, new String[] { "科目",
						"评价的学生", "授课老师", "满意程度", "评论内容" }) {
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false,
							false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				// 设置表格样式
				JPanel paneltable = new JPanel(new BorderLayout());
				paneltable.setBounds(0, 36, 835, 349);
				Border btable = BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(null, null), "教学质量评价");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);// 可滚动
				change.add(paneltable);
				JButton btnNewButton_2 = new JButton("查询");
				btnNewButton_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 添加科目查找方法
						int teano = teabox.getSelectedIndex();
						int subno = subbox.getSelectedIndex();

						if (teano == 0 && subno == 0) {
							// 没选择教师和科目

						} else if (teano == 0 && subno != 0) {
							// 选择了科目，已科目方式查询评价
							Subject sub = subList.get(subno - 1);
							List<Command> commList = commDao
									.findCommandBySub(sub.getId());
							if (commList.size() == 0) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"暂无评论！");
							} else {
								Object[][] comms = new Object[commList.size()][5];
								for (int i = 0; i < commList.size(); i++) {
									Command comm = commList.get(i);
									comms[i][0] = comm.getSub().getName();
									comms[i][1] = comm.getStu().getName();
									comms[i][2] = comm.getTea().getName();
									comms[i][3] = comm.getNum() + "";
									comms[i][4] = comm.getCom();
									table.setModel(new DefaultTableModel(comms,
											new String[] { "科目", "评价的学生",
													"授课老师", "满意程度", "评论内容" }) {
										private static final long serialVersionUID = 1L;
										boolean[] columnEditables = new boolean[] {
												false, false, false, false,
												false };

										public boolean isCellEditable(int row,
												int column) {
											return columnEditables[column];
										}
									});

								}
							}

						} else if (teano != 0 && subno == 0) {
							// 已教师模式查询评价
							Teacher tea = teaList.get(teano - 1);
							List<Command> commList = commDao
									.findCommandByTea(tea.getId());
							if (commList.size() == 0) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"暂无评论！");
							} else {
								Object[][] comms = new Object[commList.size()][5];
								for (int i = 0; i < commList.size(); i++) {
									Command comm = commList.get(i);
									comms[i][0] = comm.getSub().getName();
									comms[i][1] = comm.getStu().getName();
									comms[i][2] = comm.getTea().getName();
									comms[i][3] = comm.getNum() + "";
									comms[i][4] = comm.getCom();
									table.setModel(new DefaultTableModel(comms,
											new String[] { "科目", "评价的学生",
													"授课老师", "满意程度", "评论内容" }) {
										private static final long serialVersionUID = 1L;
										boolean[] columnEditables = new boolean[] {
												false, false, false, false,
												false };

										public boolean isCellEditable(int row,
												int column) {
											return columnEditables[column];
										}
									});

								}
							}

						} else {
							// 教师加科目查询
							Subject sub = subList.get(subno - 1);
							Teacher tea = teaList.get(teano - 1);
							List<Command> commList = commDao
									.findCommandByTeaAndSub(tea.getId(),
											sub.getId());
							if (commList.size() == 0) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"暂无评论！");
							} else {
								Object[][] comms = new Object[commList.size()][5];
								for (int i = 0; i < commList.size(); i++) {
									Command comm = commList.get(i);
									comms[i][0] = comm.getSub().getName();
									comms[i][1] = comm.getStu().getName();
									comms[i][2] = comm.getTea().getName();
									comms[i][3] = comm.getNum() + "";
									comms[i][4] = comm.getCom();
									table.setModel(new DefaultTableModel(comms,
											new String[] { "科目", "评价的学生",
													"授课老师", "满意程度", "评论内容" }) {
										private static final long serialVersionUID = 1L;
										boolean[] columnEditables = new boolean[] {
												false, false, false, false,
												false };

										public boolean isCellEditable(int row,
												int column) {
											return columnEditables[column];
										}
									});

								}
							}
						}

					}
				});
				btnNewButton_2.setBounds(762, 0, 63, 23);
				change.add(btnNewButton_2);

				change.repaint();
			}
		});

		// 成绩管理
		resMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change.removeAll();
				now = "查看成绩";
				NowLocat();
				// 科目信息
				final List<Subject> subjectList = subDao.findAllSubject();

				String[] subs = new String[subjectList.size()];

				for (int k = 0; k < subjectList.size(); k++) {
					subs[k] = subjectList.get(k).getName();
				}

				table = new JTable();

				JLabel lblNewLabel = new JLabel("分数：");
				lblNewLabel.setBounds(441, 385, 55, 15);
				change.add(lblNewLabel);

				textField = new JTextField();
				textField.setBounds(510, 385, 83, 21);
				change.add(textField);
				textField.setColumns(10);

				JLabel lblNewLabel_1 = new JLabel("考试时间:");
				lblNewLabel_1.setBounds(603, 385, 72, 15);
				change.add(lblNewLabel_1);

				textField_1 = new JTextField();
				textField_1.setBounds(685, 385, 150, 21);
				change.add(textField_1);
				textField_1.setColumns(10);

				JLabel lblNewLabel_2 = new JLabel("选择修改的学号:");
				lblNewLabel_2.setBounds(214, 385, 114, 15);
				change.add(lblNewLabel_2);

				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setBounds(338, 382, 93, 21);
				change.add(textField_2);
				textField_2.setColumns(10);

				JLabel lblNewLabel_3 = new JLabel("选择的科目:");
				lblNewLabel_3.setBounds(0, 385, 82, 15);
				change.add(lblNewLabel_3);

				textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setBounds(92, 382, 101, 21);
				change.add(textField_3);
				textField_3.setColumns(10);
				// 初始化表格模型
				table.setModel(new DefaultTableModel(null, new String[] { "科目",
						"学号", "学生", "授课老师", "分数", "考试时间" }) {
					/**
							 * 
							 */
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false,
							false, false, false, false, };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				// 表格样式
				JPanel paneltable = new JPanel(new BorderLayout());
				paneltable.setBounds(0, 36, 835, 349);
				Border btable = BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(null, null), "学生成绩");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);
				change.add(paneltable);

				JLabel label_5 = new JLabel("科目:");
				label_5.setBounds(520, 0, 35, 23);
				change.add(label_5);

				final JComboBox<Object> subox2 = new JComboBox<Object>();
				subox2.setBounds(570, 0, 89, 21);
				subox2.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						subs));
				change.add(subox2);

				JButton btnNewButton_2 = new JButton("查询");
				btnNewButton_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 添加科目查找方法
						Subject sub = subjectList.get(subox2.getSelectedIndex());
						List<Result> reslist = resDao.findResultBySub(sub
								.getId());
						if (reslist.size() == 0) {
							JOptionPane.showMessageDialog(ManagerView.this,
									"暂无成绩！");
						} else {
							Object[][] ress = new Object[reslist.size()][6];
							for (int i = 0; i < reslist.size(); i++) {
								Result res = reslist.get(i);
								ress[i][0] = res.getSub().getName();
								ress[i][1] = res.getStu().getId();
								ress[i][2] = res.getStu().getName();
								ress[i][3] = res.getTea().getName();
								ress[i][4] = res.getScore();
								ress[i][5] = res.getTime();
							}
							table.setModel(new DefaultTableModel(ress,
									new String[] { "科目", "学号", "学生", "授课老师",
											"分数", "考试时间" }) {
								private static final long serialVersionUID = 1L;
								boolean[] columnEditables = new boolean[] {
										false, false, false, false, false,
										false, };

								public boolean isCellEditable(int row,
										int column) {
									return columnEditables[column];
								}
							});

						}
					}
				});
				btnNewButton_2.setBounds(842, 140, 60, 40);
				change.add(btnNewButton_2);

				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 修改和删除按钮可用
						btnNewButton_3.setEnabled(true);
						btnNewButton_5.setEnabled(true);
						int selectedrow = table.getSelectedRow();
						// 获取选中表格信息
						String score = table.getValueAt(selectedrow, 4)
								.toString();
						String time = table.getValueAt(selectedrow, 5)
								.toString();
						String stuid = table.getValueAt(selectedrow, 1)
								.toString();
						String subname = table.getValueAt(selectedrow, 0)
								.toString();
						// 赋值到输入框
						textField.setText(score);
						textField_1.setText(time);
						textField_2.setText(stuid);
						textField_3.setText(subname);

					}
				});

				btnNewButton_3 = new JButton("修改");
				btnNewButton_3.setEnabled(false);
				btnNewButton_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int selectedrow = table.getSelectedRow();// 获得选取行

						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定修改?", "确认修改", JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							// 修改方法
							int stuid = Integer.parseInt(table.getValueAt(
									selectedrow, 1).toString());
							Subject sub = subjectList.get(subox2
									.getSelectedIndex());
							Result res = resDao.checkResult(stuid, sub.getId());

							if (res != null) {
								double score = 0;
								if (textField.getText().length() != 0) {
									score = Double.parseDouble(textField
											.getText());
								}
								String time = "";
								if (textField_1.getText().length() != 0) {
									time = textField_1.getText();
								}
								res.setScore(score);
								res.setTime(time);
								if (resDao.updateResult(res)) {
									JOptionPane.showMessageDialog(
											ManagerView.this, "修改成功！");
								} else {
									JOptionPane.showMessageDialog(
											ManagerView.this, "修改失败！");
								}
							}

						}

					}
				});
				btnNewButton_3.setBounds(842, 350, 60, 40);
				change.add(btnNewButton_3);

				btnNewButton_5 = new JButton("删除");
				btnNewButton_5.setEnabled(false);
				btnNewButton_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int selectedrow = table.getSelectedRow();// 获得选取行
						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定删除?", "确认删除", JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							int stuid = Integer.parseInt(table.getValueAt(
									selectedrow, 1).toString());
							Subject sub = subjectList.get(subox2
									.getSelectedIndex());
							if (resDao.deleteResult(stuid, sub.getId())) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"删除成功！");
							} else {
								JOptionPane.showMessageDialog(ManagerView.this,
										"删除失败！");
							}
						}
					}
				});
				btnNewButton_5.setBounds(842, 280, 60, 40);
				change.add(btnNewButton_5);

				JButton btnNewButton_6 = new JButton("添加");
				btnNewButton_6.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						AddResultView add = new AddResultView();
						add.setVisible(true);
					}
				});
				btnNewButton_6.setBounds(842, 210, 60, 40);
				change.add(btnNewButton_6);

				change.repaint();
			}
		});

		// 课程管理
		courseMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change.removeAll();
				now = "查看课程表";
				NowLocat();
				// 初始化数据
				final List<Teacher> teaList = teadao.findAllTeacher();
				final List<Subject> subList = subDao.findAllSubject();
				final List<Major> majList = majorDao.findAllMajor();
				final List<Grade> gradeList = gradeDao.findAllGrade();

				String[] teas = new String[teaList.size()];
				String[] subs = new String[subList.size()];
				String[] majs = new String[majList.size()];
				String[] grades = new String[gradeList.size()];
				for (int i = 0; i < teaList.size(); i++) {
					teas[i] = teaList.get(i).getName();
				}
				for (int j = 0; j < subList.size(); j++) {
					subs[j] = subList.get(j).getName();
				}
				for (int k = 0; k < majList.size(); k++) {
					majs[k] = majList.get(k).getName();
				}
				for (int l = 0; l < gradeList.size(); l++) {
					grades[l] = gradeList.get(l).getName();
				}

				table = new JTable();
				table.setModel(new DefaultTableModel(null, new String[] { "时间",
						"周一", "周二", "周三", "周四", "周五", "周六", "周日" }) {
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
						BorderFactory.createEtchedBorder(null, null), "课表信息");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);
				change.add(paneltable);

				final JComboBox<Object> majbox2 = new JComboBox<Object>();
				majbox2.setBounds(241, 0, 63, 21);
				majbox2.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						majs));
				change.add(majbox2);

				JLabel label_2 = new JLabel("专业:");
				label_2.setBounds(202, 0, 41, 23);
				change.add(label_2);

				JLabel label_3 = new JLabel("年级:");
				label_3.setBounds(310, 0, 35, 23);
				change.add(label_3);

				final JComboBox<Object> gradebox2 = new JComboBox<Object>();
				gradebox2.setBounds(346, 0, 60, 21);
				gradebox2
						.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
								grades));
				change.add(gradebox2);

				JLabel label_4 = new JLabel("班级:");
				label_4.setBounds(409, 0, 35, 23);
				change.add(label_4);

				final JComboBox<Object> classno2 = new JComboBox<Object>();
				classno2.setBounds(448, 0, 48, 21);
				classno2.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						new Object[] { "", "1", "2", "3", "4", "5", "6", "7",
								"8" }));
				change.add(classno2);

				JLabel label_5 = new JLabel("老师:");
				label_5.setBounds(626, 0, 35, 23);
				change.add(label_5);

				final JComboBox<Object> teabox = new JComboBox<Object>();
				teabox.setBounds(667, 0, 89, 21);
				teabox.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						teas));
				change.add(teabox);

				final JButton btndelete = new JButton("删除");
				btndelete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定删除此课程表?", "确认删除",
								JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							// 删除课表中某节课
							int rowindex = table.getSelectedRow();// 选中列
							int columnindex = table.getSelectedColumn();// 选择的列
							Grade grade = gradeList.get(gradebox2
									.getSelectedIndex());
							Major major = majList.get(majbox2
									.getSelectedIndex());
							int classno = classno2.getSelectedIndex();
							if (courseDao.deleteCourse(grade.getId(),
									major.getId(), classno, columnindex,
									rowindex + 1)) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"删除成功！");
								table.setValueAt(null, rowindex, columnindex);// 手动将表格同步
							} else {
								JOptionPane.showMessageDialog(ManagerView.this,
										"删除失败！");
							}

						}
					}
				});
				btndelete.setBounds(850, 199, 60, 40);
				change.add(btndelete);

				//
				JLabel roomlab = new JLabel("教室:");
				roomlab.setBounds(210, 384, 35, 23);
				change.add(roomlab);

				final JTextField roomInput = new JTextField();
				roomInput.setBounds(250, 384, 75, 22);
				change.add(roomInput);

				JLabel timeLabel = new JLabel("时间:");
				timeLabel.setBounds(330, 384, 35, 23);
				change.add(timeLabel);

				final JTextField timeInput = new JTextField();
				timeInput.setBounds(380, 384, 110, 22);
				change.add(timeInput);

				JLabel sublabel = new JLabel("科目:");
				sublabel.setBounds(500, 384, 35, 23);
				change.add(sublabel);

				final JComboBox<Object> subbox4 = new JComboBox<Object>();
				subbox4.setBounds(540, 384, 110, 21);
				subbox4.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						subs));
				change.add(subbox4);

				JLabel label_9 = new JLabel("老师:");
				label_9.setBounds(690, 387, 35, 23);
				change.add(label_9);

				final JComboBox<Object> teabox3 = new JComboBox<Object>();
				teabox3.setBounds(730, 384, 89, 21);
				teabox3.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						teas));
				change.add(teabox3);

				// 清空某个版的全部课程
				final JButton btnClear = new JButton("清空");
				btnClear.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Grade grade = gradeList.get(gradebox2
								.getSelectedIndex());
						Major major = majList.get(majbox2.getSelectedIndex());
						int classno = classno2.getSelectedIndex();
						if (courseDao.deleteCourseByClass(grade.getId(),
								major.getId(), classno)) {
							table.setModel(new DefaultTableModel(
									new Object[][] {

											{ "8:30-10:05", null, null, null,
													null, null, null, null },
											{ "10:30-12:00", null, null, null,
													null, null, null, null },
											{ "2:40-4:15", null, null, null,
													null, null, null, null },
											{ "4:30-6:05", null, null, null,
													null, null, null, null },
											{ "6:30-8:05", null, null, null,
													null, null, null, null },
											{ "8:20-9:50", null, null, null,
													null, null, null, null } },
									new String[] { "时间", "周一", "周二", "周三",
											"周四", "周五", "周六", "周日" }) {
								/**
										 * 
										 */
								private static final long serialVersionUID = 1L;
								boolean[] columnEditables = new boolean[] {
										false, false, false, false, false,
										false, false, false };

								public boolean isCellEditable(int row,
										int column) {
									return columnEditables[column];
								}
							});
						} else {
							JOptionPane.showMessageDialog(ManagerView.this,
									"清空失败！");
						}
					}
				});
				btnClear.setBounds(850, 123, 60, 40);
				change.add(btnClear);
				// 添加课程
				final JButton btnAdd = new JButton("添加");
				btnAdd.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定添加此课程表?", "确认添加",
								JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							// 按老师添加的
							// 添加课程表方法
							int rowindex = table.getSelectedRow();// 选中列
							int columnindex = table.getSelectedColumn();// 选择的列
							Grade grade = gradeList.get(gradebox2
									.getSelectedIndex());
							Major major = majList.get(majbox2
									.getSelectedIndex());
							int classno = classno2.getSelectedIndex();
							Teacher tea = teaList.get(teabox3
									.getSelectedIndex());
							Subject sub = subList.get(subbox4
									.getSelectedIndex());
							Course cou = new Course();
							cou.setGrade(grade);
							cou.setClassno(classno);
							cou.setMajor(major);
							cou.setTea(tea);
							cou.setSub(sub);

							if (timeInput.getText() == null
									|| timeInput.getText().length() == 0) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"请添加上课周！");
								return;
							}
							cou.setWeek(timeInput.getText());
							if (roomInput.getText() == null
									|| roomInput.getText().length() == 0) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"请添加上课教教室！");
								return;
							}
							cou.setRoom(roomInput.getText());
							cou.setWeekday(columnindex);
							cou.setTimepoint(rowindex + 1);

							if (rootbiz.addCourse(cou)) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"添加成功！");
								table.setValueAt(
										sub.getName() + "-"
												+ roomInput.getText() + "-"
												+ timeInput.getText(),
										rowindex, columnindex);
							} else {
								JOptionPane.showMessageDialog(ManagerView.this,
										"添加失败！");
							}

						}
					}
				});
				btnAdd.setBounds(840, 382, 70, 23);
				change.add(btnAdd);
				JButton btnNewButton_1 = new JButton("查询");
				btnNewButton_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// 添加班级查询方法
						btnAdd.setEnabled(true);
						btndelete.setEnabled(true);
						btnClear.setEnabled(true);
						Grade grade = gradeList.get(gradebox2
								.getSelectedIndex());
						Major major = majList.get(majbox2.getSelectedIndex());
						int classno = classno2.getSelectedIndex();
						List<Course> couList = courseDao.findCouseByClass(
								grade.getId(), major.getId(), classno);
						if (couList.size() > 0) {
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
								cous[y][x] = cou.getSub().getName() + " "
										+ cou.getRoom() + " " + cou.getWeek()
										+ " " + cou.getTea().getName();
							}

							table.setModel(new DefaultTableModel(cous,
									new String[] { "时间", "周一", "周二", "周三",
											"周四", "周五", "周六", "周日" }) {

								private static final long serialVersionUID = 1L;
								boolean[] columnEditables = new boolean[] {
										false, false, false, false, false,
										false, false, false };

								public boolean isCellEditable(int row,
										int column) {
									return columnEditables[column];
								}
							});
						} else {
							JOptionPane.showMessageDialog(ManagerView.this,
									"暂无课表信息，请先添加");
							Object[][] cous = new Object[6][8];
							cous[0][0] = "8:30-10:05";
							cous[1][0] = "10:30-12:00";
							cous[2][0] = "2:40-4:15";
							cous[3][0] = "4:30-6:05";
							cous[4][0] = "6:30-8:00";
							cous[5][0] = "8:10-9:30";
							table.setModel(new DefaultTableModel(cous,
									new String[] { "时间", "周一", "周二", "周三",
											"周四", "周五", "周六", "周日" }) {

								private static final long serialVersionUID = 1L;
								boolean[] columnEditables = new boolean[] {
										false, false, false, false, false,
										false, false, false };

								public boolean isCellEditable(int row,
										int column) {
									return columnEditables[column];
								}
							});
						}

					}
				});

				btnNewButton_1.setBounds(515, 0, 63, 23);
				change.add(btnNewButton_1);
				// 按照教师进行查询
				JButton btnqueryByteacher = new JButton("查询");
				btnqueryByteacher.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 按教师查询
						btnAdd.setEnabled(false);
						btndelete.setEnabled(false);
						btnClear.setEnabled(false);
						Teacher tea = teaList.get(teabox.getSelectedIndex());
						List<Course> couList = courseDao.findCouseByTea(tea
								.getId());
						if (couList.size() > 0) {
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
								cous[y][x] = cou.getSub().getName() + " "
										+ cou.getRoom() + " "
										+ cou.getTea().getName();
							}

							table.setModel(new DefaultTableModel(cous,
									new String[] { "时间", "周一", "周二", "周三",
											"周四", "周五", "周六", "周日" }) {

								private static final long serialVersionUID = 1L;
								boolean[] columnEditables = new boolean[] {
										false, false, false, false, false,
										false, false, false };

								public boolean isCellEditable(int row,
										int column) {
									return columnEditables[column];
								}
							});
						} else {
							JOptionPane.showMessageDialog(ManagerView.this,
									"暂无课表信息，请先添加");
						}

					}
				});
				btnqueryByteacher.setBounds(768, 0, 60, 23);
				change.add(btnqueryByteacher);

				change.repaint();
			}
		});

		// 学生管理
		stuMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change.removeAll();
				now = "查看学生信息";
				NowLocat();
				// 初始化数据
				final List<Major> majList = majorDao.findAllMajor();
				final List<Grade> gradeList = gradeDao.findAllGrade();

				String[] majs = new String[majList.size() + 1];
				String[] grades = new String[gradeList.size() + 1];
				majs[0] = " ";
				for (int k = 0; k < majList.size(); k++) {
					majs[k + 1] = majList.get(k).getName();
				}
				grades[0] = " ";
				for (int l = 0; l < gradeList.size(); l++) {
					grades[l + 1] = gradeList.get(l).getName();
				}
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btnNewButton_3.setEnabled(true);
						btnNewButton_5.setEnabled(true);
					}
				});
				table.setModel(new DefaultTableModel(null, new String[] { "学号",
						"名字", "电话", "家庭地址", "宿舍号", "专业", "年级", "班级" }) {
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
						BorderFactory.createEtchedBorder(null, null), "学生信息");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);
				change.add(paneltable);

				final JComboBox<Object> majbox = new JComboBox<Object>();
				majbox.setBounds(241, 0, 100, 21);
				majbox.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						majs));
				change.add(majbox);

				JLabel label_2 = new JLabel("专业:");
				label_2.setBounds(202, 0, 41, 23);
				change.add(label_2);

				JLabel label_3 = new JLabel("年级:");
				label_3.setBounds(330, 0, 35, 23);
				change.add(label_3);

				//
				final JComboBox<Object> gradebox = new JComboBox<Object>();
				gradebox.setBounds(370, 2, 60, 21);
				gradebox.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
						grades));
				change.add(gradebox);

				JLabel label_4 = new JLabel("班级:");
				label_4.setBounds(440, 0, 40, 23);
				change.add(label_4);

				// change.add(choice_2);

				final JComboBox<Object> classnobox = new JComboBox<Object>();
				classnobox.setBounds(490, 0, 48, 21);
				classnobox
						.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
								new Object[] { "", "1", "2", "3", "4", "5",
										"6", "7", "8" }));
				change.add(classnobox);

				// 修改学生信息
				btnNewButton_3 = new JButton("修改");
				btnNewButton_3.setEnabled(false);
				btnNewButton_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Student stu = null;
						int selectedrow = table.getSelectedRow();// 获得选取行
						int stuid = Integer.parseInt(table.getValueAt(
								selectedrow, 0).toString());// 获取学号
						stu = rootbiz.queryStu(stuid);
						if (stu != null) {
							UpdateStuView stuView = new UpdateStuView(stu);
							stuView.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(ManagerView.this,
									"无修改学生，请选择!");
						}
					}
				});
				btnNewButton_3.setBounds(842, 375, 70, 30);
				change.add(btnNewButton_3);

				// 查询学生
				JButton btnQuery = new JButton("查询");
				btnQuery.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// 查询学生
						List<Student> stuList = null;
						int gradeindex = gradebox.getSelectedIndex();
						int majorindex = majbox.getSelectedIndex();
						int classno = classnobox.getSelectedIndex();
						if (gradeindex != 0 && majorindex == 0 && classno == 0) {
							// 年级方式
							stuList = stuDao.findStudentByGrade(gradeList.get(
									gradeindex - 1).getId());
						} else if (gradeindex == 0 && majorindex != 0
								&& classno == 0) {
							// 专业方式
							stuList = stuDao.findStudentByMajor(majList.get(
									majorindex - 1).getId());
						} else if (gradeindex != 0 && majorindex != 0
								&& classno == 0) {
							// 年级加专业方式
							stuList = stuDao.findStudentByMG(
									gradeList.get(gradeindex - 1).getId(),
									majList.get(majorindex - 1).getId());
						} else if (gradeindex != 0 && majorindex != 0
								&& classno != 0) {
							// 班级方式
							stuList = stuDao.findStudentByMGC(
									gradeList.get(gradeindex - 1).getId(),
									majList.get(majorindex - 1).getId(),
									classno);
						} else {
							JOptionPane.showMessageDialog(ManagerView.this,
									"请选择正确的查询方式!");
							return;
						}
						// "学号", "名字", "电话", "家庭地址", "宿舍号", "专业",
						// "年级", "班级"
						Object[][] stus = new Object[stuList.size()][8];
						for (int i = 0; i < stuList.size(); i++) {
							Student stu = stuList.get(i);
							stus[i][0] = stu.getId();
							stus[i][1] = stu.getName();
							stus[i][2] = stu.getPhone();
							stus[i][3] = stu.getAddress();
							stus[i][4] = stu.getDormiting();
							stus[i][5] = stu.getMajor().getName();
							stus[i][6] = stu.getGrade().getName();
							stus[i][7] = stu.getClassno();
						}
						if (stuList.size() == 0) {
							JOptionPane.showMessageDialog(ManagerView.this,
									"暂无学生信息!");
							return;
						}
						// 向表格中设置数据
						table.setModel(new DefaultTableModel(stus,
								new String[] { "学号", "名字", "电话", "家庭地址", "宿舍号",
										"专业", "年级", "班级" }) {
							private static final long serialVersionUID = 1L;
							boolean[] columnEditables = new boolean[] { false,
									false, false, false, false, false, false,
									false };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
					}
				});
				btnQuery.setBounds(550, 0, 63, 23);
				change.add(btnQuery);

				// 删除学生
				btnNewButton_5 = new JButton("删除");
				btnNewButton_5.setEnabled(false);
				btnNewButton_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int selectedrow = table.getSelectedRow();// 获得选取行
						int stuid = Integer.parseInt(table.getValueAt(
								selectedrow, 0).toString());// 获取学号
						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定删除?", "确认删除", JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							if (rootbiz.deleteStudent(stuid)) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"删除成功!");
							} else {
								JOptionPane.showMessageDialog(ManagerView.this,
										"删除失败!");
							}
						}
					}
				});
				btnNewButton_5.setBounds(842, 300, 70, 30);
				change.add(btnNewButton_5);

				// 添加学生
				JButton btnNewButton_6 = new JButton("添加");
				btnNewButton_6.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						AddStuView as = new AddStuView();
						as.setVisible(true);

					}
				});
				btnNewButton_6.setBounds(842, 216, 70, 30);
				change.add(btnNewButton_6);
				change.repaint();
			}
		});

		// 教师管理
		teaMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change.removeAll();
				now = "查看教师信息";
				NowLocat();
				// 初始化教师信息
				final List<Teacher> teaList = teadao.findAllTeacher();
				Object[][] teas = new Object[teaList.size()][4];

				for (int i = 0; i < teaList.size(); i++) {
					Teacher tea = teaList.get(i);
					teas[i][0] = tea.getId();
					teas[i][1] = tea.getName();
					teas[i][2] = tea.getPhone();
					teas[i][3] = tea.getAddress();
				}
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 当选中时才可修改和删除
						btnNewButton_3.setEnabled(true);
						btnNewButton_5.setEnabled(true);
					}
				});
				table.setModel(new DefaultTableModel(teas, new String[] {
						"教工号", "名字", "电话", "家庭地址" }) {
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
						BorderFactory.createEtchedBorder(null, null), "教师信息");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);
				change.add(paneltable);

				btnNewButton_3 = new JButton("修改");
				btnNewButton_3.setEnabled(false);
				btnNewButton_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Teacher tea = teaList.get(table.getSelectedRow());
						UpdateTeaView upteaView = new UpdateTeaView(tea);
						upteaView.setVisible(true);

					}
				});
				btnNewButton_3.setBounds(842, 350, 70, 30);
				change.add(btnNewButton_3);

				// 删除教师
				btnNewButton_5 = new JButton("删除");
				btnNewButton_5.setEnabled(false);
				btnNewButton_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int selectedrow = table.getSelectedRow();// 获得选取行
						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定删除?", "确认删除", JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							int teaid = Integer.parseInt(table.getValueAt(
									selectedrow, 0).toString());
							if (rootbiz.deleteTeacher(teaid)) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"删除成功!");
							} else {
								JOptionPane.showMessageDialog(ManagerView.this,
										"删除失败!");
							}
						}

					}
				});
				btnNewButton_5.setBounds(842, 275, 70, 30);
				change.add(btnNewButton_5);

				// 添加教师
				JButton btnNewButton_6 = new JButton("添加");
				btnNewButton_6.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						AddTeaView addteaView = new AddTeaView();
						addteaView.setVisible(true);
					}
				});
				btnNewButton_6.setBounds(842, 200, 70, 30);
				change.add(btnNewButton_6);

				// 刷新
				JButton refreshbtn = new JButton("刷新");
				refreshbtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						final List<Teacher> teaList = teadao.findAllTeacher();
						Object[][] teas = new Object[teaList.size()][4];

						for (int i = 0; i < teaList.size(); i++) {
							Teacher tea = teaList.get(i);
							teas[i][0] = tea.getId();
							teas[i][1] = tea.getName();
							teas[i][2] = tea.getPhone();
							teas[i][3] = tea.getAddress();
						}
						table.setModel(new DefaultTableModel(teas,
								new String[] { "教工号", "名字", "电话", "家庭地址" }) {
							private static final long serialVersionUID = 1L;
							boolean[] columnEditables = new boolean[] { false,
									false, false, false };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
					}
				});
				refreshbtn.setBounds(842, 135, 70, 30);
				change.add(refreshbtn);
				change.repaint();
			}
		});

		// 科目管理
		subMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change.removeAll();
				now = "查看科目信息";
				NowLocat();
				// 初始化科目信息
				final List<Subject> subList = subDao.findAllSubject();
				Object[][] subs = new Object[subList.size()][3];
				for (int i = 0; i < subList.size(); i++) {
					Subject sub = subList.get(i);
					subs[i][0] = sub.getId();
					subs[i][1] = sub.getName();
					subs[i][2] = sub.getSubtime();
				}

				table = new JTable();

				table.setModel(new DefaultTableModel(subs, new String[] { "编号",
						"科目名称", "学时" }) {
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false,
							false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

				JPanel paneltable = new JPanel(new BorderLayout());
				paneltable.setBounds(0, 36, 835, 349);
				Border btable = BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(null, null), "科目");// 边框样式
				paneltable.setBorder(btable);//
				paneltable.add(new JScrollPane(table), BorderLayout.CENTER);
				change.add(paneltable);

				JLabel label_4 = new JLabel("所选编号:");
				label_4.setBounds(0, 381, 59, 23);
				change.add(label_4);

				textField_7 = new JTextField();
				textField_7.setEditable(false);
				textField_7.setBounds(60, 385, 213, 21);
				change.add(textField_7);
				textField_7.setColumns(10);

				JLabel label_5 = new JLabel("科目名称:");
				label_5.setBounds(275, 381, 59, 23);
				change.add(label_5);

				textField_8 = new JTextField();
				textField_8.setBounds(332, 382, 218, 21);
				change.add(textField_8);
				textField_8.setColumns(10);

				JLabel label_6 = new JLabel("学时：");
				label_6.setBounds(556, 381, 50, 23);
				change.add(label_6);

				textField_9 = new JTextField();
				textField_9.setBounds(613, 385, 222, 21);
				change.add(textField_9);
				textField_9.setColumns(10);

				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 选中时才可以删除和修改
						btnNewButton_3.setEnabled(true);
						btnNewButton_5.setEnabled(true);
						int row = table.getSelectedRow();
						// 想输入框中添加信息
						textField_7
								.setText(table.getValueAt(row, 0).toString());
						textField_8
								.setText(table.getValueAt(row, 1).toString());
						textField_9
								.setText(table.getValueAt(row, 2).toString());
					}
				});

				btnNewButton_3 = new JButton("修改");
				btnNewButton_3.setEnabled(false);
				btnNewButton_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定修改?", "确认修改科目", JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							// 想输入框中添加信息
							String name = textField_8.getText();
							int subtime = Integer.parseInt(textField_9
									.getText());
							int id = Integer.parseInt(textField_7.getText());
							Subject sub = new Subject(id, name, subtime);
							if (rootbiz.updateSubject(sub)) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"修改成功!");
							} else {
								JOptionPane.showMessageDialog(ManagerView.this,
										"修改失败!");
							}
						}

					}
				});
				btnNewButton_3.setBounds(842, 250, 70, 30);
				change.add(btnNewButton_3);

				btnNewButton_5 = new JButton("删除");
				btnNewButton_5.setEnabled(false);
				btnNewButton_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int selectedrow = table.getSelectedRow();// 获得选取行
						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定删除?", "确认删除", JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							int id = Integer.parseInt(table.getValueAt(
									selectedrow, 0).toString());
							if (rootbiz.delteSubject(id)) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"删除成功!");
							} else {
								JOptionPane.showMessageDialog(ManagerView.this,
										"删除失败!");
							}
						}
					}
				});
				btnNewButton_5.setBounds(842, 160, 70, 30);
				change.add(btnNewButton_5);

				JButton btnNewButton_6 = new JButton("添加");
				btnNewButton_6.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int flag = JOptionPane.showConfirmDialog(null,
								"是否确定添加?", "确认添加科目", JOptionPane.YES_NO_OPTION);
						if (flag == JOptionPane.YES_OPTION) {
							// 想输入框中添加信息
							String name = textField_8.getText();
							int subtime = Integer.parseInt(textField_9
									.getText());
							int id = Integer.parseInt(textField_7.getText());
							Subject sub = new Subject(id, name, subtime);
							if (rootbiz.addSubject(sub)) {
								JOptionPane.showMessageDialog(ManagerView.this,
										"添加成功!");
							} else {
								JOptionPane.showMessageDialog(ManagerView.this,
										"添加失败!");
							}
						}
					}
				});
				btnNewButton_6.setBounds(842, 70, 70, 30);
				change.add(btnNewButton_6);

				JButton refreshbtn = new JButton("刷新");
				refreshbtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						final List<Subject> subList2 = subDao.findAllSubject();
						Object[][] subs2 = new Object[subList2.size()][3];
						for (int i = 0; i < subList2.size(); i++) {
							Subject sub = subList2.get(i);
							subs2[i][0] = sub.getId();
							subs2[i][1] = sub.getName();
							subs2[i][2] = sub.getSubtime();
						}

						table.setModel(new DefaultTableModel(subs2,
								new String[] { "编号", "科目名称", "学时" }) {
							private static final long serialVersionUID = 1L;
							boolean[] columnEditables = new boolean[] { false,
									false, false };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
					}
				});
				refreshbtn.setBounds(842, 340, 70, 30);
				change.add(refreshbtn);
				change.repaint();

			}
		});

		// 更换密码
		changePswMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagerChangePswView mcpv = new ManagerChangePswView(root);
				mcpv.setVisible(true);
			}
		});

		// 退出
		exitMenu.addMouseListener(new MouseAdapter() {
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
