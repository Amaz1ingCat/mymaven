// $(function(){
// 	$(".delete").click(function(){
//
// 		var find1 = $(this).parent().parent().find("td:eq(0)").text()
// 		$.ajax({
// 			url:"",
// 			type:"post",
// 			data:{
// 				"empno":find1
// 			},
// 			success:function(res){
// 				var result = res;
// 				if(result.status == 200){
// 					console.log("成功")
// 					window.location.href="http://localhost:8888/mymaven/empbypage"   //跳转页面
// 					//存在网页内sessionStorage  只能存字符串
//
// 				}else{
// 					alert("删除失败")
// 				}
// 			},
// 		})
// 		console.log(find1)
// 	})
// })
//
// // function delete1(){
// // 	var find1 = $(this).parent().parent().find("td:eq(0)").text()
// // 	// &.ajax({
// // 	// 	url:"",
// // 	// 	type:"post",
// // 	// 	data:{
//
// // 	// 	}
// // 	// })
// // 	console.log(find1)
// // }