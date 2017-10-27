package cn.biz.impl;

import java.util.List;

import cn.bean.Command;
import cn.bean.Course;
import cn.bean.Notice;
import cn.bean.Result;
import cn.bean.Student;
import cn.biz.StudentBiz;
import cn.dao.CommandDao;
import cn.dao.CourseDao;
import cn.dao.NoticeDao;
import cn.dao.ResultDao;
import cn.dao.StudentDao;
import cn.dao.impl.CommandDaoImpl;
import cn.dao.impl.CourseDaoImpl;
import cn.dao.impl.NoticeDaoImpl;
import cn.dao.impl.ResultDaoImpl;
import cn.dao.impl.StudentDaoImpl;

public class StudentBizImpl implements StudentBiz {
	private StudentDao stuDao;
	private NoticeDao noticeDao;
	private ResultDao resDao;
	private CourseDao courseDao;
	private CommandDao commDao;

	public StudentBizImpl() {
		super();
		stuDao = new StudentDaoImpl();
		noticeDao = new NoticeDaoImpl();
		resDao = new ResultDaoImpl();
		courseDao = new CourseDaoImpl();
		commDao = new CommandDaoImpl();
	}

	@Override
	public Student login(int id, String psw) {
		Student stu = stuDao.findStudent(id);
		if (stu == null ) {
			return null;
		} else if (stu.getPassword().equals(psw)) {
			return stu;
		}else {
			return null;
		}

	}

	@Override
	public String lookNotice() {
		Notice notice = noticeDao.findNotice();
		return notice.getStucontent();
	}

	@Override
	public List<Result> queryResult(Student stu) {
		List<Result> ress = resDao.findResultByStu(stu.getId());
		return ress;
	}

	@Override
	public List<Course> queryCourse(Student stu) {
		List<Course> cous = courseDao.findCouseByStu(stu);
		return cous;
	}

	@Override
	public boolean commandTeacher(String comm, Result res,int num) {
		Command command = new Command();
		command.setCom(comm);
		command.setStu(res.getStu());
		command.setTea(res.getTea());
		command.setSub(res.getSub());
		command.setNum(num);
		res.setIscomm(1);
		//将成绩表的iscomm设置成已评论状态
		if(!resDao.updateResult(res)){
			return false;
		}
		return commDao.addCommand(command);
	}

	@Override
	public boolean commandAll(List<String> comms, List<Result> ress,List<Integer> nums) {
		boolean isSucceed = true;
		for (int i = 0; i < comms.size(); i++) {
			boolean isSucc = commandTeacher(comms.get(i), ress.get(i), nums.get(i));
			//有一条评论失败时即退出循环
			if (!isSucc) {
				isSucceed = false;
				break;
			}
		}
		return isSucceed;
	}

	@Override
	public boolean changePsw(Student stu) {
		return stuDao.updateStudent(stu);
	}

}
