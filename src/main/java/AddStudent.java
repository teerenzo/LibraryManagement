

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dbDriver="com.mysql.cj.jdbc.Driver";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String names= request.getParameter("sname");
		String regn = request.getParameter("regn");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		Databaseconnection bdc = new Databaseconnection();
		bdc.loadDriver(dbDriver);
		Connection con =bdc.getConnection();
		String sql = "INSERT INTO students(id,studentid,full_name,email,tel) VALUES(?,?,?,?,?)";
		
		String message ="Student Added Well";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setString(2, regn);
			ps.setString(3, names);
			ps.setString(4, email);
			ps.setString(5, tel);
//			ps.setString(6, null);
//			ps.setString(7, null);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message=e.toString();
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("AddStudent.jsp");
		rd.forward(request, response);
		
	}

}
