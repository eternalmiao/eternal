package cn.test;

import java.util.List;

import org.junit.Test;

import cn.bean.Collage;
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
import cn.dao.impl.CollageDaoImpl;
import cn.dao.impl.CommandDaoImpl;
import cn.dao.impl.CourseDaoImpl;
import cn.dao.impl.GradeDaoImpl;
import cn.dao.impl.MajorDaoImpl;
import cn.dao.impl.NoticeDaoImpl;
import cn.dao.impl.ResultDaoImpl;
import cn.dao.impl.RootDaoImpl;
import cn.dao.impl.StudentDaoImpl;
import cn.dao.impl.SubjectDaoImpl;

public class Demo {
	@Test
	public void test01() {
		RootDaoImpl rootImpl = new RootDaoImpl();
		Root r = rootImpl.findRoot("admin");
		System.out.println(r.getName() + "//" + r.getPassword());
	}

	@Test
	public void test02() {
		CollageDaoImpl cpl = new CollageDaoImpl();
		// cpl.addCollage(new Collage(0, "计算机"));
		// Collage col = cpl.findCollage(2);
		// col.setName("外国语");
		// cpl.updateCollage(col);
		// cpl.deleteCollage(2);
		List<Collage> cols = cpl.findAllCollage();
		for (Collage collage : cols) {
			System.out.println(collage.getName());
		}

	}

	@Test
	public void test03() {
		CommandDaoImpl compl = new CommandDaoImpl();
		Student stu = new Student();
		stu.setId(1);
		Teacher tea = new Teacher();
		tea.setId(1);
		Subject sub = new Subject();
		sub.setId(1);
		// Command comm = new Command(1, stu, sub, tea, "这老师满分", 5);
		// compl.addCommand(comm);
		List<Command> comms = compl.findCommandByTeaAndSub(1, 1);
		for (Command command : comms) {
			System.out.println(command.getStu().getName() + "-"
					+ command.getSub().getName() + "-" + command.getCom());
		}
	}
	@Test
	public void test04() {
		CourseDaoImpl coupl = new CourseDaoImpl();
		 List<Course> cous = coupl.findCouseByStu(new StudentDaoImpl().findStudent(1));
		 System.out.println(cous.size());
		
	}
	@Test
	public void test05() {
		GradeDaoImpl gpl = new GradeDaoImpl();
		List<Grade> gs = gpl.findAllGrade();
		for (Grade grade : gs) {
			System.out.println(grade.getName());
		}
		Grade g = gpl.findGrade(2);
		System.out.println(g.getName());
	}
	@Test
	public void test06() {
		MajorDaoImpl mpl = new MajorDaoImpl();
		
		System.out.println(mpl.findMajor(1).getName());
		List<Major> ms = mpl.findAllMajor();
		for (Major major : ms) {
			System.out.println(major.getName()+"-"+major.getCollage().getName());
		}
		
	}
	@Test
	public void test07() {
		NoticeDaoImpl npl = new NoticeDaoImpl();
		Notice n = npl.findNotice();
		System.out.println(n.getStucontent()+"-"+n.getTeacontent());
	}
	@Test
	public void test08() {
	
		

	}
	@Test
	public void test09() {
		StudentDaoImpl spl = new StudentDaoImpl();
//		spl.addStudent(new Student(2, "呵呵", "1232132132", "000000", "gd", "xisi", new Major(1, "", new Collage()), new Grade(1,""), 3));
		System.out.println(spl.findStudent(1).getName());
		System.out.println(spl.findStudentByGrade(3).get(0).getDormiting());
		System.out.println(spl.findStudentByMajor(1).get(0).getPhone());
		System.out.println(spl.findStudentByMG(3, 1));
		System.out.println(spl.findStudentByMGC(1, 1, 3));
		

	}
	@Test
	public void test10() {
		SubjectDaoImpl subpl = new SubjectDaoImpl();
		System.out.println(subpl.findSubject(1).getName());
		List<Subject> subs = subpl.findAllSubject();
		for (Subject subject : subs) {
			System.out.println(subject.getName());
		}
	}
	@Test
	public void test11() {
		ResultDaoImpl respl = new ResultDaoImpl();
//		Result res = new Result();
//		res.setStu(new StudentDaoImpl().findStudent(1));
//		res.setTea(new TeacherDaoImpl().findTeacher(1));
//		res.setSub(new SubjectDaoImpl().findSubject(1));
//		res.setScore(89);
//		res.setTime("四月二十");
//		respl.addResult(res);
		List<Result> ress = respl.findResultByStu(1);
		for (Result result : ress) {
			System.out.println(result.getScore());
		}
		List<Result> ress1 = respl.findResultByTeaAndSub(1, 1);
		for (Result result : ress1) {
			System.out.println(result.getScore());
		}
	}
}
