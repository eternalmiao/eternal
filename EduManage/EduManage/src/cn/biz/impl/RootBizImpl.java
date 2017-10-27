package cn.biz.impl;

import java.util.List;

import cn.bean.Command;
import cn.bean.Course;
import cn.bean.Notice;
import cn.bean.Result;
import cn.bean.Root;
import cn.bean.Student;
import cn.bean.Subject;
import cn.bean.Teacher;
import cn.biz.RootBiz;
import cn.dao.CommandDao;
import cn.dao.CourseDao;
import cn.dao.NoticeDao;
import cn.dao.ResultDao;
import cn.dao.RootDao;
import cn.dao.StudentDao;
import cn.dao.SubjectDao;
import cn.dao.TeacherDao;
import cn.dao.impl.CommandDaoImpl;
import cn.dao.impl.CourseDaoImpl;
import cn.dao.impl.NoticeDaoImpl;
import cn.dao.impl.ResultDaoImpl;
import cn.dao.impl.RootDaoImpl;
import cn.dao.impl.StudentDaoImpl;
import cn.dao.impl.SubjectDaoImpl;
import cn.dao.impl.TeacherDaoImpl;

public class RootBizImpl implements RootBiz {
	private RootDao rootDao;
	private StudentDao stuDao;
	private NoticeDao noticeDao;
	private ResultDao resDao;
	private CourseDao courseDao;
	private CommandDao commDao;
	private TeacherDao teaDao;
	private SubjectDao subDao;

	public RootBizImpl() {
		super();
		stuDao = new StudentDaoImpl();
		noticeDao = new NoticeDaoImpl();
		resDao = new ResultDaoImpl();
		courseDao = new CourseDaoImpl();
		commDao = new CommandDaoImpl();
		rootDao = new RootDaoImpl();
		teaDao = new TeacherDaoImpl();
		subDao = new SubjectDaoImpl();
	}

	@Override
	public Root login(String name, String psw) {
		Root root = rootDao.findRoot(name);
		if (root == null) {
			return null;
		} else if (root.getPassword().equals(psw)) {
			return root;
		} else {
			return null;
		}
	}

	@Override
	public boolean addNotice(Notice notice) {

		return noticeDao.updateNotice(notice);
	}

	@Override
	public boolean addStudent(Student stu) {
		return stuDao.addStudent(stu);
	}

	@Override
	public boolean addAllStudent(List<Student> stus) {
		boolean isSucceed = true;
		for (int i = 0; i < stus.size(); i++) {
			if (!addStudent(stus.get(i))) {
				isSucceed = false;
				break;
			}
		}
		return isSucceed;
	}

	@Override
	public boolean updateStudent(Student stu) {

		return stuDao.updateStudent(stu);
	}

	@Override
	public boolean updateAllStudent(List<Student> stus) {
		boolean isSucceed = true;
		for (int i = 0; i < stus.size(); i++) {
			if (!updateStudent(stus.get(i))) {
				isSucceed = false;
				break;
			}
		}
		return isSucceed;
	}

	@Override
	public boolean deleteStudent(int id) {

		return stuDao.deleteStudent(id);
	}

	@Override
	public boolean deleteStudentByGrade(int gradeId) {

		return stuDao.deleteStudentByGrade(gradeId);
	}

	@Override
	public Student queryStu(int id) {

		return stuDao.findStudent(id);
	}

	@Override
	public List<Student> queryStuByGrade(int gradeid) {
		return stuDao.findStudentByGrade(gradeid);
	}

	@Override
	public List<Student> queryStuByGradeAndMajor(int gradeid, int majorid) {

		return stuDao.findStudentByMG(gradeid, majorid);
	}

	@Override
	public List<Student> queryStuByGradeAndMajorAndClassno(int gradeid,
			int majorid, int classno) {

		return stuDao.findStudentByMGC(gradeid, majorid, classno);
	}

	@Override
	public boolean addTeacher(Teacher tea) {

		return teaDao.addTeacher(tea);
	}

	@Override
	public boolean updateTeacher(Teacher tea) {
		// TODO Auto-generated method stub
		return teaDao.UpdateTeacher(tea);
	}

	@Override
	public boolean updateAllTeacher(List<Teacher> teas) {
		boolean isSucceed = true;
		for (int i = 0; i < teas.size(); i++) {
			if (!updateTeacher(teas.get(i))) {
				isSucceed = false;
				break;
			}
		}
		return isSucceed;
	}

	@Override
	public boolean deleteTeacher(int teaid) {
		// TODO Auto-generated method stub
		return teaDao.deleteTeacher(teaid);
	}

	@Override
	public Teacher queryTeacher(int id) {
		return teaDao.findTeacher(id);
	}

	@Override
	public List<Teacher> queryAllTeacher() {
		return teaDao.findAllTeacher();
	}

	@Override
	public boolean addSubject(Subject sub) {
		return subDao.addSubject(sub);
	}

	@Override
	public boolean updateSubject(Subject sub) {
		return subDao.updateSubject(sub);
	}

	@Override
	public boolean delteSubject(int subid) {
		return subDao.deleteSubject(subid);
	}

	@Override
	public Subject querySubject(int subid) {
		return subDao.findSubject(subid);
	}

	@Override
	public List<Subject> queryAllSubject() {
		return subDao.findAllSubject();
	}

	@Override
	public boolean addCourse(Course couse) {
		return courseDao.addCourse(couse);
	}

	@Override
	public boolean addAllCourse(List<Course> cous) {
		boolean isSucceed = true;
		for (int i = 0; i < cous.size(); i++) {
			if (!addCourse(cous.get(i))) {
				isSucceed = false;
				break;
			}
		}
		return isSucceed;
	}

	@Override
	public boolean deleteAllCourse() {

		return false;
	}

	@Override
	public List<Result> queryResultByTeaAndSub(int teaid, int subid) {

		return resDao.findResultByTeaAndSub(teaid, subid);
	}

	@Override
	public boolean updateResult(Result res) {
		return resDao.updateResult(res);
	}

	@Override
	public List<Command> queryCommand(int teaid, int subid) {
		return commDao.findCommandByTeaAndSub(teaid, subid);
	}

	@Override
	public boolean changePsw(Root root) {
		return rootDao.updateRoot(root);
	}

	@Override
	public Notice getNotice() {
		return noticeDao.findNotice();
	}

}
