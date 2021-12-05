import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Databaseconnection {
	//giving authantication
			private String dburl="jdbc:mysql://localhost:3306/library";
			private String dbuser="root";
			private String dbpassword="";
			private String dbDriver="com.mysql.cj.jdbc.Driver";
			
			//codes to load driver of mysql connector
			public void loadDriver(String dbDriver) {
				
				try {
					Class.forName(dbDriver);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			public Connection getConnection() {
				Connection con=null;
				try {
					con=DriverManager.getConnection(dburl,dbuser,dbpassword);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return con;
			
			}
			//select data from database
			public boolean checkCredentials(String username,String pass) {
				loadDriver(dbDriver);
				//String Message="";
				Connection con = getConnection();
				String query = "SELECT * from admin where email='"+username+"' AND password='"+pass+"'";
				
			    try {
					PreparedStatement ps = con.prepareStatement(query);
					
//					ps.setString(1, username);
//					ps.setString(2, pass);
					ResultSet rs=ps.executeQuery(query);
					if(rs.next()) {
//						rs.getStatement();
						return true;
						//Message="done";
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//Message=e.toString();
					e.printStackTrace();
				}
			return false;
				
			}
			// this is going to take the object of that class
//			public String insert(Students student) {
//				loadDriver(dbDriver);
//				Connection con=geConnection();
//				String query="INSERT INTO student VALUES(?,?,?,?,?)";
//				
//				
//				String Message="Record Registered successfull";
//				
//				
//			
//				try {
//					PreparedStatement ps=con.prepareStatement(query);		
//					ps.setString(1, null);
//					ps.setString(2,student.getRegno());
//					ps.setString(3, student.getFullname());
//					ps.setInt(4, student.getAge());
//					ps.setString(5, student.getGender());
//					ps.execute();
//				} catch (Exception e) {
//					// TODO: handle exception
//					
//					//Message="Record not registered !!";
//					Message=e.toString();
//					e.printStackTrace();
//				}
//				return Message;
//				
//			}
			
			public String AddBook(Book book) {
				loadDriver(dbDriver);
				Connection con=getConnection();
				String query="INSERT INTO books VALUES(?,?,?,?,?)";
				
				
				String Message="Book Added successfull";
				try {
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, null);
					ps.setString(2, book.getBook_name());
					ps.setString(3, book.getBook_title());
					ps.setString(4, book.getAuthor());
					ps.setString(5, book.getCategory());
					//ps.setString(4, book.getImagePath());
					ps.execute();
				} catch (Exception e) {
					// TODO: handle exception
					
					//Message="Account not Created !!";
					Message=e.toString();
					e.printStackTrace();
				}
				return Message;
			}
			
}
