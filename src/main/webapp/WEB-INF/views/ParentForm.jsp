<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<link href="resources/vendor/bootstrap/css/datepicker.css"
	rel="stylesheet" />
<!-- Page level plugin CSS-->
<link href="resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="resources/css/sb-admin.css" rel="stylesheet">


<style>
.card-header {
	background-color:#2fc251;
}

.dropdown-menu {
	background-color: #ececec !important;;
	border: 1px solid #0067CC !important;
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
					<i class="fa fa-user"></i> Parent Form
				</div>
				<div class="card-body">

					<form:form action="ParentCreationSave" method="post"
						modelAttribute="parent">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								
								<tr>
									<td><label for="PAR_NAME">Parent Name</label><font color="red"> *</font></td>
									<td><form:input path="PAR_NAME" id="PAR_NAME"
											type="text" pattern="[A-Za-z ]{1,32}" required="required" placeholder=" Enter ParentName"/></td>
								</tr>
								
								<tr>
									<td><label for="PAR_RELATION">Relation</label><font color="red"> *</font></td>
									<td><form:select path="PAR_RELATION" required="required">
											<form:option value="Father" label="Father" />
											<form:option value="Mother" label="Mother" />
											<form:option value="Guardian" label="Guardian" />
										</form:select></td>
								</tr>
								
								<tr>
									<td><label for="PAR_MOBILE">Mobile</label><font color="red"> *</font></td>
									<td><form:input path="PAR_MOBILE" id="PAR_MOBILE" type="text" pattern="[0-9]{10}" required="required" placeholder=" Enter Mobile"/></td>
								</tr>
								
								<tr>
									<td><label for="PAR_EMAIL">Email</label><font color="red"> *</font></td>
									<td><form:input path="PAR_EMAIL" id="PAR_EMAIL" type="email" required="required" placeholder=" Enter Email" /></td>
								</tr>
								
								
								<tr>
									<td colspan="2" align="center"><form:button
											class="btn btn-success">Save</form:button></td>
								</tr>

							</table>
						</div>
						<form:input path="PAR_ID" id="PAR_ID" type="hidden" />
						<form:input path="STUD_ID" id="STUD_ID" type="hidden" />
						<form:input path="version" id="version" type="hidden" />
					</form:form>
				</div>
			</div>



		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>

		<!-- Bootstrap core JavaScript-->
		<script src="resources/vendor/jquery/jquery.min.js"></script>
		<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<script src="resources/vendor/bootstrap/js/bootstrap-datepicker.js">
		<!-- Core plugin JavaScript-->
			<script src="resources/vendor/jquery-easing/jquery.easing.min.js">
		</script>
		<!-- Page level plugin JavaScript-->
		<script src="resources/vendor/chart.js/Chart.min.js"></script>
		<script src="resources/vendor/datatables/jquery.dataTables.js"></script>
		<script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="resources/js/sb-admin.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				
			})
			
			
			
			
			
		</script>

	</div>

</body>
</html>