(function(global , $) {
	'use strict';
	var great = global.great || {};
	great.helloWorld = 'Great Hello World!';

	$.each($('.nav>li>a'), function(index, value){
		var contentfile = $(value).attr('href');
		$(value).on('click',function(e){
			e.preventDefault();
			$.get(contentfile, function(data){
				$('#tab-content').html(data);
			});
		});
	});

	great.getListArticleText = function (data){
		var article = '<article>'
					+'<h3><a id="' + data['missionID'] + '" title="take it!">' + data['title'] + '</a></h3>'
					+'<div class="row">'
						+'<div class="col-sm-3">'
							+'<img src="img/001.jpg" class="img-responsive" alt="Cinque Terre">'
						+'</div>'
						+'<div class="col-sm-9">'
							+'<table class="table">'
								+'<tbody>'
									+'<tr>'
										+'<td>地點:</td>'
										+'<td>'+ data['where'] +'</td>'
									+'</tr>'
									+'<tr>'
										+'<td>開始時間:</td>'
										+'<td>'+ data['start_time'] +'</td>'
									+'</tr>'
									+'<tr>'
										+'<td>截止時間:</td>'
										+'<td>'+ data['end_time'] +'</td>'
									+'</tr>'
									+'<tr>'
										+'<td>內容</td>'
										+'<td>'+ data['content'] +'</td>'
									+'</tr>'
								+'</tbody>'
							+'</table>'
						+'</div>'
					+'</div>'
				+'</article>'
				+'<hr>';
				return article;
	}




	global.great = great;
}(this, $));
