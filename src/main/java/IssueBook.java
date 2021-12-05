

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
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dbDriver="com.mysql.cj.jdbc.Driver";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBook() {
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
	  String regn = request.getParameter("regn");
	  String sbn = request.getParameter("sbn");
	  Databaseconnection bdc = new Databaseconnection();
		bdc.loadDriver(dbDriver);
		Connection con =bdc.getConnection();
		String sql = "INSERT INTO issuedbookdetail(bookid,studentid) VALUES('"+sbn+"','"+regn+"')";
		
		String message ="Student Added Well";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, null);
//			ps.setString(2, sbn);
//			ps.setString(3, regn);
//			ps.setString(4, "0");
//			ps.setString(5, "0");
//			ps.setString(6, null);
//			ps.setString(7, null);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message=e.toString();
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("issueBook.jsp");
		rd.forward(request, response);
	}

}
