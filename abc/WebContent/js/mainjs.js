$(document).ready(function() {

	/* 로그인 버튼 */
	$("#login_main").on("click", function() {
		$(".login_f").animate({
			top : "-30px"
		}, 500);
		return false;
	});

	$(".login_f p a:nth-of-type(3), .login-button").on("click", function() {
		$(".login_f").animate({
			top : "-1000px"
		}, 500);
		return false;
	});

	
	
	//POTG
	var list_i = $("#inner_list li");
	
	$(list_i).on("click",function(){
		var test = $(">iframe", this).attr('src');
		$("#cinematic p iframe").prop("src",test+"?&autoplay=1");
		return false;
	});
	
	  //퀵메뉴
	  var defaultTop=parseInt($("#quick_menu").css("top"));
	  $(window).on("scroll",function(){
	     var kkk=$(window).scrollTop();

	     $("#quick_menu").stop().animate({top:kkk+defaultTop+"px"},500);
	  });
	  
	  
	  /*팝업 연동*/
	  var defaultTop=parseInt($("#pop_wrap").css("top"));
	  
		     
		if ($.cookie("pop") != "no")
			$("#pop_wrap").show();
		
		$("#pop_wrap").css("cursor", "move").draggable();

		
		$("#pop_wrap area:eq(0)").on("click", function() {
			$("#pop_wrap").fadeOut("fast");
			return false;
		});

		$("#pop_wrap area:eq(1)").on("click", function() {
			$.cookie("pop", "no", {
				//기간 1일
				expires : 1
			});
			$("#pop_wrap").fadeOut("fast");
			return false;
		});
		
		$(window).on("scroll",function(){
		     var scv=$(window).scrollTop();
		
		$("#pop_wrap area:eq(0)").on("click", function() {
			$("#pop_wrap").fadeOut("fast");
			return false;
		});

		$("#pop_wrap area:eq(1)").on("click", function() {
			$.cookie("pop", "no", {
				//기간 1일
				expires : 1
			});
			$("#pop_wrap").fadeOut("fast");
			return false;
		});
		
		
		
		$("#pop_wrap").stop().animate({top:scv+defaultTop+"px"},500);
		
	  });
		
		//슬라이드
		$("#number_slideshow").number_slideshow({
			slideshow_autoplay : 'disable',//enable disable
			slideshow_time_interval : 3000,
			slideshow_window_background_color : "#fff",
			slideshow_window_padding : '1',
			slideshow_window_width : '998',
			slideshow_window_height : '170',
			slideshow_border_size : '1',
			slideshow_transition_speed : 500, //'normal','slow','fast' or numeral
			slideshow_border_color : '#99ccff',
			slideshow_show_button : 'enable',//enable disable
			slideshow_show_title : 'disable',//enable disable
			slideshow_button_text_color : '#CCC',
			slideshow_button_current_text_color : '#000',
			slideshow_button_background_color : '#333',
			slideshow_button_current_background_color : '#666',
			slideshow_button_border_color : '#000',
			slideshow_loading_gif : 'loading.gif',//loading pic, you can replace it.
			slideshow_button_border_size : '1'
		});
		
		
});
