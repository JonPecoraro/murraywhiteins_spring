$(function() {
	$('ul.listing').addClass('connectedSortable').sortable({
		connectWith: ".connectedSortable",
		update: function(event, ui) {
			if (this == ui.item.parent()[0]) {
				var sortedIds = getSortOrder();
				$.ajax({
					url: '/companies/admin/sort',
					dataType: 'json',
					method: 'GET',
					data: {
						'ids': sortedIds
					}
				}).done(function(data) {
					console.log(data);
				}).fail(function(jqXHR, textStatus, errorThrown) {
					console.log(jqXHR);
					console.log(textStatus);
					console.log(errorThrown);
				});
			}
		}
	}).disableSelection();
	
	$('ul.listing>li').hover(function() {
		var $this = $(this);
		var $updateCompanyLink = $('<a></a>');
		$updateCompanyLink.attr('href', '/companies/admin/update?id=' + $this.data('companyId'));
		$updateCompanyLink.append($('<span class="glyphicon glyphicon-edit"></span>'));
		
		var $deleteCompanyLink = $('<a href="#" class="deleteCompany"></a>');
		$deleteCompanyLink.data('companyId', $this.data('companyId'));
		$deleteCompanyLink.append($('<span class="glyphicon glyphicon-trash"></span>'));
		
		$this.prepend($updateCompanyLink);
		$this.prepend($deleteCompanyLink);
	}, function() {
		var $this = $(this);
		$this.find('span.glyphicon-edit').parent().remove();
		$this.find('span.glyphicon-trash').parent().remove();
	});

	$('a.logoLink').on('click', function(e) {
		e.preventDefault();
	});
	
	$(document).on('click', 'a.deleteCompany', function(e) {
		$('#confirmDeletionLink').attr('href', '/companies/admin/delete?id=' + $(this).data('companyId'));
		$('#deleteCompanyModal').modal('show');
	});
	
	function getSortOrder() {
		var sortOrder = []
		$('ul.listing>li').each(function() {
			sortOrder.push($(this).data('companyId'));
		});
		return sortOrder;
	}
});