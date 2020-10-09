package servlets;

import java.io.IOException;
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
import eu.ensup.service.StudentService;
import eu.ensup.service.UserService;
import eu.ensup.service.ICourseService;
import eu.ensup.service.IStudentService;
import eu.ensup.service.IUserService;

/**
 * Servlet implementation class SupprimerEtudiantServlet
 */
public class DeleteStudentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IStudentService studentService;
	private ICourseService courseService;
	private RequestDispatcher dispatcher = null;
	private User user = null;

	/**
	 * Default constructor.
	 */
	public DeleteStudentServlet()
	{
		studentService = new StudentService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		deleteStudent(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		int id = Integer.valueOf(object);

		studentService.deleteStudent(id);

		dispatcher = request.getRequestDispatcher("etudiant.jsp");

		user = (User) session.getAttribute("user");
		session.setAttribute("students", getAllStudents());
		session.setAttribute("courses", getAllCourses());
		session.setAttribute("student", null);

		session.setAttribute("message", "Suppression effectuée avec succès !");
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
