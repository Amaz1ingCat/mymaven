// $(function(){
	
// 	$("#qyeryBtn").click(function(){
// 		$.ajax({
// 			url:"",
// 			type:"post",
// 			//解决跨域问题 dataType:"jsonp",
// 			data:{
// 				menu:$("#menu").val()
// 				key:"",
				
// 			},
// 			dataType:"jsonp",
			
// 			success:function(res){
// 				console.log(res)
// 			}
			
			
// 		})
// 	})
		
	
	
// })

function query(){
	yourajax({
		url:"json/emps.json",
		type:"get",
		success:function(res){
			for(i in res){
				var emp = res[i]
				console.log(emp.ename)
			}
		}
		
	})
	
}

function yourajax(object){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status== 200){
			var data = JSON.parse(xhr.response);
			object.success(data)
		}
	}
	xhr.open(object.type,object.url)
	xhr.send();
}



function myajax(object,callback){  //callback 回调函数
	var xhr = new XMLHttpRequest();
	//当xhr发哦是那个请求之后,回调处理
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = JSON.parse(xhr.response);
			callback(data)
		}
	}
	
	
}