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
	background-color: #17a2b8;
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
					<i class="fa fa-user"></i> Product Form
				</div>
				<div class="card-body">

					<form:form action="ProductCreationSave" method="post"
						modelAttribute="product">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								
								<tr>
									<td><label for="PROD_NAME">Product Name</label><font color="red"> *</font></td>
									<td><form:input path="PROD_NAME" id="PROD_NAME"
											type="text" pattern="[A-Za-z0-9 ]{1,50}" required="required" placeholder=" Enter Product Name"/></td>
								</tr>
								<tr>
									<td><label for="PROD_INFO">Product Info</label><font color="red"> *</font></td>
									<td><form:input path="PROD_INFO" id="PROD_INFO"
											type="text" pattern="[A-Za-z0-9 ]{1,150}" required="required" placeholder=" Enter Product Info"/></td>
								</tr>
								<tr>
									<td><label for="PROD_PRICE">Product Price</label><font color="red"> *</font></td>
									<td><form:input path="PROD_PRICE" id="PROD_PRICE" type="text" pattern="[0-9]{1,12}" required="required" placeholder=" Enter Product Price"/></td>
								</tr>
								<tr>
									<td><label for="PROD_ISDATEM">Date Required</label><font color="red"> *</font></td>
									<td><form:select path="PROD_ISDATEM" required="required">
											<form:option value="true" label="Yes" />
											<form:option value="false" label="No" />
										</form:select></td>
								</tr>
								
								<tr>
									<td><label for="PROD_STARTDATE">Product Start Date</label><font color="red"> *</font></td>
									<td><form:input path="PROD_STARTDATE" id="PROD_STARTDATE" name="PROD_STARTDATE" type="text" 
											placeholder="DD/MM/YYYY" /></td>
								</tr>
								
								<tr>
									<td><label for="PROD_ENDDATE">Product End Date</label><font color="red"> *</font></td>
									<td><form:input path="PROD_ENDDATE" id="PROD_ENDDATE" name="PROD_ENDDATE" type="text" 
											placeholder="DD/MM/YYYY" /></td>
								</tr>
								
								
								
								<tr>
									<td colspan="2" align="center"><form:button
											class="btn btn-info">Save</form:button></td>
								</tr>

								
								
							</table>
						</div>
						<form:input path="PROD_ID" id="PROD_ID" type="hidden" />
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
				$('#PROD_STARTDATE').datepicker({
					format : 'dd/mm/yyyy',
				});
				$('#PROD_ENDDATE').datepicker({
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