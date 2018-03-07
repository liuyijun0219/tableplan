package LSchedule.tableplanning.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
	
	private Student student;
	
	private Map<String,List<Lession>> lessionMap = new HashMap<String, List<Lession>>();

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Map<String,List<Lession>> getLessionMap() {
		return lessionMap;
	}


	
	

}
