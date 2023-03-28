//$(function(){});
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/board/getBoardList.do',
		data: 'pg=' + $('#pg').val(), //{'pg': $('#pg').val()}
		dataType: 'json',//서버로 부터 받는 데이터 자료형 'text', 'html', 'xml', 'json' => 객체는 받을 자료형이 없다
				   		 //객체를 json으로 변환시켜서 가져와야 한다
		success: function(data){
			//console.log(JSON.stringify(data));
			//console.log(data.list[0].seq);
			//console.log(data.list[1].name);
			
			$.each(data.list, function(index, items){
				console.log(index + ", seq=" + items.seq + ', name' + items.name);
				
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
				})).append($('<td/>',{
					text:items.subject
				})).append($('<td/>',{
					align: 'center',
					text: items.name
				})).append($('<td/>',{
					align: 'center',
					text: items.logtime
				})).append($('<td/>',{
					align: 'center',
					text: items.hit
				})).appendTo($('#boardListTable'))
			});
		},
		error: function(err){
			console.log(err);
		}		   		 
	});
});