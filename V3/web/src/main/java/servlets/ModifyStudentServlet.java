package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ensup.domaine.Course;
import eu.ensup.domaine.Student;
import eu.ensup.domaine.User;
import eu.ensup.service.CourseService;
import eu.ensup.service.ICourseService;
import eu.ensup.service.StudentService;
import eu.ensup.service.IStudentService;

/**
 * Servlet implementation class ModifyStudentServlet
 */
public class ModifyStudentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IStudentService studentService;
	private RequestDispatcher dispatcher = null;
	private ICourseService courseService;
	private User user = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyStudentServlet()
	{
		studentService = new StudentService();
		courseService = new CourseService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DateFormat df = DateFormat.getDateInstance();
		Student student = null;
		
		try
		{
			student = new Student(request.getParameter("firstName"), request.getParameter("lastName"),
					request.getParameter("mailAddress"), request.getParameter("address"),
					request.getParameter("numberPhone"), df.parse(request.getParameter("birthDate")));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");

		studentService.updateStudent(student);

		session.setAttribute("student", null);
		session.setAttribute("students", getAllStudents());
		session.setAttribute("courses", getAllCourses());

		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}

	private List<Student> getAllStudents()
	{
		List<Student> students = Collections.emptyList();
		
		try
		{
			students = studentService.getAllStudents();
		}
		catch (Exception e)
		{

		}
		
		return students;
	}

	private List<Course> getAllCourses()
	{
		List<Course> courses = Collections.emptyList();
		
		try
		{
			courses = courseService.getAllCourses();
		}
		catch (Exception e)
		{

		}
		
		return courses;
	}
}
