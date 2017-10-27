package cn.bean;

public class Result {
	private int id;
	private Student stu;
	private Subject sub;
	private Teacher tea;
	private double score;
	private String time;
	private int iscomm;
	public Result() {
		super();
	}
	
	public Result(int id, Student stu, Subject sub, Teacher tea, double score,
			String time, int iscomm) {
		super();
		this.id = id;
		this.stu = stu;
		this.sub = sub;
		this.tea = tea;
		this.score = score;
		this.time = time;
		this.iscomm = iscomm;
	}

	public int getIscomm() {
		return iscomm;
	}

	public void setIscomm(int iscomm) {
		this.iscomm = iscomm;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Subject getSub() {
		return sub;
	}
	public void setSub(Subject sub) {
		this.sub = sub;
	}
	public Teacher getTea() {
		return tea;
	}
	public void setTea(Teacher tea) {
		this.tea = tea;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
