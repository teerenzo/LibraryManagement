<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver");
 String dburl="jdbc:mysql://localhost:3306/library";
 String dbuser="root";
 String dbpassword="";
Connection connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
        Statement statement = connection.createStatement() ;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Library Management - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">
<%
response.setHeader("cache-control","no-cache, no-store, must-revalidate");
response.setHeader("progma","no-cache");
response.setHeader("Expires","0");
if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}
%>
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
      <%@ include file="includes/sidebar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
           <div id="content">

                <!-- Topbar -->
              <%@ include file="includes/topnav.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">Add New Book</h1>
                    
                    <div class="col-md-12 col-sm-4 col-xs-12 ">
             
                       <b style="color:red">  <%  
                String profile_msg=(String)request.getAttribute("errorMessage");  
                      if(profile_msg!=null){  
               out.print(profile_msg);  
              }  %></b> 
        <div class="panel panel-info">
        
          <div class="panel-body">
          <form action="AddBook"  method="post" enctype="multipart/form-data" >
                
                <div class="form-group">
                    <label for="firstname">Book Number1:</label>
                    <input type="text" class="form-control" required='' name="bname" placeholder="Enter SBN number">
                </div>
                <div class="form-group">
                    <label for="firstname">Book Title:</label>
                    <input type="text" class="form-control" required='' name="title" placeholder="Enter Book title">
                </div>
                <div class="form-group">
                    <label for="gender">Book Author:</label>
                     <input type="text" class="form-control" required='' name="author" placeholder="Enter Book author">
                  
                </div>
                <div class="form-group">
                    <label for="gender">Book Category:</label>
                    
                      <input type="text" class="form-control" required='' name="category" placeholder="Enter Book Category">
                </div>
                <div class="form-group">
                    <label for="gender">Book Image:</label>
                     <input type="file" class="form-control" name="img">
                </div>
                

                <div class="form-group">
                    <input type="submit" class="btn btn-primary from-control" value="Add Book">
                </div>

            </form>
          </div>
        </div>
      </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
          <%@ include file="includes/footer.jsp" %>
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
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>