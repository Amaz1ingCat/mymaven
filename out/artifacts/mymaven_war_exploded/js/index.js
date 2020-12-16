$(function(){
	
	$("#loginBtn").click(function(){
		$.ajax({
			url:"http://localhost:8888/mymaven/login",
			type:"post",

			data:{
				"username":$("#username").val(),
				"password":$("#password").val()

			},
			success:function(res){
				var result = res;
				if(result.status == 200){
					console.log("成功")
					window.location.href="http://localhost:8888/mymaven/first.html"   //跳转页面
					//存在网页内sessionStorage  只能存字符串
					
					
				}else{
					$("#loginErrMsg").css("color","red").text(result.msg);
				}
			},
		})
		
	})
	
	$("#username").blur(function(){
		
		$.ajax({
			url:"http://localhost:8888/mymaven/userexist",
			type:"post",
			data:{
				"username":$("#username").val()
				
			},
			success:function(res){
				var result = res;
				if(result.status == 201){
					$("#existMsg").css("color","green").text(result.msg);
					
				}else{
					$("#existMsg").css("color","red").text(result.msg);
				}
			}
		})
	})
})
			