$(function() {
	$('ul.listing').addClass('connectedSortable').sortable({
		connectWith: ".connectedSortable",
		update: function(event, ui) {
			if (this == ui.item.parent()[0]) {
				var sortedTeamMemberIds = getSortOrder();
				$.ajax({
					url: '/team/admin/sort',
					dataType: 'json',
					method: 'GET',
					data: {
						'ids': sortedTeamMemberIds
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
		var $updateTeamMemberLink = $('<a></a>');
		$updateTeamMemberLink.attr('href', '/team/admin/update?id=' + $this.data('teamMemberId'));
		$updateTeamMemberLink.append($('<span class="glyphicon glyphicon-edit"></span>'));
		$this.prepend($updateTeamMemberLink);
	}, function() {
		$(this).find('span.glyphicon-edit').parent().remove();
	});

	$('a.profileLink').on('click', function(e) {
		e.preventDefault();
	});
	
	function getSortOrder() {
		var sortOrder = []
		$('ul.listing>li').each(function() {
			sortOrder.push($(this).data('teamMemberId'));
		});
		return sortOrder;
	}
});