

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
 * Servlet implementation class MarkReturned
 */
@WebServlet("/MarkReturned")
public class MarkReturned extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dbDriver="com.mysql.cj.jdbc.Driver";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarkReturned() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Databaseconnection dbc = new Databaseconnection();
		dbc.loadDriver(dbDriver);
		Connection con =dbc.getConnection();
		String mess="yes";
String sql = "UPDATE issuedbookdetail SET status='returned' where id='"+id+"'";
		
		//String message ="Student Added Well";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.execute();
			ps.executeUpdate();
				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mess=e.toString();
			e.printStackTrace();
		}
		response.getWriter().print(mess);
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("issuedBooks.jsp");
		 * rd.forward(request, response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
