$(function() {
	$('#propertyAddressSameAsAddress').on('change', function() {
		if ($('#propertyAddressSameAsAddress').is(':checked')) {
			$('#propertyAddress').val('Same as mailing address').addClass('hide');
		} else {
			$('#propertyAddress').val('').removeClass('hide');
		}
	});
});