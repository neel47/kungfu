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
<title>Inventory system</title>
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

<link href="resources/vendor/bootstrap/css/timetablejs.css"
	rel="stylesheet">




<style>
.card-header {
	background-color: rgb(234, 123, 113);
}
</style>



</head>
<body>

			<!-- <ol class="breadcrumb">
				<li class="breadcrumb-item">User Form</li>
			</ol> -->

				<div class="card-header">
					<i class="fa fa-table"></i> Course Schedule
				</div>
					
					
					 <div class="timetable"></div>
					
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<div class="card-footer small text-muted">
					Updated at
					<fmt:formatDate type="time" value="${now}" />
				</div>


			<!-- Scroll to Top Button-->
			<a class="scroll-to-top rounded" href="#page-top"> <i
				class="fa fa-angle-up"></i>
			</a>

			<!-- Bootstrap core JavaScript-->
			<script src="resources/vendor/jquery/jquery.min.js"></script>
			<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
			<!-- Core plugin JavaScript-->
			<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>
			<!-- Page level plugin JavaScript-->
			<script src="resources/vendor/chart.js/Chart.min.js"></script>
			<script src="resources/vendor/datatables/jquery.dataTables.js"></script>
			<script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>
			<!-- Custom scripts for all pages-->
			<script src="resources/js/sb-admin.min.js"></script>
			<!-- Custom scripts for this page-->
			<script src="resources/js/sb-admin-datatables.min.js"></script>
			<!--     <script src="resources/js/sb-admin-charts.min.js"></script>
 -->
 	<script src="resources/vendor/jquery/timetable.js"></script>
 	<script type="text/javascript">
 	
 	          var data=${data};
 		console.log(data);
 		
	 	
	 	
	 	
 		
 		
	      var timetable = new Timetable();
	      timetable.setScope(9,3)

	      timetable.addLocations(['MONDAY', 'TUESDAY','WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY']);

	      for(i in data) { 
	    	  console.log(data[i]);
	    	  var splitData=data[i].split(", ");
	    	  console.log(splitData.length);
	    	  timetable.addEvent(splitData[0], splitData[1],new Date(2015,7,17,splitData[2],splitData[3]), new Date(2015,7,17,splitData[4],splitData[5]), { url: '#' });
	      }
    		
	      
// 	      timetable.addEvent('Zumba', 'TUESDAY', new Date(2015,7,17,12), new Date(2015,7,17,13), { url: '#' });
// 	      timetable.addEvent('Zumbu', 'WEDNESDAY', new Date(2015,7,17,13,30), new Date(2015,7,17,15), { url: '#' });
// 	      timetable.addEvent('Lasergaming', 'THURSDAY', new Date(2015,7,17,17,45), new Date(2015,7,17,19,30), { class: 'vip-only', data: { maxPlayers: 14, gameType: 'Capture the flag' } });
// 	      timetable.addEvent('All-you-can-eat grill', 'FRIDAY', new Date(2015,7,17,21), new Date(2015,7,18,1,30), { url: '#' });
// 	      timetable.addEvent('Hackathon', 'SATURDAY', new Date(2015,7,17,11,30), new Date(2015,7,17,20)); // options attribute is not used for this event
// 	      timetable.addEvent('Tokyo Hackathon Livestream', 'SUNDAY', new Date(2015,7,17,12,30), new Date(2015,7,17,16,15)); // options attribute is not used for this event
// 	      timetable.addEvent('Lunch', 'SUNDAY', new Date(2015,7,17,9,30), new Date(2015,7,17,11,45), { onClick: function(event) {
// 	        window.alert('You clicked on the ' + event.name + ' event in ' + event.location + '. This is an example of a click handler');
// 	      }});
// 	      timetable.addEvent('Cocktails', 'SUNDAY', new Date(2015,7,18,00,00), new Date(2015,7,18,02,00), { class: 'vip-only' });

	      var renderer = new Timetable.Renderer(timetable);
	      renderer.draw('.timetable');
</script>
 	
 	
 	
</body>
</html>