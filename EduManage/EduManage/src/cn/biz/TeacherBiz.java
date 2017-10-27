package cn.biz;

import java.util.List;

import cn.bean.Command;
import cn.bean.Course;
import cn.bean.Result;
import cn.bean.Subject;
import cn.bean.Teacher;

public interface TeacherBiz {
	/**
	 * 教师登陆
	 * 
	 * @param id
	 *            工号
	 * @param psw
	 *            密码
	 * @return 成功返回该teacher对象
	 */
	public Teacher login(int id, String psw);

	/**
	 * 获取教师公告
	 * 
	 * @return 公告内容
	 */
	public String lookNtice();

	/**
	 * 查询教师课表
	 * 
	 * @param tea
	 *            传入教师对象
	 * @return
	 */
	public List<Course> queryCourse(Teacher tea);

	/**
	 * 查询评论
	 * 
	 * @param tea
	 *            教师对象
	 * @param sub
	 *            科目对象
	 * @return 返回评论集合
	 */

	public List<Command> queryCommand(Teacher tea, Subject sub);

	/**
	 * 添加成绩，单个添加
	 * 
	 * @param res
	 *            传入成绩对象
	 * @return
	 */
	public boolean addResult(Result res);

	/**
	 * 批量添加成绩
	 * 
	 * @param ress
	 *            成绩集合
	 * @return
	 */
	public boolean  addAllResult(List<Result> ress);
	/**
	 * 查看某一门成绩
	 * @param tea
	 * @param sub
	 * @return
	 */
	public List<Result> queryResult(Teacher tea,Subject sub);

	/**
	 * 更换密码
	 * 
	 * @param oldpsw
	 *            传入旧密码
	 * @return
	 */
	public boolean changePsw(Teacher tea);
}
