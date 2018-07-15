$(function() {
	var image = $('#image').get(0);
	var options = {
		autoCropArea: 1
	};
	var cropper = new Cropper(image, options);
	
	$('#imageInput').on('change', function() {
		var files = $(this).get(0).files;
		if (files && files.length) {
			var file = files[0];
			if (/^image\/\w+/.test(file.type)) {
				var imageUrl = URL.createObjectURL(file);
				$('#image').attr('src', imageUrl);
				cropper.destroy();
				cropper = new Cropper(image, options);
				$('#toolbarButtons').removeClass('hidden');
			} else {
				$('#invalidImageModal').modal('show');
			}
			$(this).val(null);
		}
	});
	
	$('.imageCrop').on('click', function() {
		var $this = $(this);
		var width = $this.data('width');
		var height = $this.data('height');
		var croppedImage;
		if (width && height) {
			croppedImage = cropper.getCroppedCanvas({
				width: width,
				height: height,
				fillColor: '#FFF'
			});
		} else {
			var cropBoxData = cropper.getCropBoxData();
			width = cropBoxData.width;
			height = cropBoxData.height;
			croppedImage = cropper.getCroppedCanvas({
				width: width,
				height: height,
				fillColor: '#FFF'
			});
		}
		
		if (croppedImage) {
			var $croppedImageModal = $('#croppedImageModal');
			if (width > $croppedImageModal.find('.modal-dialog').width()) {
				$('#croppedImageModal .modal-dialog').width(width + 20);
			}
			$croppedImageModal
				.find('.modal-body').html(croppedImage).end()
				.modal('show');
			
			$('#download').attr('href', croppedImage.toDataURL('image/jpeg'));
		}
	});

	$('#imageForm').on('submit', function(e) {
		var imageData = cropper.getImageData();
		var croppedImage = cropper.getCroppedCanvas({
			width: imageData.width,
			height: imageData.height,
			fillColor: '#FFF'
		});
		$('#preview').empty().html(croppedImage);
		e.preventDefault();
	});
});