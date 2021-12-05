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
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Library mis - Books</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
 <%@ include file='includes/sidebar.jsp' %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
               <%@ include file='includes/topnav.jsp' %>
               
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">All Books</h1>
                  

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Books</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>SSBN</th>
                                              <th>Image</th>
                                            <th>title</th>
                                            <th>author</th>
                                            <th>category</th>
                                           <th>Action</th>
                                        
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>SSBN</th>
                                              <th>Image</th>
                                            <th>title</th>
                                            <th>author</th>
                                            <th>category</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                       <%
                     /*   String dbDriver="com.mysql.cj.jdbc.Driver";
                       Databaseconnection dbc = new Databaseconnection();
    		dbc.loadDriver(dbDriver);
    	Connection con = dbc.getConnection(); */
    	
    	ResultSet resultsetBooks = statement.executeQuery("SELECT * FROM `books`") ;
    	   while(resultsetBooks.next()){
    		   Blob blob = resultsetBooks.getBlob("img");
    		   
    		   InputStream inputStream = blob.getBinaryStream();
    		   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    		   byte[] buffer = new byte[4096];
    		   int bytesRead = -1;
    		    
    		   while ((bytesRead = inputStream.read(buffer)) != -1) {
    		       outputStream.write(buffer, 0, bytesRead);
    		   }
    		    
    		   byte[] imageBytes = outputStream.toByteArray();
    		    
    		   String base64Image = Base64.getEncoder().encodeToString(imageBytes);
    		    
    		   inputStream.close();
    		   outputStream.close();
                       %>
                                  
                                 

                                        <tr>
                                            <td><%= resultsetBooks.getString(2)  %></td>
                                            <td>
                                        
                                             <img src="data:image/jpg;base64,<%=base64Image%>" width="100" height="140" />
                                             </td>
                                            <td><%= resultsetBooks.getString(3)  %></td>
                                            <td><%
                                            
                                    /*   ResultSet resultsetAuthor = statement.executeQuery("SELECT * FROM authors");  */
                                           /*  while(resultsetAuthor.next()){ */
                                             %>
                                            <%--  <%= resultsetAuthor.getString(2) %>
                                             <% } %> --%>
                                             </td>
                                            <td><%= resultsetBooks.getString(5)  %></td>
                                             <td>
                                             <a class="btn btn-primary" href="updateBook.jsp?id=<%= resultsetBooks.getString(1)  %>">Edit</a> <a class="btn btn-secondary" href="DeleteBook?id=<%= resultsetBooks.getString(1)  %>">Delete</a>
                                              <a class="btn btn-primary" href="issueBook.jsp?sbn=<%= resultsetBooks.getString(2)  %>">Issue</a>
                                             </td>
                                         
                                        </tr>
                                      <% } %>
                                      
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
          <%@ include file='includes/footer.jsp' %>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>

</html>