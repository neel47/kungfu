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
	background-color: #d9534f;
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
					<i class="fa fa-user"></i> Course Day Form
				</div>
				<div class="card-body">

					<form:form action="CourseDayCreationSave" method="post"
						modelAttribute="courseDay">

						<div class="table-responsive">
							<table class="" width="100%" cellspacing="0">


								<tr>
									<td><label for="COURSE_ID">Course Name</label><font color="red"> *</font></td>
									<td><form:select path="COURSE_ID" id="COURSE_ID" size="5" required="required" cssStyle="width: 80%;">
											<!--  <option value="None" selected>---Select---</option> -->
											<c:forEach items="${courseList}" var="course">
												<c:choose>
													<c:when test="${courseDay.COURSE_ID == course.COURSE_ID}">
														<option value="${course.COURSELVL_ID}" selected="selected">${course.COURSE_CODE}
															: ${course.COURSE_NAME} : ${course.COURSE_DESCRIPTION}</option>
													</c:when>
													<c:otherwise>
														<option value="${course.COURSE_ID}">${course.COURSE_CODE}
															: ${course.COURSE_NAME} : ${course.COURSE_DESCRIPTION}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>

										</form:select></td>
								</tr>
								
								<tr>
									<td><label for="COURSEDAY_DAY">Course Day</label><font color="red"> *</font></td>
									<td><form:select path="COURSEDAY_DAY" required="required">
											<form:option value="MONDAY" label="Monday" />
											<form:option value="TUESDAY" label="Tuesday" />
											<form:option value="WEDNESDAY" label="Wednesday" />
											<form:option value="THURSDAY" label="Thursday" />
											<form:option value="FRIDAY" label="Friday" />
											<form:option value="SATURDAY" label="Saturday" />
											<form:option value="SUNDAY" label="Sunday" />
										</form:select></td>
								</tr>
								<tr>
									<td><label for="COURSEDAY_STARTTIME">Course Start Time</label><font color="red"> *</font></td>
									<td><form:input path="COURSEDAY_STARTTIME" id="COURSEDAY_STARTTIME"
											type="text"  required="required" /></td>
								</tr>
								
								<tr>
									<td><label for="COURSEDAY_ENDTIME">Course End Time</label><font color="red"> *</font></td>
									<td><form:input path="COURSEDAY_ENDTIME" id="COURSEDAY_ENDTIME"
											type="text"  required="required" /></td>
								</tr>
								
								<tr>
									<td colspan="2" align="center"><form:button
											class="btn btn-danger">Save</form:button></td>
								</tr>





							</table>
						</div>
						<form:input path="COURSEDAY_ID" id="COURSEDAY_ID" type="hidden" />
						<form:input path="version" id="version" type="hidden" />
					</form:form>
					
				</div>
				<!-- <div id="myScheduler"></div> -->
				<jsp:include page="/CourseViewE"></jsp:include>
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
		
		<script src="https://cdn.alloyui.com/3.0.1/aui/aui-min.js"></script>
		
		
		<script type="text/javascript">
/* var events;
var schedule;
var eventRecorder;
YUI().use(
		  'aui-scheduler',
		  function(Y) {
		     events = [
		      {
		        content: 'Event1',
		      }
		    ];

		     eventRecorder = new Y.SchedulerEventRecorder({
		    	    on: {
		    	        save: function(event) {
		    	            alert('Save Eventss:' + this.getEvent() + this.getFormattedDate() +' --- ' + this.getContentNode().val());
		    	        },
		    	        edit: function(event) {
		    	            alert('Edit Event:' + this.isNew() + ' --- ' + this.getContentNode().val());
		    	        },
		    	        delete: function(event) {
		    	            alert('Delete Event:' + this.isNew() + ' --- ' + this.getContentNode().val());
		    	        }
		    	    }
		    	});
		    var weekView = new Y.SchedulerWeekView();

		    schedule= new Y.Scheduler(
		      {
		        boundingBox: '#myScheduler',
		        eventRecorder: eventRecorder,
		        items: events,
		        render: true,
		        views: [weekView]
		      }
		    );
		  }
		);


function ok1()
{
	 jk=schedule.getEvents();
	alert( eventRecorder.get('content'));
	for (var j in jk) {
		  console.log(j);
		}
	
	
} */
</script>

	</div>

</body>

</html>