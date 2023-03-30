$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/board/getBoard.do',
		data: 'pg=' + $('#pg').val() + '&seq=' + $('#seq').val(),
		dataType: 'json',
		success: function(data){
		
		$('#subject').text(data.subject);
		$('tr > td:eq(1)').text('글번호: '+ data.seq);
		$('tr > td:eq(2)').text('작성자: '+ data.id);
		$('tr > td:eq(3)').text('조회수: '+ data.hit);
		$('#content').text(data.content);
			
		},
		error: function(err){
			console.log(err);	
		}
		
	});
});