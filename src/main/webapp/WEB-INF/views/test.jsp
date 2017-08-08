<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
 		$.ajax({
			type : "post",
			url : "calendar.do?method=list",
			dataType : "json",
			success : function(data) {
				dteinfo = data.list;
				loadView();
			}
		});
		loadView();
	});

	function loadView() {
/* 		$('#calendar').fullCalendar({
			theme : true, // 테마적용.
			header : {
				left : 'prev,next today',
				center : 'title',
				right : 'month,agendaWeek,agendaDay,listMonth'
			},
			defaultDate : new Date(),
			navLinks : true, // can click day/week names to navigate views
			eventLimit : true, // allow "more" link when too many events
			// id, title, start, end, url
			events : dteinfo

		}); // fullCalendar END */
		$('#calendar2').text('???');
	}// function END
</script>
<body>
<h1>테스트화면</h1>
<div id = "calendar"></div>
<h1 id = "calendar2"></h1>


</body>
</html>