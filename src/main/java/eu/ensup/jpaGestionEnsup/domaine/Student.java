package eu.ensup.jpaGestionEnsup.domaine;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String mailAddress;
	private String address;
	private String numberPhone;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	Collection<Course> courses;
	
	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName, String mailAddress, String address, String numberPhone, Collection<Course> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailAddress = mailAddress;
		this.address = address;
		this.numberPhone = numberPhone;
		this.courses = courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mailAddress="
				+ mailAddress + ", address=" + address + ", numberPhone=" + numberPhone + "]";
	}
}
