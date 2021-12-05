

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
 * Servlet implementation class updateBook
 */
@WebServlet("/updateBook")
public class updateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dbDriver="com.mysql.cj.jdbc.Driver";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateBook() {
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
		String name = request.getParameter("bname");
		String title=request.getParameter("title");
		String author = request.getParameter("author");
		String category=request.getParameter("category");
		Databaseconnection dbc = new Databaseconnection();
		dbc.loadDriver(dbDriver);
		Connection con =dbc.getConnection();
		String message="not updated";
        String sql = "UPDATE books SET BN='"+name+"',title='"+title+"',autho='"+author+"',category='"+category+"' WHERE id=2";
    
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
        //response.getWriter().print(author);
        request.setAttribute("errorMessage", message);
      //  response.sendRedirect("updateBook.jsp?id="+id);
		RequestDispatcher rd = request.getRequestDispatcher("updateBook.jsp?id="+id);
		rd.forward(request, response);
	
	}

}
