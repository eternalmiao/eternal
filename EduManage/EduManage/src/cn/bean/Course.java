package cn.bean;

public class Course {
	private int id;
	private Subject sub;
	private Teacher tea;
	private Grade grade;
	private Major major;
	private int classno;

	private String week;
	private String room;
	private int weekday;
	private int timepoint;

	public Course(int id, Subject sub, Teacher tea, Grade grade, Major major,
			int classno, String week, String room, int weekday, int timepoint) {
		super();
		this.id = id;
		this.sub = sub;
		this.tea = tea;
		this.grade = grade;
		this.major = major;
		this.classno = classno;
		this.week = week;
		this.room = room;
		this.weekday = weekday;
		this.timepoint = timepoint;
	}

	public int getWeekday() {
		return weekday;
	}

	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}

	public Course() {
		super();
	}

	public int getTimepoint() {
		return timepoint;
	}

	public void setTimepoint(int timepoint) {
		this.timepoint = timepoint;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

}
