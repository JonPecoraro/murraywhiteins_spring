$(function() {	
	$('#logo').on('change', function() {
		var files = $(this).get(0).files;
		if (files && files.length) {
			var file = files[0];
			validateImage(file, 200, 50, $('#companyImage'), $(this));
		}
	});
});

function validateImage(file, width, height, $filedToUpdate, $originator) {
	if (/^image\/\w+/.test(file.type)) {
		var imageUrl = URL.createObjectURL(file);
		var tempImage = new Image;
		$(tempImage).on('load', function() {
			if ((tempImage.width > width - 5 && tempImage.width < width + 5) && (tempImage.height > height - 5 && tempImage.height < height + 5)) {
				if ($filedToUpdate != null) {
					$filedToUpdate.attr('src', imageUrl);
				}
			}
			else {
				$originator.val(null);
				$('#imageWidth').text(width);
				$('#imageHeight').text(height);
				$('#invalidImageSizeModal').modal('show');
			}
		});
		$(tempImage).attr('src', imageUrl);
	} else {
		$originator.val(null);
		$('#invalidImageModal').modal('show');
	}
}