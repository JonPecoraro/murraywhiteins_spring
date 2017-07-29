function resizeCurrentInsurancePoliciesCheckboxes() {
	// Resize current insurance policies checkboxes if screen size is too small.
	if ($('#nav .navbar-toggle').is(':visible')) {
		$('#currentPoliciesRow span').addClass('display-block')
	} else {
		$('#currentPoliciesRow span').removeClass('display-block')
	}
}

$(function() {
	resizeCurrentInsurancePoliciesCheckboxes();
	$(window).on('resize', resizeCurrentInsurancePoliciesCheckboxes);
});