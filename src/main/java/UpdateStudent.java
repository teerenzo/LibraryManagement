

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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dbDriver="com.mysql.cj.jdbc.Driver";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
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
		String id = request.getParameter("id");
		String names= request.getParameter("sname");
		String regn = request.getParameter("regn");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		Databaseconnection bdc = new Databaseconnection();
		bdc.loadDriver(dbDriver);
		Connection con =bdc.getConnection();
		String message="not updated";
        String sql = "UPDATE students SET studentid='"+regn+"',full_name='"+names+"',email='"+email+"',tel='"+tel+"' where id='"+id+"'";
    
        try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.execute();
		//	ps.execute();
           int i= ps.executeUpdate();
			
           if(i > 0) {
        	   message="updated well";
           }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//message=e.toString();
			e.printStackTrace();
		}
      //  response.getWriter().print(email);
        request.setAttribute("errorMessage", "hhhhh");
      //  response.sendRedirect("editStudent.jsp?id="+id);
		RequestDispatcher rd = request.getRequestDispatcher("editStudent.jsp?id="+id);
		rd.forward(request, response);
	}

}
