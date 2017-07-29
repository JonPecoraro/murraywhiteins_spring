// global variables
var _currentVehicleId = 1;

$(function() {
	// prepend a blank option for the Date of Birth month and year fields
	$('.dateOfBirthMonth').prepend($('<option value="" selected="selected">Month</option>'));
	$('.dateOfBirthYear').prepend($('<option value="" selected="selected">Year</option>'));

	$('#autoQuoteForm').on('submit', function(e) {
		if (autoQuoteIsValid()) {
			// Rename fields to be compatible with the form backed bean
			$autoQuoteForm = $('#autoQuoteForm');
			$autoQuoteForm
				.append('<input type="text" id="driverName" name="driverName" value="" />')
				.append('<input type="text" id="driverBirthday" name="driverBirthday" value="" />')
				.append('<input type="text" id="driverSocial" name="driverSocial" value="" />')
				.append('<input type="text" id="driverLicense" name="driverLicense" value="" />')
				.append('<input type="text" id="driverState" name="driverState" value="" />');
			
			$autoQuoteForm
				.append('<input type="text" id="vehicleYear" name="vehicleYear" value="" />')
				.append('<input type="text" id="vehicleMake" name="vehicleMake" value="" />')
				.append('<input type="text" id="vehicleModel" name="vehicleModel" value="" />')
				.append('<input type="text" id="vehicleVinNumber" name="vehicleVinNumber" value="" />')
				.append('<input type="text" id="vehicleMileage" name="vehicleMileage" value="" />')
				.append('<input type="text" id="vehicleUsage" name="vehicleUsage" value="" />')
				.append('<input type="text" id="vehicleFeatures" name="vehicleFeatures" value="" />');
			

			delimiter = '////';
			$autoQuoteForm.find(':input[name^="firstName_"]').each(function() {
				$this = $(this);
				number = $this.attr('name').split('_')[1]
				$('#driverName').val($('#driverName').val() + delimiter + $this.val() + ' ' +  $('[name="lastName_' + number + '"]').val());
				$('#driverBirthday').val($('#driverBirthday').val() + delimiter + $('#dateOfBirthMonth_' + number).val() + '/' + $('#dateOfBirthDay_' + number).val() + '/' +  $('#dateOfBirthYear_' + number).val());
				$('#driverSocial').val($('#driverSocial').val() + delimiter + $('[name="social_' + number + '"]').val() + ' ');
				$('#driverLicense').val($('#driverLicense').val() + delimiter + $('[name="license_' + number + '"]').val());
				$('#driverState').val($('#driverState').val() + delimiter + $('[name="[state_' + number + '"]').val() + ' ');
			});
			
			$autoQuoteForm.find(':input[name^="year_"]').each(function() {
				$this = $(this);
				number = $this.attr('name').split('_')[1]
				$('#vehicleYear').val($('#vehicleYear').val() + delimiter + $this.val());
				$('#vehicleMake').val($('#vehicleMake').val() + delimiter + $('#make_' + number).val());
				$('#vehicleModel').val($('#vehicleModel').val() + delimiter + $('#model_' + number).val());
				$('#vehicleVinNumber').val($('#vehicleVinNumber').val() + delimiter + $('#vinNumber_' + number).val());
				$('#vehicleMileage').val($('#vehicleMileage').val() + delimiter + $('#mileage_' + number).val());
				$('#vehicleUsage').val($('#vehicleUsage').val() + delimiter + $('#usage_' + number).val() + ' ');
				$('#vehicleFeatures').val($('#vehicleFeatures').val() + delimiter + $('#features_' + number).val() + ' ');
			});
		} else {
			e.preventDefault();
			$('.errorBg').parents('.hide').removeClass('hide');
			window.scrollTo(0, 0);
			return;
		}
	});

	$('#addDriver').on('click', function() {
		var $insuredDrivers = $('#insuredDrivers');
		var $insuredDriversTemplate = $('#insuredDriversTemplate').clone(true);
		var currentDriverId = Number($insuredDriversTemplate.data('driverId'));
		var newDriverId = currentDriverId + 1;
		var $currentDriver = $insuredDrivers.find('.insuredDriver[data-driver-id="' +  currentDriverId + '"] .edit');

		if (driverIsValid(currentDriverId)) {
			updateItemId($insuredDriversTemplate, 0, newDriverId);

			// update cloned template to have correct attributes and class names
			$insuredDriversTemplate
				.data('driverId', newDriverId)
				.attr('data-driver-id', newDriverId)
				.removeAttr('id')
				.removeClass('hide')
				.addClass('insuredDriver');

			// increment the driver id on the template
			$('#insuredDriversTemplate').data('driverId', newDriverId).attr('data-driver-id', newDriverId);

			// get name of the current driver to be used with the read-only view
			var firstName = $('#firstName_' + currentDriverId).val();
			var lastName = $('#lastName_' + currentDriverId).val();

			// hide the current driver and add the new driver
			$currentDriver.addClass('hide');
			$currentDriver.parents('.insuredDriver').find('.readOnly').removeClass('hide').find('span.driverName').text(firstName + ' ' + lastName);
			$insuredDrivers.append($insuredDriversTemplate);
		}
	});

	$('.dateOfBirthMonth').on('change', function() {
		var $this = $(this);
		var $daysInMonthField = $this.parents('.dateOfBirthRow').find('.dateOfBirthDay');
		var month = $this.val();
		var year = (new Date()).getFullYear();

		$daysInMonthField.children().remove();
		
		if (month) {
			/* Note: The month is one based.
			 * Since JavaScript uses a zero based month, but the framework uses a one based month,
			 * we are using the one based month, then getting the zeroth day of the month. This gives us the number of
			 * days in JavaScript format's current month
			*/
			var daysInMonth = (new Date(year, month, 0)).getDate();
			for (var i = 1; i <= daysInMonth; i++) {
				$daysInMonthField.append($('<option></option>').val(i).text(i));
			}
		} else {
			$daysInMonthField.append($('<option value="" selected="">Day</option>'));
		}
	});

	$('div.readOnly .editDriver').on('click', function() {
		var $thisDriver = $(this).parents('.insuredDriver');
		var driverId = $thisDriver.data('driverId');
		if ($thisDriver.find('.edit').is(':visible')) {
			if (driverIsValid(driverId)) {
				$('#firstName_' + driverId).parents('.row:first').removeClass('hide');
				$('#lastName_' + driverId).parents('.row:first').removeClass('hide');
				$thisDriver
					.removeClass('expanded')
					.find('.edit').addClass('hide');
			}
		} else {
			$('#firstName_' + driverId).parents('.row:first').addClass('hide');
			$('#lastName_' + driverId).parents('.row:first').addClass('hide');
			$thisDriver
				.addClass('expanded')
				.find('.edit').removeClass('hide');
		}
	});

	$('div.readOnly .removeDriver').on('click', function() {
		if (confirm('Are you sure you want to remove this driver?')) {
			$(this).parents('.insuredDriver').remove();
		}
	});

	$('#addVehicle').on('click', function() {
		var nextVehicleId = _currentVehicleId + 1;
		var $vehicles = $('#vehicles');
		var $currentVehicle = $vehicles.find('.vehicle[data-vehicle-id="' + _currentVehicleId + '"]');

		if (vehicleIsValid(_currentVehicleId)) {
			var $vehicleTemplate = $currentVehicle.clone(true);
			updateItemId($vehicleTemplate, _currentVehicleId, nextVehicleId);

			// update vehicle template to have correct vehicle ID
			$vehicleTemplate
				.data('vehicleId', nextVehicleId)
				.attr('data-vehicle-id', nextVehicleId)
				.find('input,select,textarea').val('');

			// get year, make, and model for the read-only view
			year = $('#vehicleYear_' + _currentVehicleId).val();
			make = $('#make_' + _currentVehicleId).val();
			model = $('#model_' + _currentVehicleId).val();

			// update current vehicle and add the new vehicle
			// Also hide "year, make, model" row (first row) of vehicle so it can not be changed
			$currentVehicle.find('.editVehicle').addClass('hide').find('.row:first').addClass('hide');
			$currentVehicle.find('.readOnlyVehicle').removeClass('hide').find('span.vehicleDescription').text(year + ' ' + make + ' ' + model);
			$vehicles.append($vehicleTemplate);

			_currentVehicleId++;
		}
	});

	$('div.readOnlyVehicle .editVehicleIcon').on('click', function() {
		$thisVehicle = $(this).parents('.vehicle');
		if ($thisVehicle.hasClass('expanded')) {
			if (!vehicleIsValid($thisVehicle.data('vehicleId'))) {
				return;
			}
		}
		$thisVehicle
			.toggleClass('expanded')
			.find('.editVehicle').toggleClass('hide');
	});

	$('div.readOnlyVehicle .removeVehicle').on('click', function() {
		if (confirm('Are you sure you want to remove this vehicle?')) {
			$(this).closest('.vehicle').remove();
		}
	});
});

function driverIsValid(driverId) {
	var $driver = $('.insuredDriver[data-driver-id="' + driverId + '"]');
	var valid = common.isValid($driver);
	if ($driver.find('.dateOfBirthRow .errorField').length) {
		$driver.find('.dateOfBirthLabel').addClass('errorLabel');
	}
	return valid;
}

function vehicleIsValid(vehicleId) {
	var $vehicle = $('.vehicle[data-vehicle-id="' + vehicleId + '"]');
	return common.isValid($vehicle);
}

function updateItemId($item, oldId, newId) {
	// update item name and id attributes to have the new id
	$item.find('[name$="_' + oldId + '"]').each(function() {
		var $this = $(this);
		var newName = $this.attr('name').split('_')[0] + '_' + newId;
		$this.attr('name', newName);
		if ($this.attr('id')) {
			var newIdText = $this.attr('id').split('_')[0] + '_' + newId;
			$this.attr('id', newIdText);
		}
	});

	// update item "for" attribute to have the new id
	$item.find('label[for$="_' + oldId + '"]').each(function() {
		var $this = $(this);
		var newName = $this.attr('for').split('_')[0] + '_' + newId;
		$this.attr('for', newName);
	});
}

function autoQuoteIsValid() {
	$autoQuoteForm = $('#autoQuoteForm');
	return common.isValid($autoQuoteForm);
}
