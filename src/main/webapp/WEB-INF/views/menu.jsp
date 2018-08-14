<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>KungFu system</title>
<!-- Bootstrap core CSS-->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="resources/css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav"> <a class="navbar-brand"
		href="${pageContext.servletContext.contextPath}/startPage"">Inventory
		System: Hi <c:out value="${loginUserInfo.u_NAME}"></c:out>
	</a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarResponsive"
		aria-controls="navbarResponsive" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Dashboard"><a class="nav-link"
				href="${pageContext.servletContext.contextPath}/dashboard"> <i
					class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
			</a></li>


			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Instructor"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#instructor" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-user-plus"></i> <span class="nav-link-text">Instructor</span>
				</a>
				<ul class="sidenav-second-level collapse" id="instructor">
					<li><a href="${pageContext.servletContext.contextPath}/InstructorCreation">Instructor Form</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/InstructorList">Instructor List</a></li>
				</ul>
			</li>
			
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Student"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#student" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-male"></i> <span class="nav-link-text">Student</span>
				</a>
				<ul class="sidenav-second-level collapse" id="student">
					<li><a href="${pageContext.servletContext.contextPath}/StudentCreation">Student Form</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/StudentList">Student List</a></li>
				</ul>
			</li>
			
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Product"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#product" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-magic"></i> <span class="nav-link-text">Product</span>
				</a>
				<ul class="sidenav-second-level collapse" id="product">
					<li><a href="${pageContext.servletContext.contextPath}/ProductCreation">Product Form</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/ProductList">Product List</a></li>
				</ul>
			</li>
			
			
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Course Level"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#courseLevel" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-signal"></i> <span class="nav-link-text">Course Level</span>
				</a>
				<ul class="sidenav-second-level collapse" id="courseLevel">
					<li><a href="${pageContext.servletContext.contextPath}/CourseLevelCreation">Course Level Form</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/CourseLevelList">Course Level List</a></li>
				</ul>
			</li>
			
			 <li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Course"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#course" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-book"></i> <span class="nav-link-text">Course</span>
				</a>
				<ul class="sidenav-second-level collapse" id="course">
					<li><a href="${pageContext.servletContext.contextPath}/CourseCreation">Course Form</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/CourseList">Course List</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/CourseDayCreation">Course Day Form</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/CourseDayList">Course Day List</a></li>
				</ul>
			</li>
			
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Rank"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#rank" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-graduation-cap"></i> <span class="nav-link-text">Rank</span>
				</a>
				<ul class="sidenav-second-level collapse" id="rank">
					<li><a href="${pageContext.servletContext.contextPath}/RankCreation">Rank Form</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/RankList">Rank List</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/PerformanceCreation">Performance Form</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/PerformanceList">Performance List</a></li>
				</ul>
			</li>
				
			
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Transaction"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#transaction" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-newspaper-o"></i> <span class="nav-link-text">Transaction</span>
				</a>
				<ul class="sidenav-second-level collapse" id="transaction">
					<li><a href="${pageContext.servletContext.contextPath}/TransactionCreation">Transaction Form</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/TransactionList">Transaction List</a></li>
				</ul>
			</li>
			
			
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Attendance"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#attendance" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-credit-card"></i> <span class="nav-link-text">Attendance</span>
				</a>
				<ul class="sidenav-second-level collapse" id="attendance">
					<li><a href="${pageContext.servletContext.contextPath}/AttendanceCreation">Attendance Form</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/AttendanceList">Attendance List</a></li>
				</ul>
			</li>
           

             







		</ul>
		<ul class="navbar-nav sidenav-toggler">
			<li class="nav-item"><a class="nav-link text-center"
				id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
			</a></li>
		</ul>




		<ul class="navbar-nav ml-auto" style="padding-right: 15%">
			




			<!--    
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="alertsDropdown">
            <h6 class="dropdown-header">New Alerts:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-danger">
                <strong>
                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all alerts</a>
          </div>
        </li>
         -->


			<%-- 	<li class="nav-item">
				<form class="form-inline my-2 my-lg-0 mr-lg-2">
					<div class="input-group">
						<input class="form-control" type="text"
							placeholder="Search for..."> <span
							class="input-group-append">
							<button class="btn btn-primary" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
			</li> --%>
			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
			</a></li>
		</ul>




	</div>
	</nav>







	<!-- Logout Modal-->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">X</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary"
						href="${pageContext.servletContext.contextPath}">Logout</a>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
