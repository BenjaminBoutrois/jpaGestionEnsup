package eu.ensup.jpaGestionEnsup.domaine;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course
{
	@Id
	private String themeCourse;
	private int numberHours;
	
	public Course(String themeCourse, int numberHours) {
		super();
		this.themeCourse = themeCourse;
		this.numberHours = numberHours;
	}

	public String getThemeCourse() {
		return themeCourse;
	}

	public void setThemeCourse(String themeCourse) {
		this.themeCourse = themeCourse;
	}

	public int getNumberHours() {
		return numberHours;
	}

	public void setNumberHours(int numberHours) {
		this.numberHours = numberHours;
	}

	@Override
	public String toString() {
		return "Course [themeCourse=" + themeCourse + ", numberHours=" + numberHours + "]";
	}
}
