<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*"%>
   <%@ page import="java.util.Base64"%>
<% Class.forName("com.mysql.cj.jdbc.Driver");
 String dburl="jdbc:mysql://localhost:3306/library";
 String dbuser="root";
 String dbpassword="";
Connection connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
        Statement statement = connection.createStatement() ;
%>
 <%
                     /*   String dbDriver="com.mysql.cj.jdbc.Driver";
                       Databaseconnection dbc = new Databaseconnection();
    		dbc.loadDriver(dbDriver);
    	Connection con = dbc.getConnection(); */
     	int parameter = Integer.parseInt(request.getParameter("sys_number"));
    	ResultSet resultsetStudent = statement.executeQuery("SELECT * FROM `students` where studentid='"+parameter+"'") ;
    	
    	   while(resultsetStudent.next()){
                       %>
                                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>names</th>
                                              <th>tel</th>
                                              <th>email</th>
                                            
                                        
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>names</th>
                                              <th>tel</th>
                                              <th>email</th>
                                           
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                 

                                        <tr>
                                           
                                           
                                            <td><%= resultsetStudent.getString(3)  %></td>
                                            <td>
                                            <%= resultsetStudent.getString(5) %>
                                           
                                             </td>
                                              <td>
                                            <%= resultsetStudent.getString(4) %>
                                           
                                             </td>
                                           
                                           
                                         
                                        </tr>
                                      <% } %>
                                      
                                          </tbody>
                                </table>