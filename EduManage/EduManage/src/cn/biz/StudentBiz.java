package cn.biz;

import java.util.List;

import cn.bean.Course;
import cn.bean.Result;
import cn.bean.Student;

public interface StudentBiz {
	/**
	 * 学生登陆
	 * @param id 学号
	 * @param psw 密码
	 * @return 成功返回该用户，失败返回null
	 */
	public Student login(int id, String psw);

	/**
	 * 
	 * @return 登录后即显示公告，返回学生公告
	 */
	public String lookNotice();

	/**
	 * 查询成绩
	 * @param stu  传入学生对象
	 * @return 返回成绩集合
	 */
	public List<Result> queryResult(Student stu);
	
	/**
	 * 查询课表
	 * @param stu 传入学生对象
	 * @return 返回课程集合
	 */

	public List<Course> queryCourse(Student stu);

	/**
	 * 评论老师，单条评论
	 * @param comm 评论内容
	 * @param res 评论科目及老师
	 * @return 
	 */
	public boolean commandTeacher(String comm, Result res,int num);
	/**
	 * 多条评论
	 * @param comms 评论集合
	 * @param ress 科目及教师集合
	 * @return
	 */
	public boolean commandAll(List<String> comms,List<Result> ress,List<Integer> nums);
	/**
	 * 更换密码
	 * @param psw 传入旧密码
	 * @return 成功返回true
	 */
	
	public boolean changePsw(Student stu);
}
