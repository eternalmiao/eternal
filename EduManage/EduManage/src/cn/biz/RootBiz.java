package cn.biz;

import java.util.List;

import cn.bean.Command;
import cn.bean.Course;
import cn.bean.Notice;
import cn.bean.Result;
import cn.bean.Root;
import cn.bean.Student;
import cn.bean.Subject;
import cn.bean.Teacher;

public interface RootBiz {
	/**
	 * 管理员登陆
	 * 
	 * @param name
	 *            用户名
	 * @param psw
	 *            密码
	 * @return 成功返回该root对象
	 */
	public Root login(String name, String psw);
	/**
	 * 获取公告
	 * @return
	 */
	public Notice getNotice();
	/**
	 * 发布公告
	 * 
	 * @param notice
	 *            公告对象
	 * @return
	 */

	public boolean addNotice(Notice notice);
	/**
	 * 更换密码
	 * @param root
	 * @return
	 */
	public boolean changePsw(Root root);
	/**
	 * 添加学生，单个添加
	 * 
	 * @param stu
	 *            单个学生对象
	 * @return
	 */

	public boolean addStudent(Student stu);

	/**
	 * 批量添加学生
	 * 
	 * @param stus
	 *            学生集合
	 * @return
	 */

	public boolean addAllStudent(List<Student> stus);

	/**
	 * 单个更新学生
	 * 
	 * @param stu
	 *            单个学生对象
	 * @return
	 */
	public boolean updateStudent(Student stu);

	/**
	 * 批量更新学生
	 * 
	 * @param stus
	 *            学生对象集合
	 * @return
	 */
	public boolean updateAllStudent(List<Student> stus);

	/**
	 * 删除学生
	 * 
	 * @param id
	 *            学号
	 * @return
	 */
	public boolean deleteStudent(int id);

	/**
	 * 批量删除学生
	 * 
	 * @param gradeId
	 * @return
	 */
	public boolean deleteStudentByGrade(int gradeId);

	/**
	 * 单个查询，通过学号
	 * 
	 * @param id
	 *            学号
	 * @return
	 */
	public Student queryStu(int id);

	/**
	 * 通过年级查询
	 * 
	 * @param gradeid
	 *            年级编号i
	 * @return
	 */
	public List<Student> queryStuByGrade(int gradeid);

	/**
	 * 通过年级和专业批量查询
	 * 
	 * @param gradeid
	 *            年级编号
	 * @param majorid
	 *            专业编号
	 * @return
	 */
	public List<Student> queryStuByGradeAndMajor(int gradeid, int majorid);

	/**
	 * 查询某个班学生
	 * 
	 * @param gradeid
	 *            年级号
	 * @param majorid
	 *            专业号
	 * @param classno
	 *            班级号
	 * @return
	 */
	public List<Student> queryStuByGradeAndMajorAndClassno(int gradeid,
			int majorid, int classno);

	/**
	 * 添加教师
	 * 
	 * @param tea
	 *            教师对象
	 * @return
	 */
	public boolean addTeacher(Teacher tea);

	/**
	 * 更新教师
	 * 
	 * @param tea
	 * @return
	 */
	public boolean updateTeacher(Teacher tea);

	/**
	 * 批量更新
	 * 
	 * @param teas
	 * @return
	 */
	public boolean updateAllTeacher(List<Teacher> teas);

	/**
	 * 删除教师
	 * 
	 * @param teaid
	 *            教师工号
	 * @return
	 */
	public boolean deleteTeacher(int teaid);

	/**
	 * 单个查询教师
	 * 
	 * @param id
	 *            教师工号
	 * @return
	 */

	public Teacher queryTeacher(int id);

	/**
	 * 查询全部教师
	 * 
	 * @return
	 */
	public List<Teacher> queryAllTeacher();

	/**
	 * 添加课程
	 * 
	 * @param sub
	 * @return
	 */
	public boolean addSubject(Subject sub);

	/**
	 * 更新课程
	 * 
	 * @param sub
	 * @return
	 */
	public boolean updateSubject(Subject sub);

	/**
	 * 删除课程
	 * 
	 * @param subid
	 * @return
	 */
	public boolean delteSubject(int subid);

	/**
	 * 单个查询课程
	 * 
	 * @param subid
	 * @return
	 */
	public Subject querySubject(int subid);

	/**
	 * 查询全部课程
	 * 
	 * @return
	 */
	public List<Subject> queryAllSubject();

	/**
	 * 添加课程上课安排，单个添加
	 * 
	 * @param couse
	 * @return
	 */
	public boolean addCourse(Course couse);

	/**
	 * 添加课程上课安排，批量添加
	 * 
	 * @param cous
	 * @return
	 */
	public boolean addAllCourse(List<Course> cous);

	/**
	 * 删除全部课程信息
	 * 
	 * @return
	 */
	public boolean deleteAllCourse();

	/**
	 * 查询某个教师某一门成绩
	 * 
	 * @param teaid
	 *            教师工号
	 * @param subid
	 *            科目编号
	 * @return
	 */
	public List<Result> queryResultByTeaAndSub(int teaid, int subid);
	/**
	 * 更改某个成绩
	 * @param id
	 * @return
	 */
	public boolean updateResult(Result res);

	/**
	 * 查询评论
	 * 
	 * @param tea
	 *            教师工号
	 * @param sub
	 *            科目编号
	 * @return 返回评论集合
	 */
	public List<Command> queryCommand(int teaid, int subid);

}
