$(function(){
	
	$.ajax({
		url:"emps.json",
		type:"get",
		success:function(res){
		let	emps = res;
		$table = $("#empsInfo")
			for(i in emps){
				let emp =emps[i]
				$tr = $("<tr></tr>");
				for(j in emp){
					$td = $("<td></td>");
					$td.text(emp[j]);
					$tr.append($td);
				}
				$table.append($tr)
			}
		}
	})
})