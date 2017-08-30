/**
 * Member JavaScript
 */
var app=(function(){
	var init=function(ctx){
		session.init(ctx);
		member.init();
		onCreate();
	};
	var ctx=function(){
		return session.getPath('ctx');
	};
	var js =function(){
		return session.getPath('js');
	};
	var img =function(){
		return session.getPath('img');
	};
	var css =function(){
		return session.getPath('css');
	};
	var setContentView=function(){
		location.href=ctx()+"/home.do";		
	};
	var onCreate=function(){
		setContentView();
	};
	return {
		init:init,
		ctx: ctx,
		js : js,
		img: img,
		css: css,
		onCreate:onCreate
	};
})();
var session=(function(){
	var init=function(ctx){
		sessionStorage.setItem('ctx', ctx);
		sessionStorage.setItem('js',ctx+ '/resources/js')
		sessionStorage.setItem('img',ctx+ '/resources/img')
		sessionStorage.setItem('css',ctx+ '/resources/css')
	};
	var getPath=function(x){
		return sessionStorage.getItem(x);
	};
	return {
		init : init,
		getPath : getPath
	};
})();
var member=(function(){
	var init=function(){
		$('#loginBtn').on('click',function(){
			alert('로그인버튼 click');
			if($('#login_id').val() === ""){
				alert('ID구다사이');
				return false;
			}
			if($('#login_pw').val() === ""){
				alert('password구다사이');
				return false;
			}
			$('#login_form').attr('action',app.ctx()+"/common.do");
			$('#login_form').attr('method','post');
			return true;
		});
	};
	var mainLoad=function(){
		
	};
	return {
		init:init
	};
})();
