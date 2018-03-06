package LSchedule.tableplanning.model;

import java.util.List;
import java.util.Map;

public class Student {
	
	private String name;
	
	private int balance;
	
	private List<TimeSpan> specialTimeSpans;
	
	private String payType;
	
	private List<String> lessionTypes;
	
	//key：lessiontype; value:Teacher
	private Map<String,Teacher> formerTeacher;
	
	

	public Map<String, Teacher> getFormerTeacher() {
		return formerTeacher;
	}

	public void setFormerTeacher(Map<String, Teacher> formerTeacher) {
		this.formerTeacher = formerTeacher;
	}

	public List<String> getLessionTypes() {
		return lessionTypes;
	}

	public void setLessionTypes(List<String> lessionTypes) {
		this.lessionTypes = lessionTypes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<TimeSpan> getSpecialTimeSpans() {
		return specialTimeSpans;
	}

	public void setSpecialTimeSpans(List<TimeSpan> specialTimeSpans) {
		this.specialTimeSpans = specialTimeSpans;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	

	
}
