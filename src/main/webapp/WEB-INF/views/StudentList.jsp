<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap core CSS-->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="resources/vendor/bootstrap/css/jquery-ui.min.css"
	rel="stylesheet" />
<!-- Page level plugin CSS-->
<link href="resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="resources/css/sb-admin.css" rel="stylesheet">


<style>
.card-header {
	background-color: #ffc107;
}
</style>
</head>
<body>

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- <ol class="breadcrumb">
				<li class="breadcrumb-item">User Form</li>
			</ol> -->

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Student List
				</div>
				<div class="card-body">
					<div class="table-responsive">
					<p id="date_filter">
    <span id="date-label-from" class="date-label">Joining Date: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From: </span><input class="date_range_filter date" type="text" id="datepicker_from" />
    <span id="date-label-to" class="date-label">To: <input class="date_range_filter date" type="text" id="datepicker_to" />
</p>
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Joining Date</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Gender</th>
									<th>Mobile</th>
									<th>Date of Birth</th>
									<th>Email</th>
									<th>Link</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Joining Date</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Gender</th>
									<th>Mobile</th>
									<th>Date of Birth</th>
									<th>Email</th>
									<th>Link</th>
								</tr>
							</tfoot>
							<tbody>


								<c:forEach var="student" items="${studentList}">
									<tr>
										<td>${student.STUD_JOININGDATE}</td>
										<td>${student.STUD_FIRSTNAME}</td>
										<td>${student.STUD_LASTNAME}</td>
										<td>${student.STUD_GENDER}</td>
										<td>${student.STUD_MOBILE}</td>
										<td>${student.STUD_DOB}</td>
										<td>${student.STUD_EMAIL}</td>
										<td><a href="StudentEdit?id=${student.STUD_ID}">Edit</a>
											&nbsp;&nbsp;&nbsp; <a href="StudentDelete?id=${student.STUD_ID}">Delete</a><br>
											 <a href="ParentCreation?id=${student.STUD_ID}">Add Parent Details</a><br>
											  <a href="ParentList?id=${student.STUD_ID}">View Parent Details</a><br>
											</td>

									</tr>
								</c:forEach>



							</tbody>
						</table>
					</div>
				</div>
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<div class="card-footer small text-muted">
					Updated at
					<fmt:formatDate type="time" value="${now}" />
				</div>
			</div>


			<!-- Scroll to Top Button-->
			<a class="scroll-to-top rounded" href="#page-top"> <i
				class="fa fa-angle-up"></i>
			</a>

			<!-- Bootstrap core JavaScript-->
			<script src="resources/vendor/jquery/jquery.min.js"></script>
			<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
			<script src="resources/vendor/jquery/jquery-ui.min.js"></script>
			<!-- Core plugin JavaScript-->
			<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>
			<!-- Page level plugin JavaScript-->
			<script src="resources/vendor/chart.js/Chart.min.js"></script>
			<script src="resources/vendor/datatables/jquery.dataTables.js"></script>
			<script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>
			<!-- Custom scripts for all pages-->
			<script src="resources/js/sb-admin.min.js"></script>
			<!-- Custom scripts for this page-->
			<script src="resources/js/sb-admin-datatables.min_date.js"></script>
			<!--     <script src="resources/js/sb-admin-charts.min.js"></script>
 -->
		</div>
</body>
</html>