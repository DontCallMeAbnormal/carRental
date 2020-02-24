var staffMgContext;//员工管理中心的全局变量,可以缓存,避免频繁访问后台
var userMgContext;//用户中心的全局变量,可以缓存,避免频繁访问后台
var orderMgContext;//订单中心的全局变量,可以缓存,避免频繁访问后台
var baseMgContext;//品牌信息的全局变量,可以缓存,避免频繁访问后台
var vehicleContext;//车库信息全局变量,可以缓存,避免频繁访问后台

var employeeInfoContext;
$(document).ready(function(){
	onpageChage("static/page/employee/emOrderMg.html");
	$.get("getEmployeeInfo",function(data,status){
		employeeInfoContext=data;
		console.log(data);
		console.log(data.employee_name);
		
	    $("#navbar_brand_title").text(data.employee_name);
	  });
})
    
    function onpageChage(src,e){
		$("#action_menu").attr("id"," ");
		$(e).attr("id","action_menu");
    	$("#page-wrapper").load(src,function(responseTxt,statusTxt,xhr){
            if(statusTxt=="success")
            if(statusTxt=="error")
              alert("Error: "+xhr.status+": "+xhr.statusText);
          });
    }


