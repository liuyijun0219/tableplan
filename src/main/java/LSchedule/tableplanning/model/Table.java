package LSchedule.tableplanning.model;

import java.util.Map;

public class Table {
	
	private Student student;
	
	private Map<String,Lession> lessionMap;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Map<String, Lession> getLessionMap() {
		return lessionMap;
	}

	public void setLessionMap(Map<String, Lession> lessionMap) {
		this.lessionMap = lessionMap;
	}
	
	

}
