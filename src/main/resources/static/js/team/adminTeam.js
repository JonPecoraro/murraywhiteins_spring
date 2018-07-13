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
		
		var $deleteTeamMemberLink = $('<a href="#" class="deleteUser"></a>');
		$deleteTeamMemberLink.data('teamMemberId', $this.data('teamMemberId'));
		$deleteTeamMemberLink.append($('<span class="glyphicon glyphicon-trash"></span>'));
		
		$this.prepend($updateTeamMemberLink);
		$this.prepend($deleteTeamMemberLink);
	}, function() {
		var $this = $(this);
		$this.find('span.glyphicon-edit').parent().remove();
		$this.find('span.glyphicon-trash').parent().remove();
	});

	$('a.profileLink').on('click', function(e) {
		e.preventDefault();
	});
	
	$(document).on('click', 'a.deleteUser', function(e) {
		$('#confirmDeletionLink').attr('href', '/team/admin/delete?id=' + $(this).data('teamMemberId'));
		$('#deleteUserModal').modal('show');
	});
	
	function getSortOrder() {
		var sortOrder = []
		$('ul.listing>li').each(function() {
			sortOrder.push($(this).data('teamMemberId'));
		});
		return sortOrder;
	}
});