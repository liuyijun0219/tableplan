package LSchedule.tableplanning.model;

import java.util.List;

public class Lession {
	
	private String type;
	
	private  Teacher teacher;
	
	private  List<Student> students;
	
	private  TimeSpan lessionTime;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public TimeSpan getLessionTime() {
		return lessionTime;
	}

	public void setLessionTime(TimeSpan lessionTime) {
		this.lessionTime = lessionTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
