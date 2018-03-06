package LSchedule.tableplanning.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import LSchedule.tableplanning.model.Student;
import LSchedule.tableplanning.model.Table;
import LSchedule.tableplanning.model.Teacher;
import LSchedule.tableplanning.model.TimeSpan;

public class PlanningService {

	public List<Student> students = new ArrayList<Student>();

	public List<Teacher> teachers = new ArrayList<Teacher>();

	public Map<String, List<Teacher>> teachersMap = new HashMap<String, List<Teacher>>();

	public Table planTable(Student stu, TimeSpan timeSpan, String lessionType) {

		Teacher teacher = selectTeacher(stu, lessionType);
		if(teacher == null) {
			return null;
		}
		for (Calendar i = timeSpan.getStartTime(); i.before(timeSpan.getEndTime()); i.add(Calendar.DAY_OF_MONTH, +1)) {
			Calendar startHour = Calendar.getInstance();
			startHour.setTime(i.getTime());
			startHour.set(Calendar.HOUR_OF_DAY, 8);
			Calendar endHour = Calendar.getInstance();
			endHour.setTime(i.getTime());
			startHour.set(Calendar.HOUR_OF_DAY, 10);
			for(;startHour.after();) {
				
			}
			
			
		}

		return null;
	}

	private Teacher selectTeacher(Student stu, String lessionType) {
		if (stu.getFormerTeacher() != null && stu.getFormerTeacher().containsKey(lessionType)) {
			Teacher teacher = stu.getFormerTeacher().get(lessionType);
			if(teachers.contains(teacher)) {
				return teacher;
			}
		}
		if (!teachersMap.containsKey(lessionType)) {
			return null;
		}
		List<Teacher> teachers = teachersMap.get(lessionType);
		if (teachers.isEmpty()) {
			return null;
		}
		
		return teachers.get(getRandom(teachers.size()));
	}
	
	private int getRandom(int t) {
		
		Random rand = new Random();
		return rand.nextInt(t);
		
	}

}
