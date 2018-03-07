package LSchedule.tableplanning.model;

import java.util.Calendar;

public class TimeSpan {

	public TimeSpan() {

	}

	public TimeSpan(Calendar startTime, Calendar endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	private Calendar startTime;

	private Calendar endTime;

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public boolean isContains(Calendar temp) {
		if (temp.before(endTime) && temp.after(startTime)) {
			return true;
		} else {
			return false;
		}
	}
	
	//获取两个时间段最晚的时间
	public Calendar getLastTime(TimeSpan planSpan) {
		if (planSpan.getStartTime().before(endTime) && planSpan.getStartTime().after(startTime)) {
			return endTime;
		} else if(planSpan.getEndTime().before(endTime) && planSpan.getEndTime().after(startTime)) {
			return endTime;
		} else if(planSpan.getStartTime().after(startTime) &&  planSpan.getEndTime().before(endTime)) {
			return endTime;
		} else
			return null;
	}

}
