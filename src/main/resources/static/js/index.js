$(function() {
	$('#appointmentDate').datepicker();
	$('#emailUserAppointmentDetails1').prop('checked', true);
	
	$('#btnRequestAppointment').on('click', function() {
		$('#type').val($('#category').val());
	});
	
	$('#appointmentForm').on('submit', function(e) {
		if (!common.isValid($(this))) {
			e.preventDefault();
			$('.errorBg').parents('.hide').removeClass('hide');
		}
	});
});