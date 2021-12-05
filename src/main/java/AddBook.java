

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
@MultipartConfig(maxFileSize = 16177215) 
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url="jdbc:mysql://localhost:3306/library";
	 private  String user="root";
  private  String pass="";
  private String drivename="com.mysql.cj.jdbc.Driver";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
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
		 InputStream inputStream = null; 
	        Part filePart = request.getPart("img");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	        }
	    
		String name = request.getParameter("bname");
		String title=request.getParameter("title");
		String author = request.getParameter("author");
		String category=request.getParameter("category");
		//Book book = new Book(name,title,author,category,"");
	       
        Connection conn = null; // connection to the database
        String message = "New Book Not Added";  // message will be sent back to client
		  try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		       conn = DriverManager.getConnection(url,user,pass);
		       String sql = "INSERT INTO books (id,BN,title,autho,category,img) values(?,?,?,?,?,?)";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, null);
	            statement.setString(2, name);
	            statement.setString(3, title);
	            statement.setString(4, author);
	            statement.setString(5, category);
	           // statement.setString(6, email);
	            if (inputStream != null) {
	                // fetches input stream of the upload file for the blob column
		        	  statement.setBlob(6, inputStream);
	            }
	            if(statement.executeUpdate()>0) {
	            	   message = "New Book Added Well";
	            }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = e.toString();
		}
   
	//	Databaseconnection dbc = new Databaseconnection();
		//String result =dbc.AddBook(book);
		//response.getWriter().print(message);
		// String errorMessage ="The retrived password or username did not match";
	        request.setAttribute("errorMessage", message );
	           RequestDispatcher rd = request.getRequestDispatcher("addBook.jsp");
	                rd.forward(request, response);  
		
	}

}
