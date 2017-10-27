package cn.view;

import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import cn.biz.StudentBiz;
import cn.biz.impl.StudentBizImpl;

public class StuCommandView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4567044627704783566L;
	private JPanel contentPane;
	private JTextField subject;
	private JTextField teacher;
	private JTextField comment;
	@SuppressWarnings("rawtypes")
	private JComboBox liked;
	private StudentBiz stuBiz;
	private Student stu;
	private Result result;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public StuCommandView(Student stu, Result result) throws HeadlessException {
		super();
		stuBiz = new StudentBizImpl();
		this.stu = stu;
		this.result = result;
		initView();
		initListener();
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initView() {
		setTitle("请输入你的评论内容");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("科目：");
		label.setBounds(10, 10, 43, 40);
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("授课老师：");
		lblNewLabel.setBounds(207, 5, 69, 50);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("满意程度（1-5）：");
		lblNewLabel_1.setBounds(10, 60, 117, 50);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("评论内容：");
		lblNewLabel_2.setBounds(10, 102, 69, 50);
		contentPane.add(lblNewLabel_2);

		btnNewButton = new JButton("确定");

		btnNewButton.setBounds(85, 229, 93, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("取消");

		btnNewButton_1.setBounds(247, 229, 93, 23);
		contentPane.add(btnNewButton_1);
		subject = new JTextField();
		subject.setEditable(false);
		subject.setText(result.getSub().getName());
		subject.setBounds(61, 20, 117, 21);
		contentPane.add(subject);
		subject.setColumns(10);

		teacher = new JTextField();
		teacher.setEditable(false);
		teacher.setBounds(274, 20, 150, 21);
		teacher.setText(result.getTea().getName());
		contentPane.add(teacher);
		teacher.setColumns(10);

		comment = new JTextField();
		comment.setBounds(83, 120, 341, 99);
		contentPane.add(comment);
		comment.setColumns(10);

		liked = new JComboBox();
		liked.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2",
				"3", "4", "5" }));
		liked.setBounds(137, 75, 41, 21);
		contentPane.add(liked);

	}

	private void initListener() {

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultComboBoxModel likedModel = (DefaultComboBoxModel) liked
						.getModel();
				String li = (String) likedModel.getSelectedItem();
				if (li.equals("")) {
					JOptionPane.showMessageDialog(StuCommandView.this,
							"满意程度不能为空!");
				} else if (comment.getText().equals("")) {
					JOptionPane.showMessageDialog(StuCommandView.this,
							"评论内容不能为空!");
				} else {
					// 评论
					int num = liked.getSelectedIndex();
					String comm = comment.getText();
					if (stuBiz.commandTeacher(comm, result, num)) {
						JOptionPane.showMessageDialog(StuCommandView.this,
								"评论完成!");
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(StuCommandView.this,
								"评论失败!");
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
