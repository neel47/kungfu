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
	background-color: #ffc107;
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
					<i class="fa fa-user"></i> Student Form
				</div>
				<div class="card-body">

					<form:form action="StudentCreationSave" method="post"
						modelAttribute="student">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								
								<tr>
									<td><label for="STUD_FIRSTNAME">First Name</label><font color="red"> *</font></td>
									<td><form:input path="STUD_FIRSTNAME" id="STUD_FIRSTNAME"
											type="text" pattern="[A-Za-z ]{1,32}" required="required" placeholder=" Enter FirstName"/></td>
								</tr>
								<tr>
									<td><label for="STUD_LASTNAME">Last Name</label><font color="red"> *</font></td>
									<td><form:input path="STUD_LASTNAME" id="STUD_LASTNAME"
											type="text" pattern="[A-Za-z ]{1,32}" required="required" placeholder=" Enter LastName"/></td>
								</tr>
								<tr>
									<td><label for="STUD_GENDER">Gender</label><font color="red"> *</font></td>
									<td><form:select path="STUD_GENDER" required="required">
											<form:option value="MALE" label="Male" />
											<form:option value="FEMALE" label="Female" />
										</form:select></td>
								</tr>
								<tr>
									<td><label for="STUD_ADDRESS">Address</label>
									<td><form:input path="STUD_ADDRESS" id="STUD_ADDRESS" type="text" required="required" placeholder=" Enter Address"/></td>
								</tr>
								<tr>
									<td><label for="STUD_MOBILE">Mobile</label><font color="red"> *</font></td>
									<td><form:input path="STUD_MOBILE" id="STUD_MOBILE" type="text" pattern="[0-9]{10}" required="required" placeholder=" Enter Mobile"/></td>
								</tr>
								
								<tr>
									<td><label for="dob">Date of Birth</label><font color="red"> *</font></td>
									<td><form:input path="STUD_DOB" id="dob" name="STUD_DOB" type="text" required="required"
											placeholder="DD/MM/YYYY" /></td>
								</tr>
								
								<tr>
									<td><label for="STUD_EMAIL">Email</label><font color="red"> *</font></td>
									<td><form:input path="STUD_EMAIL" id="STUD_EMAIL" type="email" required="required" placeholder=" Enter Email" /></td>
								</tr>
								<tr>
									<td><label for="STUD_JOININGDATE">Date of Joining</label><font color="red"> *</font></td>
									<td><form:input path="STUD_JOININGDATE" id="doj" name="STUD_JOININGDATE" type="text" required="required"
											placeholder="DD/MM/YYYY" /></td>
								</tr>
								
								
								<tr>
									<td colspan="2" align="center"><form:button
											class="btn btn-warning">Save</form:button></td>
								</tr>

								
								
							</table>
						</div>
						<form:input path="STUD_ID" id="STUD_ID" type="hidden" />
						<form:input path="VERSION" id="VERSION" type="hidden" />
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
				$('#dob').datepicker({
					format : 'dd/mm/yyyy',
				});
				$('#doj').datepicker({
					format : 'dd/mm/yyyy',
				});
			})
			
		function onchange_ParentN()
			{
				$("#parentFrame").toggle();
			}
			
			
			
		</script>

	</div>

</body>
</html>