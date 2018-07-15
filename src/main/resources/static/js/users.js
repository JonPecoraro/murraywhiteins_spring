$(function() {
   $('a.deleteUser').on('click', function() {
       $('#confirmDeletionLink').attr('href', '/users/admin/delete?id=' + $(this).data('userId'));
	$('#deleteUserModal').modal('show');
   });
});