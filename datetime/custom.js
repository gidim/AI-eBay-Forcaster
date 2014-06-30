	
	$(function () {
							   
		$('#datetimepicker3').datetimepicker({
			pick12HourFormat: false
		});
		$("#setMinDate").click(function () {						
			$('#datetimepicker3').data("DateTimePicker").setMinDate(Calendar.getInstance().setTime(new Date()).add(Calendar.DATE, 2).getTime());
		});                                
		$("#setMaxDate").click(function () {
			$('#datetimepicker3').data("DateTimePicker").setMaxDate(new Date("july 4, 2013"));
		});
		$("#show").click(function () {
			$('#datetimepicker3').data("DateTimePicker").show();
		});
		$("#disable").click(function () {
			$('#datetimepicker3').data("DateTimePicker").disable();
		});
		$("#enable").click(function () {
			$('#datetimepicker3').data("DateTimePicker").enable();
		});
		$("#setDate").click(function () {
			$('#datetimepicker3').data("DateTimePicker").setDate("10/23/2013");
		});
		$("#getDate").click(function () {
			alert($('#datetimepicker3').data("DateTimePicker").getDate());
		});
	});