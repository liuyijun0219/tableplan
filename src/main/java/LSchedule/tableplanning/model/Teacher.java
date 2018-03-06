package LSchedule.tableplanning.model;

import java.util.List;

public class Teacher {
	
	private String name;
	
	private int fee;
	
	private int lessionTime;
	
	private String lessionType;
	


	//无法上课
	private List<TimeSpan> specialTime;

	//老师类型
	private String tag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getLessionTime() {
		return lessionTime;
	}

	public void setLessionTime(int lessionTime) {
		this.lessionTime = lessionTime;
	}

	public List<TimeSpan> getSpecialTime() {
		return specialTime;
	}

	public void setSpecialTime(List<TimeSpan> specialTime) {
		this.specialTime = specialTime;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	public String getLessionType() {
		return lessionType;
	}

	public void setLessionType(String lessionType) {
		this.lessionType = lessionType;
	}
	
}
