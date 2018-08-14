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
	background-color: #ace64c;
}

.dropdown-menu {
	background-color: #ececec !important;;
	border: 1px solid #0067CC !important;
}
.btn, .btn:active, .btn:visited {
    background-color: #ace64c; !important;
}
.btn:hover {
    background-color:#87ce12; !important;
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
					<i class="fa fa-user"></i> Transaction Form
				</div>
				<div class="card-body">

					<form:form action="TransactionCreationSave" method="post"
						modelAttribute="transaction">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								<tr>
									<td><label for="TRN_PURCHASEDATE">Transaction Date</label><font color="red"> *</font></td>
									<td><form:input path="TRN_PURCHASEDATE" id="dob" name="TRN_PURCHASEDATE" type="text" required="required"
											placeholder="DD/MM/YYYY" /></td>
								</tr>
								<tr>
									<td><label for="STUD_ID">Student</label><font color="red"> *</font></td>
									<td><form:select path="STUD_ID" id="STUD_ID" size="5" required="required" cssStyle="width: 80%;">
											<!--  <option value="None" selected>---Select---</option> -->
											<c:forEach items="${studentList}" var="student">
												<c:choose>
													<c:when test="${transaction.STUD_ID == student.STUD_ID}">
														<option value="${student.STUD_ID}" selected="selected">${student.STUD_FIRSTNAME}
															${student.STUD_LASTNAME} : ${student.STUD_EMAIL}</option>
													</c:when>
													<c:otherwise>
														<option value="${student.STUD_ID}">${student.STUD_FIRSTNAME}
															${student.STUD_LASTNAME} : ${student.STUD_EMAIL}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>

										</form:select></td>
								</tr>
								<tr>
									<td colspan="2" align="center">&nbsp;</td>
								</tr>
								<tr>
									<td><label for="PROD_ID">Product</label><font color="red"> *</font></td>
									<td><form:select path="PROD_ID"
											id="PROD_ID" size="5" required="required" cssStyle="width: 80%;">
											<!--  <option value="None" selected>---Select---</option> -->
											<c:forEach items="${productList}" var="product">
												<c:choose>
													<c:when test="${transaction.PROD_ID == product.PROD_ID}">
														<option value="${product.PROD_ID}" selected="selected">${product.PROD_NAME}:
															$${product.PROD_PRICE} : ${product.PROD_INFO}</option>
													</c:when>
													<c:otherwise>
														<option value="${product.PROD_ID}">${product.PROD_NAME}:
															$${product.PROD_PRICE} : ${product.PROD_INFO}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>

										</form:select></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><form:button
											class="btn">Save</form:button></td>
								</tr>





							</table>
						</div>
						<form:input path="TRN_ID" id="TRN_ID" type="hidden" />
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
				$('#dob').datepicker({
					format : 'dd/mm/yyyy',
				});
				
			})
			
	
			
			
		</script>

	</div>

</body>

</html>