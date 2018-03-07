package LSchedule.tableplanning.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import LSchedule.tableplanning.model.Lession;
import LSchedule.tableplanning.model.Student;
import LSchedule.tableplanning.model.Table;
import LSchedule.tableplanning.model.Teacher;
import LSchedule.tableplanning.model.TimeSpan;

public class PlanningService {

	public List<Student> students = new ArrayList<Student>();

	public List<Teacher> teachers = new ArrayList<Teacher>();

	public Map<String, List<Teacher>> teachersMap = new HashMap<String, List<Teacher>>();
	

	// 1v1 老师和学生
	public Table planTable(Student stu, TimeSpan timeSpan, String lessionType) {
		Table table = new Table();

		Teacher teacher = selectTeacher(stu, lessionType);
		if (teacher == null) {
			return null;
		}
		List<TimeSpan> specialTime = new ArrayList<TimeSpan>();
		specialTime.addAll(stu.getSpecialTimeSpans());
		specialTime.addAll(teacher.getSpecialTime());
		List<Lession> lessions = new ArrayList<Lession>();
		for (Calendar i = timeSpan.getStartTime(); i.before(timeSpan.getEndTime()); i.add(Calendar.DAY_OF_MONTH, +1)) {
			Calendar startHour = Calendar.getInstance();
			startHour.setTime(i.getTime());
			startHour.set(Calendar.HOUR_OF_DAY, 8);
			Calendar endHour = Calendar.getInstance();
			endHour.setTime(i.getTime());
			startHour.set(Calendar.HOUR_OF_DAY, 20);
			for (; startHour.after(endHour); startHour.add(Calendar.HOUR_OF_DAY, +2)) {

				TimeSpan timespan = planLession(startHour);
				startHour = get(timespan, specialTime);
				if (!startHour.equals(timespan.getStartTime())) {
					timespan = planLession(startHour);
				}
				List<Student> stus = new ArrayList<Student>();
				stus.add(stu);
				Lession lession = new Lession();
				lession.setLessionTime(timespan);
				lession.setTeacher(teacher);
				lession.setType(lessionType);
				lession.setStudents(stus);
				;
				lessions.add(lession);

			}

		}
		table.getLessionMap().put(lessionType, lessions);
		table.setStudent(stu);
		return table;
	}

	private TimeSpan planLession(Calendar startHour) {
		Calendar endLession = Calendar.getInstance();
		endLession.setTime(startHour.getTime());
		endLession.add(Calendar.HOUR_OF_DAY, 2);
		TimeSpan timespan = new TimeSpan(startHour, endLession);
		return timespan;

	}

	private Calendar get(TimeSpan timespan, List<TimeSpan> specialTime) {
		Calendar startTime = timespan.getStartTime();
		for (TimeSpan t : specialTime) {
			Calendar calendar = t.getLastTime(timespan);
			if (calendar != null && startTime.after(calendar)) {
				startTime = calendar;

			}
		}
		return startTime;

	}

	private Teacher selectTeacher(Student stu, String lessionType) {
		if (stu.getFormerTeacher() != null && stu.getFormerTeacher().containsKey(lessionType)) {
			Teacher teacher = stu.getFormerTeacher().get(lessionType);
			if (teachers.contains(teacher)) {
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
