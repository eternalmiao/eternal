package cn.biz.impl;

import java.util.List;

import cn.bean.Command;
import cn.bean.Course;
import cn.bean.Notice;
import cn.bean.Result;
import cn.bean.Subject;
import cn.bean.Teacher;
import cn.biz.TeacherBiz;
import cn.dao.CommandDao;
import cn.dao.CourseDao;
import cn.dao.NoticeDao;
import cn.dao.ResultDao;
import cn.dao.TeacherDao;
import cn.dao.impl.CommandDaoImpl;
import cn.dao.impl.CourseDaoImpl;
import cn.dao.impl.NoticeDaoImpl;
import cn.dao.impl.ResultDaoImpl;
import cn.dao.impl.TeacherDaoImpl;

public class TeacherBizImpl implements TeacherBiz {
	private NoticeDao noticeDao;
	private ResultDao resDao;
	private CourseDao courseDao;
	private CommandDao commDao;
	private TeacherDao teaDao;

	public TeacherBizImpl() {
		super();
		noticeDao = new NoticeDaoImpl();
		resDao = new ResultDaoImpl();
		courseDao = new CourseDaoImpl();
		commDao = new CommandDaoImpl();
		teaDao = new TeacherDaoImpl();
	}

	@Override
	public Teacher login(int id, String psw) {
		Teacher tea = teaDao.findTeacher(id);
		if (tea == null) {
			return null;
		} else if (tea.getPassword().equals(psw)) {
			return tea;
		} else {
			return null;
		}
	}

	@Override
	public String lookNtice() {
		Notice notice = noticeDao.findNotice();
		return notice.getTeacontent();
	}

	@Override
	public List<Course> queryCourse(Teacher tea) {
		List<Course> cous = courseDao.findCouseByTea(tea.getId());
		return cous;
	}

	@Override
	public List<Command> queryCommand(Teacher tea, Subject sub) {
		List<Command> comms = commDao.findCommandByTeaAndSub(tea.getId(),
				sub.getId());
		return comms;
	}

	@Override
	public boolean addResult(Result res) {

		Result nres = resDao.checkResult(res.getStu().getId(), res.getSub()
				.getId());
		//校验成绩，已存在则无法继续添加
		if (nres != null) {
			return false;
		} else {
			return resDao.addResult(res);
		}
	}

	@Override
	public boolean addAllResult(List<Result> ress) {
		boolean isSuecceed = true;
		for (int i = 0; i < ress.size(); i++) {
			if (!addResult(ress.get(i))) {
				isSuecceed = false;
				break;
			}
		}
		return isSuecceed;
	}

	@Override
	public boolean changePsw(Teacher tea) {

		return teaDao.UpdateTeacher(tea);
	}

	@Override
	public List<Result> queryResult(Teacher tea, Subject sub) {
		List<Result> ress = resDao.findResultByTeaAndSub(tea.getId(),
				sub.getId());
		return ress;
	}

}
